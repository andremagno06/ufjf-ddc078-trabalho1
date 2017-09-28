package br.com.ufjf.dcc078.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ana Carolina Fidelis Gonçalves <acarolinafg@gmail.com>
 */
public class DatabaseLocator {

    public static DatabaseLocator instance = null;

    private DatabaseLocator() {

    }

    public static DatabaseLocator getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new DatabaseLocator();
        }
        return instance;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn
                = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/hotel", "root", "");
        return conn;
    }
}
