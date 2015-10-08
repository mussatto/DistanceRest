package distance.dao;

import distance.calc.City;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This test requires to setup the docker VM (on scripts/setup_docker.sh)
 * and run sql/dml/insert_city.sql in the MySQL database
 *
 */
public class CityDAOIntegrationTest {

    private CityDAO cityDAO;

    @Before
    public void setup(){
        this.cityDAO=new CityDAO();
    }

    @Test
    public void retrieveSaoPaulo() throws SQLException, ClassNotFoundException, DatabaseInconsistencyException {
        String cityName = "Sao Paulo";
        City city = cityDAO.findByName(cityName);
        assertNotNull(city);
        assertEquals(city.getName(), cityName);
    }

    @Test
    public void retrieveAll() throws SQLException, ClassNotFoundException, DatabaseInconsistencyException {
        List<City> cities = cityDAO.findAll();

        assertNotNull(cities);
        assertNotEquals(0, cities);
        //assertEquals(6, cities.size());
    }

    @Test
    public void insertDeleteTest() throws DatabaseInconsistencyException {
        String name = "Some Random City";
        City someCity = City.create(0.0, 0.0, name);

        cityDAO.insert(someCity);

        City someCityFound = cityDAO.findByName(name);

        assertEquals(name, someCityFound.getName());

        cityDAO.delete(someCity);

    }


}
