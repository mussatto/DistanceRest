package distance;

public class DistanceCalculator {

    public static DistanceCalculator createDefault(){
        return new DistanceCalculator();
    }

    private DistanceCalculator(){

    }

    public Distance calculateDistance(City from, City to){


        return new Distance(0, MeasureUnit.KM);
    }
    
}
