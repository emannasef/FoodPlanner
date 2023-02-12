package eg.gov.iti.jets.mad.foodplanner.Database;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;

public interface RepositoryInterface {
    void insertMeal(Meal meal);
    void deleteMeal(Meal meal);
    public void getRandomMeals(Network_Delegate networkDelegate);
    public void getinfoMeals(Network_Delegate networkDelegate,String mealName);
    public void getcategory(Network_Delegate networkDelegate);
    public void getSearchByCategory(Network_Delegate networkDelegate,String categoryName);
    public void getAreaMeals(Network_Delegate networkDelegate);
    public void getMealsByCountry(Network_Delegate networkDelegate,String countryName);
    public void getMealsByIngredient(Network_Delegate networkDelegate,String ingredientName);
    public void getIngredient(Network_Delegate networkDelegate);
    LiveData<List<Meal>> getAllStoredMeals();
    LiveData<List<Meal>> getAllStoredFavMeals(String email);
    LiveData<List<MealPlan>> getAllStoredMeals_MealPlan();

    void insertMeal_MealPlan(MealPlan mealPlan);

    void deleteMeal_MealPlan(MealPlan mealPlan);

}
