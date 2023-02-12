package eg.gov.iti.jets.mad.foodplanner.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;

@Dao
public interface MealPlanDAO {
    @Query("SELECT * from MealPlan")
    LiveData<List<MealPlan>> getAllMeals_MealPlan();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeal_MealPlan(MealPlan mealPlan);

    @Delete
    void deleteMeal_MealPlan(MealPlan mealPlan);

}
