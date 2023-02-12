package eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.presenter;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Database.RepositoryInterface;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.view.MealInfoViewInterface;
import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;

public class MealInfoPresenter implements Network_Delegate,MealInfoPresenterInterface {

    MealInfoViewInterface mealInfoViewInterface;
    RepositoryInterface repositoryInterface;

    public MealInfoPresenter(MealInfoViewInterface mealInfoViewInterface, RepositoryInterface repositoryInterface) {
        this.mealInfoViewInterface = mealInfoViewInterface;
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public void getMeals(String name) {
        repositoryInterface.getinfoMeals(this,name);
    }

    @Override
    public void addToFav(Meal meal) {
        repositoryInterface.insertMeal(meal);
    }

    @Override
    public void deleteFromFav(Meal meal) {
        repositoryInterface.deleteMeal(meal);
    }

    @Override
    public void onSuccessResult(List<Meal> myMeal) {
        mealInfoViewInterface.showData(myMeal);
    }

    @Override
    public void onSuccessCategoryResult(List<Category> categories) {}

    @Override
    public void onFailureResult(String errorMessage) {}
}
