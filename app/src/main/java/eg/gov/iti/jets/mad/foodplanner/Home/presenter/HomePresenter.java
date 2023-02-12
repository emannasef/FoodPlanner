package eg.gov.iti.jets.mad.foodplanner.Home.presenter;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Home.view.HomeViewInterface;
import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Database.RepositoryInterface;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;

public class HomePresenter implements HomePresenterInterface, Network_Delegate {

    private HomeViewInterface homeViewInterface;
    private RepositoryInterface repositoryInterface;


    public HomePresenter(HomeViewInterface homeViewInterface,RepositoryInterface repositoryInterface){
        this.homeViewInterface=homeViewInterface;
        this.repositoryInterface= repositoryInterface;
    }
    @Override
    public void onSuccessResult(List<Meal> myMeal) {
        homeViewInterface.showData(myMeal);
    }

    @Override
    public void onSuccessCategoryResult(List<Category> categories) {}

    @Override
    public void onFailureResult(String errorMessage) {}

    @Override
    public void getMeals() {
        repositoryInterface.getRandomMeals(this);
    }

    @Override
    public void addToFav(Meal meal) {
        repositoryInterface.insertMeal(meal);
    }

    @Override
    public void removeFromFav(Meal meal) {
        repositoryInterface.deleteMeal(meal);
    }

    @Override
    public void addDataToFirebase(String mealName, String mealImage, String mealCountryName) {
        repositoryInterface.pushToFireStore(mealName,mealImage,mealCountryName);
    }


}
