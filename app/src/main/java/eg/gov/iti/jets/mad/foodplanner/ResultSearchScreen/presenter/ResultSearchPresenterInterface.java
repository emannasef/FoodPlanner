package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.presenter;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;

public interface ResultSearchPresenterInterface {
    public void getMeals(String key,String value);
    public void addToFav(Meal meal);
    public void addToMealPlan(MealPlan meal);
}
