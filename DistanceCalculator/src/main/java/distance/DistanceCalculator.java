package distance;

public class DistanceCalculator {

    private DistanceCalculatorMethod distanceCalculatorMethod;

    public static DistanceCalculator createDefault(){
        return new DistanceCalculator(new HaversineDistanceCalculator());
    }

    private DistanceCalculator(DistanceCalculatorMethod distanceCalculatorMethod){
        this.distanceCalculatorMethod=distanceCalculatorMethod;
    }

    public Distance calculateDistance(City from, City to){
        double distanceKM = distanceCalculatorMethod.calculateDistance(from.getCoordinates(),to.getCoordinates());
        return new Distance(distanceKM, MeasureUnit.KM);
    }
    
}
