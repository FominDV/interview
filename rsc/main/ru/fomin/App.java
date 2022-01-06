package ru.fomin;

import java.sql.*;
import java.time.LocalDateTime;

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
            statement.execute("CREATE TABLE IF NOT EXISTS sessions(\n" +
                    "id bigserial primary key,\n" +
                    "date TimeStamp not null,\n" +
                    "film_id bigint not null references films (id));");
            statement.execute("create table IF NOT EXISTS tickets (\n" +
                    "id bigserial primary key,\n" +
                    "price bigint not null,\n" +
                    "sold boolean,\n" +
                    "session_id bigint not null references sessions (id));");

            PreparedStatement preparedStatement = connection.prepareStatement("Insert into films (name, time_film) values (?,?)");
            preparedStatement.setString(1, "Rambo");
            preparedStatement.setInt(2, 60);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "Horror");
            preparedStatement.setInt(2, 60);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "Blade");
            preparedStatement.setInt(2, 90);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "Lord of the ring");
            preparedStatement.setInt(2, 120);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "Remember all");
            preparedStatement.setInt(2, 120);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();

            preparedStatement = connection.prepareStatement("Insert into sessions (date, film_id) values (?,?)");
            preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setLong(2, 1);
            preparedStatement.addBatch();
            preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now().minusMinutes(30)));
            preparedStatement.setLong(2, 2);
            preparedStatement.addBatch();
            preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now().minusMinutes(67)));
            preparedStatement.setLong(2, 3);
            preparedStatement.addBatch();
            preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now().plusHours(1)));
            preparedStatement.setLong(2, 4);
            preparedStatement.addBatch();
            preparedStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now().plusMinutes(45)));
            preparedStatement.setLong(2, 5);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();


            preparedStatement = connection.prepareStatement("Insert into tickets (price, sold, session_id) values (?,?,?)");
            preparedStatement.setLong(1, 600);
            preparedStatement.setBoolean(2, true);
            preparedStatement.setLong(3, 1);
            preparedStatement.addBatch();
            preparedStatement.setLong(1, 450);
            preparedStatement.setBoolean(2, true);
            preparedStatement.setLong(3, 2);
            preparedStatement.addBatch();
            preparedStatement.setLong(1, 300);
            preparedStatement.setBoolean(2, true);
            preparedStatement.setLong(3, 4);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();

            connection.commit();
        } catch (Exception exception) {
            connection.rollback();
        }

        /*ошибки в расписании (фильмы накладываются друг на друга),
         отсортированные по возрастанию времени. Выводить надо колонки «фильм 1»,
          «время начала», «длительность», «фильм 2», «время начала», «длительность»;*/
        Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("select name, date, time_film from films inner join sessions on films.id=sessions.id order by date;");

    }

}
