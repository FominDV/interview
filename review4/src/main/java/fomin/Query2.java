package fomin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
 Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;*/
public class Query2 {

    public static void doIt(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select \n" +
                "\tf.name as \"Фильм1\",\n" +
                "\ts.date as \"время начала\",\n" +
                "\tf.time_film as \"длительность\",\n" +
                "\tf2.date as \"время начала второго фильма\",\n" +
                "\t(f2.date - s.\"date\" - f.time_film * interval '1 minute') as \"длительность перерыва\"\n" +
                "\tfrom films f\n" +
                "\tinner join sessions s on f.id = s.film_id\n" +
                "\tcross join (\n" +
                "\tselect\n" +
                "\t\ts.\"date\"\n" +
                "\t\tfrom films f\n" +
                "\t\tinner join sessions s on f.id = s.film_id\n" +
                "\t) as f2 \n" +
                "\twhere f2.date - s.\"date\" - f.time_film * interval '1 minute'>30* interval '1 minute'\n" +
                "\torder by \"длительность перерыва\" desc;");

        System.out.println("film||start||long||start2||timeout");
        while (resultSet.next()) {
            System.out.printf("%s||%s||%d||%s||%s\n",
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5));
        }
    }


}
