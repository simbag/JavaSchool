package dao.h2;

import dao.StudentVisitDaoService;
import domain.Student;
import domain.StudentVisit;
import exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentVisitH2DaoService extends AbstractH2DaoService implements StudentVisitDaoService {

    public List<StudentVisit> getVisitsByStudent(int studentId) throws DaoException {
        try (Connection connection = getConnection(CONNECT_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM STUDENT_VISITS WHERE student_id = ?")
        ) {
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();

            List<StudentVisit> visits = new ArrayList<>();
            while (resultSet.next()) {
                StudentVisit visit = new StudentVisit();


                visit.setId(resultSet.getInt("id"));
                visit.setStudentId(resultSet.getInt("student_id"));
                visit.setLessonId(resultSet.getInt("lesson_id"));



                visits.add(visit);
            }

            if (!resultSet.isClosed()) {
                resultSet.close();
            }

            return visits;


        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Get visits for student exception", e);
        }
    }

    public List<StudentVisit> getVisitsByLesson(int lessonId) throws DaoException {
        try (Connection connection = getConnection(CONNECT_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM STUDENT_VISITS WHERE lesson_id = ?")
        ) {
            statement.setInt(1, lessonId);
            ResultSet resultSet = statement.executeQuery();

            List<StudentVisit> visits = new ArrayList<>();
            while (resultSet.next()) {
                StudentVisit visit = new StudentVisit();

                visit.setId(resultSet.getInt("id"));
                visit.setStudentId(resultSet.getInt("student_id"));
                visit.setLessonId(resultSet.getInt("lesson_id"));

                visits.add(visit);
            }

            if (!resultSet.isClosed()) {
                resultSet.close();
            }

            return visits;


        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Get visits for lesson exception", e);
        }
    }

    public List<StudentVisit> getAllVisits() throws DaoException {
        try (Connection connection = getConnection(CONNECT_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM STUDENT_VISITS")
        ) {
            ResultSet resultSet = statement.executeQuery();

            List<StudentVisit> visits = new ArrayList<>();
            while (resultSet.next()) {
                StudentVisit visit = new StudentVisit();

                visit.setId(resultSet.getInt("id"));
                visit.setStudentId(resultSet.getInt("student_id"));
                visit.setLessonId(resultSet.getInt("lesson_id"));

                visits.add(visit);
            }

            if (!resultSet.isClosed()) {
                resultSet.close();
            }

            return visits;


        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Get visits exception", e);
        }
    }
}
