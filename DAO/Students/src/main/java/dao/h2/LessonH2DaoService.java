package dao.h2;

import dao.LessonDaoService;
import dao.h2.exceptions.LessonDaoException;
import domain.Lesson;
import exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LessonH2DaoService extends AbstractH2DaoService implements LessonDaoService {

    public Lesson getLessonById(Integer id) throws DaoException {
        try (Connection connection = getConnection(CONNECT_URL);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LESSONS WHERE id = ?");) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            int i = 0;
            Lesson lesson = null;

            while (resultSet.next()) {

                if (i++ > 1) {
                    throw new LessonDaoException("Query returns more then one row!");
                }

                lesson = new Lesson();
                lesson.setId(resultSet.getInt("id"));
                lesson.setName(resultSet.getString("name"));
                lesson.setDate(resultSet.getDate("date"));
            }

            if (lesson == null) {
                throw new DaoException("Lesson not found id = " + id);
            }

            if (!resultSet.isClosed()) {
                resultSet.close();
            }

            return lesson;

        } catch (SQLException e) {
            throw new DaoException("Get lesson exception", e);
        }
    }
}

