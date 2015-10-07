package distance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceCalculatorTest {

    @Test
    public void calculateDistanceSPRJKmTest(){
        DistanceCalculator calculator = DistanceCalculator.createDefault();
        City sp = CityDataBuilder.createSaoPaulo();
        City rj = CityDataBuilder.createRioDeJaneiro();
        Distance distance = calculator.calculateDistance(sp, rj);

        //361.150 kilometers
        //224.410 miles

        assertEquals(361.150, distance.getUnits(), 0.01);
    }

    @Test
    public void calculateDistanceSPBRKmTest(){
        DistanceCalculator calculator = DistanceCalculator.createDefault();
        City sp = CityDataBuilder.createSaoPaulo();
        City rj = CityDataBuilder.createBrasilia();
        Distance distance = calculator.calculateDistance(sp, rj);

        //1176.890 kilometers
        //731.290 miles

        assertEquals(1176.890, distance.getUnits(), 0.01);
    }

    @Test
    public void calculateDistanceRJBRKmTest(){
        DistanceCalculator calculator = DistanceCalculator.createDefault();
        City sp = CityDataBuilder.createSaoPaulo();
        City rj = CityDataBuilder.createBrasilia();
        Distance distance = calculator.calculateDistance(sp, rj);

        //1335.120 kilometers
        //829.60 miles

        assertEquals(1335.120, distance.getUnits(), 0.01);
    }

}
