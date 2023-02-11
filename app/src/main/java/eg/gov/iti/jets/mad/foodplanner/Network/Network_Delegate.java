package eg.gov.iti.jets.mad.foodplanner.Network;

import java.util.ArrayList;
import java.util.Calendar;

import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface Network_Delegate {
    void onSuccessResult(ArrayList<Meal> myMeal);
    void onSuccessCategoryResult(ArrayList<Category>categories);
    void onFailureResult(String errorMessage);
}
