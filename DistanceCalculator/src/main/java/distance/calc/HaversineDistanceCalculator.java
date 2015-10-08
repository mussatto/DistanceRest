package distance.calc;

public class HaversineDistanceCalculator implements DistanceCalculatorMethod {

    private static final double EARTH_RADIOUS_KM = 6372.8;
    private static final double EARTH_RADIOUS_MI=3959.87433;


    @Override
    public double calculateDistance(Coordinates from, Coordinates to, MeasureUnit measureUnit) {

        double dLat = Math.toRadians(to.getLatitude() - from.getLatitude());
        double dLon = Math.toRadians(to.getLongitude() - from.getLongitude());
        double lat1 = Math.toRadians(from.getLatitude());
        double lat2 = Math.toRadians(to.getLatitude());

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);

        double c = 2 * Math.asin(Math.sqrt(a));

        if(measureUnit.equals(MeasureUnit.KM))
            return EARTH_RADIOUS_KM*c;
        else if(measureUnit.equals(MeasureUnit.MI))
            return EARTH_RADIOUS_MI*c;

        else
            return EARTH_RADIOUS_KM*c;
    }

}
