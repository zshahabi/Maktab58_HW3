package ir.maktab;

import java.util.Arrays;

public class Dinner {
    private Food[]  foods;
    private Drink[] drinks;

    public Dinner(Food[] food, Drink[] drink) {
        this.foods = food;
        this.drinks = drink;
    }

    public Food[] getFoods() {
        return foods;
    }

    public void setFoods(Food[] foods) {
        this.foods = foods;
    }

    public Drink[] getDrinks() {
        return drinks;
    }

    public void setDrinks(Drink[] drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "Dinner{" +
                "foods=" + Arrays.toString(foods) +
                ", drinks=" + Arrays.toString(drinks) +
                '}';
    }

    public String getFoodsAsString() {
        return "Dinner{" +
                "foods=" + Arrays.toString(foods) +
                '}';
    }

    public String getDrinksAsString() {
        return "Dinner{" +
                "drinks=" + Arrays.toString(drinks) +
                '}';
    }
}
