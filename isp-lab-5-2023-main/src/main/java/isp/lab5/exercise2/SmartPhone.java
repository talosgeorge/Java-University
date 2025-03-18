package isp.lab5.exercise2;

public class SmartPhone implements Chargeable {
    private int batteryLevel;

    @Override
    public void charge(int durationInMinutes) {
        if (batteryLevel >= 100) {
            System.out.println("The smartphone is fully charged.");
        } else {
            System.out.println("Charging...");
        }
        for (int i = 1; i <= durationInMinutes; i++) {
            batteryLevel += 2;
            if (batteryLevel >= 100) {
                System.out.println("The smartphone is fully charged.");
                batteryLevel = 100;
                break;
            }
        }

    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    public SmartPhone(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}
