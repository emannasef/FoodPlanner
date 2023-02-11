package eg.gov.iti.jets.mad.foodplanner.favoriteScreen.presenter;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.RepositoryInterface;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.view.FavViewInterface;

public class FavPresenter implements FavPresenterInterface {
    private FavViewInterface favViewInterface;
    private RepositoryInterface repositoryInterface;
    public FavPresenter(FavViewInterface viewInterface , RepositoryInterface repositoryInterface){
        this.favViewInterface=viewInterface;
        this.repositoryInterface=repositoryInterface;
    }
    @Override
    public LiveData<List<Meal>> getMeals() {
        return repositoryInterface.getAllStoredMeals();
    }

    @Override
    public LiveData<List<Meal>> getFavMeals(String email) {
        return repositoryInterface.getAllStoredFavMeals(email);
    }

    @Override
    public void deleteFromFav(Meal meal) {
        repositoryInterface.deleteMeal(meal);
    }

}
