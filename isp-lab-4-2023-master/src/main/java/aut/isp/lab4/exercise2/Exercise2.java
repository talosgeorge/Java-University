package aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("Aquatica", "V5", 13);
        System.out.println(fishFeeder.toString());
        fishFeeder.feed();
        fishFeeder.fillUp();
    }
}
