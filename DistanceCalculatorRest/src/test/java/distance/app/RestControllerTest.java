package distance.app;



import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RestControllerTest {

    private RestController controller;

    @Before
    public void setup(){
        this.controller = new RestController();
    }

    @Test
    public void distanceSPRJRestTest(){
        Double distance = controller.distance("Sao Paulo", "Rio de Janeiro", "KM");
        assertEquals(332.6, distance, 0.3);
    }

    @Test
    public void distanceSPBRRestTest(){
        Double distance = controller.distance("Sao Paulo", "Brasilia", "KM");
        assertEquals(896.3, distance, 0.3);
    }

    @Test
    public void distanceRJBRRestTest(){
        Double distance = controller.distance("Brasilia", "Rio de Janeiro", "KM");
        assertEquals(927.7, distance, 0.3);
    }


}
