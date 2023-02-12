package eg.gov.iti.jets.mad.foodplanner.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;

@Database(entities = {Meal.class, MealPlan.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static  AppDatabase appDatabase =null;
    public abstract  MealDAO mealDAO();
    public abstract MealPlanDAO mealPlanDAO();

    public static synchronized AppDatabase getInstance(Context context){
        if (appDatabase==null){
            appDatabase= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"MealDB").build();
        }
        return appDatabase;
    }
}