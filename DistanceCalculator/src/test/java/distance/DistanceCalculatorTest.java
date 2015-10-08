package distance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceCalculatorTest {
    //reference: http://www.movable-type.co.uk/scripts/latlong.html
    @Test
    public void calculateDistanceSPRJKmTest(){
        DistanceCalculator calculator = DistanceCalculator.createDefault();
        City sp = CityDataBuilder.createSaoPaulo();
        City rj = CityDataBuilder.createRioDeJaneiro();
        Distance distance = calculator.calculateDistance(sp, rj);

        assertEquals(332.6, distance.getUnits(), 0.3);
    }

    @Test
    public void calculateDistanceSPBRKmTest(){
        DistanceCalculator calculator = DistanceCalculator.createDefault();
        City sp = CityDataBuilder.createSaoPaulo();
        City br = CityDataBuilder.createBrasilia();
        Distance distance = calculator.calculateDistance(sp, br);

        assertEquals(896.3, distance.getUnits(), 0.3);
    }

    @Test
    public void calculateDistanceRJBRKmTest(){
        DistanceCalculator calculator = DistanceCalculator.createDefault();
        City rj = CityDataBuilder.createRioDeJaneiro();
        City br = CityDataBuilder.createBrasilia();
        Distance distance = calculator.calculateDistance(rj, br);

        assertEquals(927.7, distance.getUnits(), 0.3);
    }

}
