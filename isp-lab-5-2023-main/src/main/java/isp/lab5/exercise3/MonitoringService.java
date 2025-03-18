package isp.lab5.exercise3;

import isp.lab5.exercise1.Product;

public class MonitoringService {
    private Sensor[] sensors = new Sensor[10];

    public MonitoringService(Sensor[] sensors) {
        this.sensors = sensors;
    }

    public double getAverageTemperatureSensors() {
        double sum = 0.0;
        int tempSensCount = 0;
        for (Sensor sensor : sensors){
            if (sensor instanceof TemperatureSensor) {
                sum +=((TemperatureSensor)sensor).getValue();
                tempSensCount++;
            }
        }
        return tempSensCount > 0 ? sum / tempSensCount : 0.0;
    }

    public double getAverageAllSensors() {
        double sum = 0.0;
        for (Sensor sensor : sensors){
            sum += sensor.getValue();
        }
        return sum / sensors.length;
    }
}
