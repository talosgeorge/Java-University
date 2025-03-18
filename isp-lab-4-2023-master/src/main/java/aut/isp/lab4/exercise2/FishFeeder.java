package aut.isp.lab4.exercise2;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    public int getMeals() {
        return meals;
    }

    public void feed() {
        meals--;
        System.out.println("The fishes were fed.");
    }

    public void fillUp() {
        meals = 14;
        System.out.println("The food tank was filled up.");
    }


    public FishFeeder(String manufacturer, String model, int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "FishFeeder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", meals=" + meals +
                '}';
    }
}
