package distance;

public class Distance {

    private final double units;

    private final MeasureUnit measureUnit;

    public Distance(double units, MeasureUnit measureUnit){
        this.units=units;
        this.measureUnit=measureUnit;
    }

    public double getUnits() {
        return units;
    }

    public MeasureUnit getMeasureUnit() {
        return measureUnit;
    }
}
