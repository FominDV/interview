package ru.fomin;

import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = new SqlConnector().getConnection();
    }

}
