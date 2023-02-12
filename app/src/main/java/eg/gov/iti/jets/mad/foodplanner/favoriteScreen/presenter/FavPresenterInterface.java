package eg.gov.iti.jets.mad.foodplanner.favoriteScreen.presenter;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface FavPresenterInterface {
    public LiveData<List<Meal>> getFavMeals(String email);
    public void deleteFromFav(Meal meal);

}
