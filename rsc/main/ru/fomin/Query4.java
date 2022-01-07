package ru.fomin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query4 {

    public static void doIt(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("(select \n" +
                "'9.00-15.00' as \"время\",\n" +
                "count(t.id) as \"количество билетов\",\n" +
                "COALESCE( sum(t.price),0) as \"выручка\"\n" +
                "from sessions s \n" +
                "left join tickets t on t.session_id =s.id\n" +
                "where extract(hour from s.\"date\") between 9 and 14)\n" +
                "union\n" +
                "(select \n" +
                "'15.00-18.00',\n" +
                "count(t.id),\n" +
                "COALESCE( sum(t.price),0)\n" +
                "from sessions s \n" +
                "left join tickets t on t.session_id =s.id\n" +
                "where extract(hour from s.\"date\") between 15 and 17)\n" +
                "union \n" +
                "(select \n" +
                "'18.00-21.00',\n" +
                "count(t.id),\n" +
                "COALESCE( sum(t.price),0)\n" +
                "from sessions s \n" +
                "left join tickets t on t.session_id =s.id\n" +
                "where extract(hour from s.\"date\") between 18 and 20)\n" +
                "union \n" +
                "(select \n" +
                "'21.00-00.00',\n" +
                "count(t.id),\n" +
                "COALESCE( sum(t.price),0)\n" +
                "from sessions s \n" +
                "left join tickets t on t.session_id =s.id\n" +
                "where extract(hour from s.\"date\") between 21 and 23)");

        System.out.println("time||tickets||cash");
        while (resultSet.next()) {
            System.out.printf("%s||%d||%f\n",
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getDouble(3));
        }
    }

}
