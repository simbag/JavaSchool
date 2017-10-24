package ru.sbt.bit.ood.solid.homework;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SalaryHtmlReportNotifier {

    private final static String SQL_STATEMENT =
            "select   emp.id      as emp_id" +
                    ",emp.name    as amp_name" +
                    ",sum(salary) as salary " +
            "from employee emp left join salary_payments sp on emp.id = sp.employee_id " +
            "where emp.department_id =  ? " +
              "and sp.date           >= ? " +
              "and sp.date           <= ? " +
            "group by emp.id, emp.name";

    private Connection connection;

    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;
    }

    public ResultSet getReportData(String departmentId, LocalDate dateFrom, LocalDate dateTo) throws SQLException {

        PreparedStatement ps = connection.prepareStatement(SQL_STATEMENT);

        ps.setString(0, departmentId);
        ps.setDate(1, new java.sql.Date(dateFrom.toEpochDay()));
        ps.setDate(2, new java.sql.Date(dateTo.toEpochDay()));

        return ps.executeQuery();

    }

    public String generateHtmlReport(ResultSet results) throws SQLException {
        StringBuilder resultingHtml = new StringBuilder();

        resultingHtml.append("<html>" +
                                "<body>" +
                                    "<table>" +
                                        "<tr>" +
                                            "<td>Employee</td>" +
                                            "<td>Salary</td>" +
                                        "</tr>");
        double totals = 0;
        while (results.next()) {
            resultingHtml.append("<tr>");
            resultingHtml.append("<td>").append(results.getString("emp_name")).append("</td>");
            resultingHtml.append("<td>").append(results.getDouble("salary")).append("</td>");
            resultingHtml.append("</tr>");
            totals += results.getDouble("salary");
        }
        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");

        return resultingHtml.toString();
    }


    public void sendReport(String host, String recipients, String report) {
        try {
            MailSender.sendHTMLMessage(host, report, "Monthly department salary report", recipients);
        } catch (MessagingException e) {
            System.out.println("Произошла ошибка при отправке отчёта!");
        }
    }

}