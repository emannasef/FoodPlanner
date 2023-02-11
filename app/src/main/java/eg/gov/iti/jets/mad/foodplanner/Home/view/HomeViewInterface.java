package eg.gov.iti.jets.mad.foodplanner.Home.view;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface HomeViewInterface {
    public void showData(List<Meal> mealList);
    public void addMeal(Meal meal);

}
