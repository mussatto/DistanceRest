package distance;

public class BearingDistanceCalculator implements DistanceCalculatorMethod{

    @Override
    public double calculateDistance(Coordinates from, Coordinates to, MeasureUnit measureUnit) {

        double longDiff= to.getLongitude()- from.getLongitude();
        double y = Math.sin(longDiff)*Math.cos(to.getLatitude());
        double x = Math.cos(from.getLatitude())*Math.sin(to.getLatitude())
                -Math.sin(from.getLatitude())*Math.cos(to.getLatitude())*Math.cos(longDiff);

        return (Math.toDegrees(Math.atan2(y, x))+360)%360;

    }
}
