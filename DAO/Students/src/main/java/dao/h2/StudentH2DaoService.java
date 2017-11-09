package dao.h2;

import dao.StudentDaoService;
import dao.h2.exceptions.StudentDaoException;
import domain.Student;
import exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentH2DaoService extends AbstractH2DaoService implements StudentDaoService {

    public Student getStudentById(Integer id) throws DaoException {
        try (Connection connection = getConnection(CONNECT_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM SCHOOL.STUDENTS WHERE id = ?");
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            int i = 0;
            Student student = null;
            while (resultSet.next()) {

                if (i++ > 0) {
                    throw new StudentDaoException("Query returns more then one row");
                }

                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setAge(resultSet.getInt("age"));
            }

            if (student == null) {
                throw new DaoException("Student not found id = " + id);
            }

            if (!resultSet.isClosed()) {
                resultSet.close();
            }

            return student;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Get student exception", e);
        }
    }
}
