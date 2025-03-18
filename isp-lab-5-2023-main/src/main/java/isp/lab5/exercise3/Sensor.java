package isp.lab5.exercise3;
import java.util.Scanner;

public abstract class Sensor {
    private String installLocation;
    private String name;
    public abstract double getValue();

    public String getInstallLocation() {
        return installLocation;
    }

    public String getName() {
        return name;
    }

    public Sensor(String installLocation, String name) {
        this.installLocation = installLocation;
        this.name = name;
    }
}
