package distance;

public class DistanceCalculator {

    private final DistanceCalculatorMethod distanceCalculatorMethod;

    private final MeasureUnit measureUnit;

    public static DistanceCalculator createDefault(){
        return new DistanceCalculator(new HaversineDistanceCalculator(), MeasureUnit.KM);
    }

    public static DistanceCalculator createInMiles(){
        return new DistanceCalculator(new HaversineDistanceCalculator(), MeasureUnit.MI);
    }

    private DistanceCalculator(DistanceCalculatorMethod distanceCalculatorMethod,
                               MeasureUnit measureUnit){
        this.measureUnit=measureUnit;
        this.distanceCalculatorMethod=distanceCalculatorMethod;
    }

    public Distance calculateDistance(City from, City to){
        return calculateDistance(from,to, measureUnit);
    }

    public Distance calculateDistance(City from, City to, MeasureUnit measureUnit){

        double distanceKM = distanceCalculatorMethod.calculateDistance(from.getCoordinates(),
                to.getCoordinates(), measureUnit);
        return new Distance(distanceKM, measureUnit);
    }
    
}
