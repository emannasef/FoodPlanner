package eg.gov.iti.jets.mad.foodplanner.searchScreen.view;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface SearchViewInterface {

    public void showData(List<Meal> mealList);
    public void showCategory(List<Category> categories);

}
