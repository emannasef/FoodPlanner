package eg.gov.iti.jets.mad.foodplanner.Network;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface Network_Delegate {
    void onSuccessResult(List<Meal> myMeal);
    void onSuccessCategoryResult(List<Category>categories);
    void onFailureResult(String errorMessage);
}
