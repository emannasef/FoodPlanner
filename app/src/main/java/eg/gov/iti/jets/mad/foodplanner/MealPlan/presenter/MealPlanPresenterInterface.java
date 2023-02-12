package eg.gov.iti.jets.mad.foodplanner.MealPlan.presenter;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;

public interface MealPlanPresenterInterface {

    public LiveData<List<MealPlan>> getMealsInMealPlan();
    public void deleteFromMealPlan(MealPlan meal);


}
