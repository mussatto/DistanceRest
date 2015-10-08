package distance.dao;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class DatabaseConnectionTest {

    @Test
    public void stringTest() throws SQLException, ClassNotFoundException {
        String connectionURL = DatabaseConnection.getConnectionString();
        assertNotNull(connectionURL);
    }
}
