package eg.gov.iti.jets.mad.foodplanner.Database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import io.reactivex.rxjava3.core.Flowable;

public class ConcreteLocalSource implements LocalSource {

    private MealDAO dao;
    private static ConcreteLocalSource concerteLocalSource =null;
    private LiveData<List<Meal>> storedMeals;

    private ConcreteLocalSource(Context context){
        AppDatabase db = AppDatabase.getInstance(context.getApplicationContext());
        dao=db.mealDAO();
        storedMeals=dao.getAllMeals();
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
    @Override
    public LiveData<List<Meal>> getAllStoredMeals() {
        return storedMeals;
    }
}
