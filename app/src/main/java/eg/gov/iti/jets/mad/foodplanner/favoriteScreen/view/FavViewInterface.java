package eg.gov.iti.jets.mad.foodplanner.favoriteScreen.view;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface FavViewInterface {
    public void showData(String eamil);
    public void goToMealInfo(String mealName);
    public void deleteMeal(Meal meal);

}
