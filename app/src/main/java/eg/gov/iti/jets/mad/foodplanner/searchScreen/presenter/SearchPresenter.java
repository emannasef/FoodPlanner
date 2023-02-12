package eg.gov.iti.jets.mad.foodplanner.searchScreen.presenter;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.RepositoryInterface;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.searchScreen.view.SearchViewInterface;

public class SearchPresenter implements Network_Delegate,SearchPresenterInterface {
    SearchViewInterface searchViewInterface;
    private RepositoryInterface repositoryInterface;

    public SearchPresenter(SearchViewInterface searchViewInterface, RepositoryInterface repositoryInterface) {
        this.searchViewInterface = searchViewInterface;
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public void onSuccessResult(List<Meal> myMeal) {
        searchViewInterface.showData(myMeal);
    }

    @Override
    public void onSuccessCategoryResult(List<Category> categories) {
        searchViewInterface.showCategory(categories);
    }

    @Override
    public void onFailureResult(String errorMessage) {}


    @Override
    public void getCategory() {
        repositoryInterface.getcategory(this);
    }

    @Override
    public void getArea() {
        repositoryInterface.getAreaMeals(this);
    }

    @Override
    public void getIngredient() {
        repositoryInterface.getIngredient(this);
    }

}
