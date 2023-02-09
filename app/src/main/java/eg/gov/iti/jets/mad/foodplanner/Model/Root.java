package eg.gov.iti.jets.mad.foodplanner.Model;

import java.util.ArrayList;

public class Root{
    public ArrayList<Meal> meals;
    public ArrayList<Category>categories;

    public Root(ArrayList<Meal> meals,ArrayList<Category> categories) {
        this.meals = meals;
        this.categories=categories;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }
}
