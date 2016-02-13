package util;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.StringMapper;

import java.util.List;

public class DatabaseHelper {
    private static String dbUrl = "connectionUrl";
    private static String username = "username";
    private static String password = "password";

    public static Handle setUpConnection(){
        DBI dbi = new DBI(dbUrl, username, password);
        org.skife.jdbi.v2.Handle h = dbi.open();
        return h;
    }

    public static String getStringValues(String query){
        Handle h = setUpConnection();
        String value = h.createQuery(query).map(StringMapper.FIRST).first();
        return value;
    }

    public static List<String> getListOfStrings(String query){
        Handle h = setUpConnection();
        List<String> rs = h.createQuery(query).map(StringMapper.FIRST).list();
        return rs;
    }

    public static void update(String query){
        Handle h = setUpConnection();
        h.update(query);
    }
}
