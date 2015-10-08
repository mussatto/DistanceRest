package distance.dao;

import distance.calc.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {


    public static final String INSERT = " INSERT INTO CITY(LATITUDE, LONGITUDE, NAME) VALUES (?,?,? )";
    public static final String CANNOT_BE_NULL = "Cannot be null";
    public static final String DELETE = " DELETE FROM CITY WHERE NAME=? ";
    public static final String SELECT_ALL = "select * from CITY";
    public static final String SELECT_BY_NAME = "select NAME, LATITUDE, LONGITUDE from CITY WHERE NAME = ?";
    public static final String NAME_COLUMN = "NAME";
    public static final String LATITUDE_COLUMN = "LATITUDE";
    public static final String LONGITUDE_COLUMN = "LONGITUDE";

    public City findByName(String cityName) throws DatabaseInconsistencyException {

        try (Connection connection = DriverManager.getConnection(DatabaseConnection.getConnectionString())){

            PreparedStatement statement =
                    connection.prepareStatement(SELECT_BY_NAME);
            statement.setString(1, cityName);

            ResultSet resultSet = statement.executeQuery();
            List<City> cities = new ArrayList<>();

            while (resultSet.next()){
                String name = resultSet.getString(NAME_COLUMN);
                Double latitude = resultSet.getDouble(LATITUDE_COLUMN);
                Double longitude = resultSet.getDouble(LONGITUDE_COLUMN);

                cities.add(City.create(latitude, longitude, name));
            }

            if(cities.size()==0)
                return null;

            else if(cities.size()>1)
                throw new DatabaseInconsistencyException();

            else return cities.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<City> findAll() {
        try (Connection connection = DriverManager.getConnection(DatabaseConnection.getConnectionString())) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            List<City> cities = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString(NAME_COLUMN);
                Double latitude = resultSet.getDouble(LATITUDE_COLUMN);
                Double longitude = resultSet.getDouble(LONGITUDE_COLUMN);

                cities.add(City.create(latitude, longitude, name));
            }

            return cities;
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(City city){
        if(city==null || city.getCoordinates()==null){
            throw new IllegalArgumentException(CANNOT_BE_NULL);
        }

        try (Connection connection = DriverManager.getConnection(DatabaseConnection.getConnectionString())) {

            PreparedStatement statement =
                    connection.prepareStatement(INSERT);
            statement.setDouble(1, city.getCoordinates().getLatitude());
            statement.setDouble(2, city.getCoordinates().getLongitude());
            statement.setString(3, city.getName());
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(City city){
        if(city==null || city.getCoordinates()==null){
            throw new IllegalArgumentException(CANNOT_BE_NULL);
        }

        try (Connection connection = DriverManager.getConnection(DatabaseConnection.getConnectionString())) {

            PreparedStatement statement =
                    connection.prepareStatement(DELETE);
            statement.setString(1, city.getName());
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
