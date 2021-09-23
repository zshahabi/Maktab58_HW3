package ir.maktab;

import java.util.Arrays;

public class Launch {
    private Food[]  foods;
    private Drink[] drinks;

    public Launch(Food[] food, Drink[] launch) {
        this.foods = food;
        this.drinks = launch;
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

    public String getFoodsAsString() {
        return "Launch{" +
                "foods=" + Arrays.toString(foods) +
                '}';
    }

    public String getDrinksAsString() {
        return "Launch{" +
                "drinks=" + Arrays.toString(drinks) +
                '}';
    }
}
