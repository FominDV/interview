package ru.fomin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = SqlConnector.getConnection();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS films(\n" +
                    "id bigserial primary key,\n" +
                    "name varchar(100) not null unique,\n" +
                    "time_film integer);");
            statement.execute("create table IF NOT EXISTS prices (\n" +
                    "id bigserial primary key,\n" +
                    "cost bigint not null,\n" +
                    "film_id bigint not null references films (id));");
            connection.commit();
        } catch (Exception exception) {
            connection.rollback();
        }
    }

}
