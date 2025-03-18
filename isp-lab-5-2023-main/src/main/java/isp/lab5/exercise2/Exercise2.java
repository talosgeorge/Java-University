package isp.lab5.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop(90);
        SmartPhone smartPhone = new SmartPhone(0);
        SmartWatch smartWatch = new SmartWatch(50);

        System.out.println("Laptop battery level:" + laptop.getBatteryLevel());
        laptop.charge(10);
        System.out.println("Laptop battery level after charging:" + laptop.getBatteryLevel());

        System.out.println("Smartphone battery level:" + smartPhone.getBatteryLevel());
        smartPhone.charge(30);
        System.out.println("Smartphone battery level after charging:" + smartPhone.getBatteryLevel());

        System.out.println("Smartwatch battery level:" + smartWatch.getBatteryLevel());
        smartWatch.charge(20);
        System.out.println("Smartwatch battery level after charging:" + smartWatch.getBatteryLevel());


    }


}
