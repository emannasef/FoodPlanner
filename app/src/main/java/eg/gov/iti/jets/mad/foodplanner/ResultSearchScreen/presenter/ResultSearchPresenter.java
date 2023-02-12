package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.presenter;

import androidx.lifecycle.LiveData;

import java.util.List;
import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Database.RepositoryInterface;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.view.ResultAdapter;
import eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.view.ResultSearchViewInterface;

public class ResultSearchPresenter implements ResultSearchPresenterInterface, Network_Delegate {

    ResultAdapter resultAdapter;
    ResultSearchViewInterface resultSearchViewInterface;
    RepositoryInterface repositoryInterface;

    public ResultSearchPresenter(ResultSearchViewInterface resultSearchViewInterface, RepositoryInterface repositoryInterface){
        this.resultSearchViewInterface=resultSearchViewInterface;
        this.repositoryInterface= repositoryInterface;
    }

    @Override
    public LiveData<List<Meal>> getStoredMeals(String email) {
        return repositoryInterface.getAllStoredFavMeals(email);
    }

    @Override
    public void getMeals(String key, String value) {
        if(key.equals("searchCategory")){
            repositoryInterface.getSearchByCategory(this,value);
        }
        else if(key.equals("searchName")){
            repositoryInterface.getinfoMeals(this,value);
        }
        else if(key.equals("countryName")){
            repositoryInterface.getMealsByCountry(this,value);
        }
        else if(key.equals("ingredientName")){
            repositoryInterface.getMealsByIngredient(this,value);
        }
    }

    @Override
    public void addToFav(Meal meal) {
        repositoryInterface.insertMeal(meal);

    }

    @Override
    public void addToMealPlan(MealPlan meal) {
        repositoryInterface.insertMeal_MealPlan(meal);

    }

    public void deleteFromFav(Meal meal) {
        repositoryInterface.deleteMeal(meal);}

    @Override
    public void onSuccessResult(List<Meal> myMeal) {
       resultSearchViewInterface.showData(myMeal);
    }

    @Override
    public void onSuccessCategoryResult(List<Category> categories) {}

    @Override
    public void onFailureResult(String errorMessage) {}
}
