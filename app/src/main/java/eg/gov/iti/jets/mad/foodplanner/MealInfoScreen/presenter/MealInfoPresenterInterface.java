package eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.presenter;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface MealInfoPresenterInterface {

    public void getMeals(String name);
    public void addToFav(Meal meal);
    public void deleteFromFav(Meal meal);
}
