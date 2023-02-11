package eg.gov.iti.jets.mad.foodplanner.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface MealDAO {
    @Query("SELECT * from Meal")
    LiveData<List<Meal>> getAllMeals();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeal(Meal meal);

    @Delete
    void deleteMeal(Meal meal);
}
