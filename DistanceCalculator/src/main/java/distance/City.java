package distance;

/**
 * Created by vitormussatto on 07/10/15.
 */
public class City {

    private final double latitude;

    private final double longitude;

    private final String name;

    public static City create(double latitude, double longitude, String name){
        return new City(latitude,longitude,name);
    }

    private City(double latitude, double longitude, String name){
        this.latitude=latitude;
        this.longitude=longitude;
        this.name=name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
}
