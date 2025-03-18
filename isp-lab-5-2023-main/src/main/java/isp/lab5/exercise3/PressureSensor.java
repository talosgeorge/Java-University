package isp.lab5.exercise3;

public class PressureSensor extends Sensor {
    public double pressure;

    public double getValue() {
        return pressure;
    }

    public PressureSensor(String installLocation, String name, double pressure) {
        super(installLocation, name);
        this.pressure = pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
