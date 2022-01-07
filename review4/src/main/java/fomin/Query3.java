package fomin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*список фильмов, для каждого — с указанием общего числа посетителей за все время,
 среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
 Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;*/
public class Query3 {

    public static void doIt(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("(select\n" +
                "\tf.\"name\" as \"фильм\",\n" +
                "\tsum(pl) as \"посетителей\",\n" +
                "\tsum(pl)/ count(ses) as \"за сеанс зрителей\",\n" +
                "\tsum(ts.sm) as \"приход\"\n" +
                "from\n" +
                "films f\n" +
                "\tleft join (\n" +
                "\tselect\n" +
                "\t\ts.film_id ,\n" +
                "\t\ts.id as ses,\n" +
                "\t\tcount(t.id) as pl,\n" +
                "\t\tCOALESCE( sum(t.price),0) as sm\n" +
                "\tfrom\n" +
                "\t\tsessions s\n" +
                "\tleft join tickets t\n" +
                "\ton s.id = t.session_id\n" +
                "\tgroup by\n" +
                "\t\ts.film_id,\n" +
                "\t\ts.id) ts \n" +
                "\t\ton f.id = ts.film_id\n" +
                "group by\n" +
                "ts.film_id, f.\"name\" \n" +
                "order by \"приход\" desc)\n" +
                "union all\n" +
                "(select\n" +
                "\t'итого',\n" +
                "\tcount(t),\n" +
                "\tcount(t)/count(s)::real,\n" +
                "\tsum(t.price)\n" +
                "from films f \n" +
                "\tleft join sessions s on s.film_id = f.id\n" +
                "\tleft join tickets t on t.session_id = s.id);");

        System.out.println("film||customers||session-customers||cash");
        while (resultSet.next()){
            System.out.printf("%s||%d||%f||%f\n",
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getDouble(3),
                    resultSet.getDouble(4));
        }
    }

}
