package eg.gov.iti.jets.mad.foodplanner.Model;

import java.util.ArrayList;

public class Root{
    public ArrayList<Meal> meals;

    public Root(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }
}
