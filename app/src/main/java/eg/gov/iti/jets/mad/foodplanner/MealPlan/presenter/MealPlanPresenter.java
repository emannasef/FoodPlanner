package eg.gov.iti.jets.mad.foodplanner.MealPlan.presenter;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.MealPlan.view.MealPlanViewInterface;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Database.RepositoryInterface;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;

public class MealPlanPresenter implements MealPlanPresenterInterface {
    private MealPlanViewInterface mealPlanViewInterface;
    private RepositoryInterface repositoryInterface;

    public MealPlanPresenter(MealPlanViewInterface mealPlanViewInterface, RepositoryInterface repositoryInterface) {
        this.mealPlanViewInterface = mealPlanViewInterface;
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public LiveData<List<MealPlan>> getMealsInMealPlan(String email) {
        return repositoryInterface.getAllStoredMeals_MealPlan(email);
    }

    @Override
    public void deleteFromMealPlan(MealPlan meal) {
        repositoryInterface.deleteMeal_MealPlan(meal);
    }


}
