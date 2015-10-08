package distance.dao;

import distance.calc.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {

    private Connection connect = null;

    public void connect() throws ClassNotFoundException, SQLException {
        String host = "192.168.99.100";
        String user = "root";
        String pass = "distance";
        String database = "distance";
        String port = "3306";
        String connString = "jdbc:mysql://"+host+":"+port+"/"+database+"?user="+user+"&password="+pass;

        Class.forName("com.mysql.jdbc.Driver");

        connect = DriverManager.getConnection(connString);

        Statement statement = connect.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from CITY");
        List<City> cities = new ArrayList<City>();
        while (resultSet.next()){
            String name = resultSet.getString("NAME");
            Double latitude = resultSet.getDouble("LATITUDE");
            Double longitude = resultSet.getDouble("LONGITUDE");

            cities.add(City.create(latitude, longitude, name));
        }

        System.out.println(cities);
    }
}
