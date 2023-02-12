package eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.presenter;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface MealInfoPresenterInterface {

    public void getMeals(String name);
    public LiveData<List<Meal>> getStoredMeals(String email);
    public void addToFav(Meal meal);
    public void deleteFromFav(Meal meal);
}
