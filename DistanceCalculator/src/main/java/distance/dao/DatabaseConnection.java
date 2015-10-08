package distance.dao;

import java.sql.SQLException;

public class DatabaseConnection {

    public static String getConnectionString() throws ClassNotFoundException, SQLException {
        String host = "192.168.99.100";
        String user = "distance";
        String pass = "distance";
        String database = "distance";
        String port = "3306";
        String connString = "jdbc:mysql://"+host+":"+port+"/"+database+"?user="+user+"&password="+pass;

        Class.forName("com.mysql.jdbc.Driver");

        return connString;
    }
}
