package distance.calc;

public class Distance {

    private final double units;

    private final MeasureUnit measureUnit;

    public static Distance ZERO = new Distance(0, MeasureUnit.KM);

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
