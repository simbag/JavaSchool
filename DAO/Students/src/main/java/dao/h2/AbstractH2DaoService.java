package dao.h2;


import exceptions.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractH2DaoService {

    public static final String CONNECT_URL = "jdbc:h2:tcp://localhost/~/test";

    protected Connection getConnection(String url) throws DaoException {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(CONNECT_URL,"sa",null);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver exception!");
            e.printStackTrace();
            throw new DaoException("Driver exception",e);
        } catch (SQLException e) {
            System.out.println("Can't get connection!");
            e.printStackTrace();
            throw new DaoException("Can't get connection!",e);
        }
    }
}
