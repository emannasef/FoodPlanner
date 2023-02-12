package eg.gov.iti.jets.mad.foodplanner.Database;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.Network.RemoteSource;

public class Repository implements RepositoryInterface {
    private static final String TAG = "Repository";
    private Context context;
    RemoteSource remoteSource;
    LocalSource localSource;
    private static Repository repo = null;

    public static Repository getInstance(RemoteSource remoteSource, LocalSource localSource, Context context) {
        if (repo == null) {
            repo = new Repository(remoteSource, localSource, context);
        }
        return repo;
    }

    private Repository(RemoteSource remoteSource, LocalSource localSource, Context context) {
        this.remoteSource = remoteSource;
        this.localSource = localSource;
        this.context = context;
    }


    @Override
    public void insertMeal(Meal meal) {
        localSource.insertMeal(meal);
    }


    @Override
    public void deleteMeal(Meal meal) {
        localSource.deleteMeal(meal);
    }

    @Override
    public void getRandomMeals(Network_Delegate networkDelegate) {
        remoteSource.randomMealCall(networkDelegate);
    }

    @Override
    public void getinfoMeals(Network_Delegate networkDelegate, String name) {
        remoteSource.mealInfoCall(networkDelegate, name);
    }

    @Override
    public void getcategory(Network_Delegate networkDelegate) {
        remoteSource.categoryCall(networkDelegate);
    }

    @Override
    public void getSearchByCategory(Network_Delegate networkDelegate, String categoryName) {
        remoteSource.searchBycategoryCall(networkDelegate, categoryName);
    }

    @Override
    public void getAreaMeals(Network_Delegate networkDelegate) {
        remoteSource.getAreaCall(networkDelegate);
    }

    @Override
    public void getMealsByCountry(Network_Delegate networkDelegate, String countryName) {
        remoteSource.getMealsByCountryCall(networkDelegate, countryName);
    }


    @Override
    public void getMealsByIngredient(Network_Delegate networkDelegate, String ingredientName) {
        remoteSource.getMealsByIngredientCall(networkDelegate, ingredientName);
    }

    @Override
    public void getIngredient(Network_Delegate networkDelegate) {
        remoteSource.getIngredientCall(networkDelegate);
    }

   /* @Override
    public LiveData<List<Meal>> getAllStoredMeals() {
        return localSource.getAllStoredMeals();
    }*/

    @Override
    public LiveData<List<MealPlan>> getAllStoredMeals_MealPlan(String email) {
        return localSource.getAllStoredMeals_MealPlan(email);
    }

    @Override
    public void insertMeal_MealPlan(MealPlan mealPlan) {
        localSource.insertMeal_MealPlan(mealPlan);
    }

    @Override
    public void deleteMeal_MealPlan(MealPlan mealPlan) {
        localSource.deleteMeal_MealPlan(mealPlan);
    }

    public LiveData<List<Meal>> getAllStoredFavMeals(String email) {
        return localSource.getAllStoredFavMeals(email);
    }
}
