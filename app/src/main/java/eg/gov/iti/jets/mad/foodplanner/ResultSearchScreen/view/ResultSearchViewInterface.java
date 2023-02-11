package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.view;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface ResultSearchViewInterface {
    public void showData(List<Meal> mealList);
    public void addMeal(Meal meal);
    public void deleteMeal(Meal meal);
}
