package eg.gov.iti.jets.mad.foodplanner.Database;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.SharedPref;

public class ConcreteLocalSource implements LocalSource {

    private static final String TAG = "ConcreteLocalSource";
    private MealDAO dao;
    private MealPlanDAO mealPlanDAO;
    private static ConcreteLocalSource concerteLocalSource =null;
    private LiveData<List<Meal>> storedMeals;
    private LiveData<List<Meal>> storedFavMeals;

   // private LiveData<List<MealPlan>> storedMeals_MealPlan;
    SharedPref sharedPref;

    private ConcreteLocalSource(Context context){
        sharedPref =new SharedPref(context);
        AppDatabase db = AppDatabase.getInstance(context.getApplicationContext());
        dao=db.mealDAO();
        mealPlanDAO=db.mealPlanDAO();
        //storedMeals=dao.getAllMeals();
       // storedMeals_MealPlan=mealPlanDAO.getAllMeals_MealPlan(sharedPref.read());

    }
    public static ConcreteLocalSource getInstance(Context context){
        if(concerteLocalSource==null){
            concerteLocalSource= new ConcreteLocalSource(context);
        }
        return concerteLocalSource;
    }
    @Override
    public void insertMeal(Meal meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertMeal(meal);
            }
        }).start();

    }

    @Override
    public void deleteMeal(Meal meal) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteMeal(meal);
            }
        }).start();
    }
  /*  @Override
    public LiveData<List<Meal>> getAllStoredMeals() {
        return storedMeals;
    }*/

    @Override
    public LiveData<List<MealPlan>> getAllStoredMeals_MealPlan(String email) {
       // Log.i(TAG, "getAllStoredMeals_MealPlan:ConcreteLocal"+storedMeals_MealPlan);
       // return storedMeals_MealPlan;
        return  mealPlanDAO.getAllMeals_MealPlan(email);
    }

    @Override
    public void insertMeal_MealPlan(MealPlan meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mealPlanDAO.insertMeal_MealPlan(meal);
            }
        }).start();
    }

    @Override
    public void deleteMeal_MealPlan(MealPlan meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mealPlanDAO.deleteMeal_MealPlan(meal);
            }
        }).start();
    }
    public LiveData<List<Meal>> getAllStoredFavMeals(String email) {
        return dao.getAllFavMeals(email);
    }
}
