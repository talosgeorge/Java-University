package isp.lab5.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        Sensor[] sensors = new Sensor[8];

        sensors[0] = new TemperatureSensor("Bathroom", "Temp1", 22.5);
        sensors[1] = new TemperatureSensor("Living room", "Temp2", 20.2);
        sensors[2] = new TemperatureSensor("Sauna", "Temp3", 23.8);

        sensors[3] = new PressureSensor("Garden", "Pressure1", 101.3);
        sensors[4] = new PressureSensor("Living room", "Pressure2", 98.7);
        sensors[5] = new PressureSensor("Bathroom", "Pressure3", 103.5);
        sensors[6] = new PressureSensor("Beci", "Pressure4", 99.9);
        sensors[7] = new PressureSensor("Hallway", "Pressure5", 102.1);

        MonitoringService monitoringService = new MonitoringService(sensors);

        System.out.println("Average Temperature: " + monitoringService.getAverageTemperatureSensors());
        System.out.println("Average All Sensors: " + monitoringService.getAverageAllSensors());
    }
}
