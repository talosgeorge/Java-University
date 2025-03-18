package isp.lab10.raceapp;


import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Race!");
        JFrame frameS = new JFrame("Semaphore");
        frameS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SemaphorePanel semaphorePanel = new SemaphorePanel();

        frameS.getContentPane().add(semaphorePanel);
        frameS.pack();
        frameS.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();
        semaphoreThread.join();

        JFrame frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();

        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setSize(500,300);
        frame.setVisible(true);

       Car car1 = new Car("Red car", carPanel);
        Car car2 = new Car("Blue car", carPanel);
        Car car3 = new Car("Green car", carPanel);
        Car car4 = new Car("Yellow car", carPanel);
        PlaySound ps = new PlaySound();
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        ps.playSound();
        car1.join();
        car2.join();
        car3.join();
        car4.join();
        ps.stopSound();
    }
}
