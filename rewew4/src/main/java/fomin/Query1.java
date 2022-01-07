package fomin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*ошибки в расписании (фильмы накладываются друг на друга),
        отсортированные по возрастанию времени. Выводить надо колонки «фильм 1»,
         «время начала», «длительность», «фильм 2», «время начала», «длительность»;*/
public class Query1 {

    public static void doIt(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select f.\"name\" as \"фильм1\", \n" +
                "    s.\"date\" as \"время начала\",  \n" +
                "    f.time_film as \"длительность\",  \n" +
                "    t.\"name\" as \"фильм 2\",  \n" +
                "    t.start_time as \"время начала\",  \n" +
                "    t.time_film as \"длительность\"  \n" +
                "from films f  \n" +
                " inner join sessions s on s.film_id = f.id \n" +
                " cross join (select  \n" +
                "     f.id, \n" +
                "     f.time_film, \n" +
                "     f.\"name\", \n" +
                "     s.\"date\" as start_time,  \n" +
                "     (s.\"date\" + f.time_film * interval '1 minute') as end_time  \n" +
                "    from films f  \n" +
                "     inner join sessions s on s.film_id = f.id) as t \n" +
                "where f.id <> t.id  \n" +
                "   and s.\"date\" > t.start_time  \n" +
                "   and s.\"date\" < t.end_time \n" +
                "order by s.\"date\";");

        System.out.println("\"Film1\"||\"Start\"||\"Long\"||\"Film2\"||\"Start\"||\"Long\"");
        while (resultSet.next()) {
            System.out.printf("%s||%s||%d||%s||%s||%d\n",
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6));
        }
    }

}
