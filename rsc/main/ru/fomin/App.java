package ru.fomin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = new SqlConnector().getConnection();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("create table films (\n" +
                    "id bigserial primary key,\n" +
                    "name varchar(100) not null unique,\n" +
                    "time_film interval not null)");

            connection.commit();
        } catch (Exception exception) {
            connection.rollback();
        }
    }

}
