package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.presenter;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;

public interface ResultSearchPresenterInterface {
    public LiveData<List<Meal>> getStoredMeals(String email);
    public void getMeals(String key,String value);
    public void addToFav(Meal meal);
    public void addToMealPlan(MealPlan meal);
    public void deleteFromFav(Meal meal);
}
