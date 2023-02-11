package eg.gov.iti.jets.mad.foodplanner.Database;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface LocalSource {
    void insertMeal(Meal meal);
    void deleteMeal(Meal meal);
    LiveData<List<Meal>> getAllStoredMeals();
    LiveData<List<Meal>> getAllStoredFavMeals(String email);
}
