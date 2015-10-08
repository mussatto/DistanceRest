package distance.calc;

public class City {

    private final Coordinates coordinates;
    private final String name;

    public static City create(double latitude, double longitude, String name){
        return new City(latitude,longitude,name);
    }

    private City(double latitude, double longitude, String name){
        this.coordinates = new Coordinates(latitude,longitude);
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
