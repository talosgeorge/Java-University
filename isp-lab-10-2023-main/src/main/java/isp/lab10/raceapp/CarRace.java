package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.text.DecimalFormat;

public class CarRace {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();

        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);

        Car car1 = new Car("Red car", carPanel);
        Car car2 = new Car("Blue car", carPanel);
        Car car3 = new Car("Green car", carPanel);
        Car car4 = new Car("Yellow car", carPanel);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
    }
}

class Car extends Thread {
    private String name;
    private int distance = 0;
    private CarPanel carPanel;
    private RaceTimer raceTimer;

    public Car(String name, CarPanel carPanel) {
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
        this.raceTimer = new RaceTimer();
    }

    public void run() {
        raceTimer.startTimer();
        while (distance < 400) {
            // simulate the car moving at a random speed
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;
            carPanel.updateCarPosition(name, distance);

            try {
                // pause for a moment to simulate the passage of time
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        raceTimer.stopTimer();
        carPanel.carFinished(name, raceTimer.getFormattedSecondsPassed());
    }
}

class RaceTimer {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private long startTime;
    private long elapsedTime;

    public void startTimer() {
        startTime = System.currentTimeMillis();
        scheduler.scheduleAtFixedRate(() -> elapsedTime = System.currentTimeMillis() - startTime, 0, 10, TimeUnit.MILLISECONDS);
    }

    public void stopTimer() {
        scheduler.shutdown();
    }

    public long getMillisecondsPassed() {
        return elapsedTime;
    }

    public String getFormattedSecondsPassed() {
        double secondsPassed = elapsedTime / 1000.0;
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(secondsPassed);
    }
}

class CarPanel extends JPanel {
    private int[] carPositions;
    private String[] carNames;
    private Color[] carColors;
    private static int finishOrder = 1;

    public CarPanel() {
        carPositions = new int[4];
        carNames = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
        carColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 4; i++) {
            int yPos = 50 + i * 50; // Vertical position of the car
            int xPos = carPositions[i]; // Horizontal position of the car
            int carSize = 30; // Size of the car

            g.setColor(carColors[i]);
            g.fillOval(xPos, yPos, carSize, carSize);
            g.setColor(Color.BLACK);
            g.drawString(carNames[i], xPos, yPos - 5);
        }
    }

    public void updateCarPosition(String carName, int distance) {
        int carIndex = getCarIndex(carName);
        if (carIndex != -1) {
            carPositions[carIndex] = distance;
            repaint();
        }
    }

    public void carFinished(String carName, String time) {
        String message = carName + " finished the race in the " + ordinal(finishOrder++) + " position after "
                + time + " seconds";
        System.out.println(message);
        JOptionPane.showMessageDialog(this, message, "Race Finished", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String ordinal(int i) {
        String[] suffixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        int mod100 = Math.abs(i) % 100;
        int mod10 = mod100 % 10;
        if (mod10 <= 3 && mod100 > 10 && mod100 < 14) {
            return i + "th";
        }
        return i + suffixes[mod10];
    }

    private int getCarIndex(String carName) {
        for (int i = 0; i < 4; i++) {
            if (carNames[i].equals(carName)) {
                return i;
            }
        }
        return -1;
    }
}
