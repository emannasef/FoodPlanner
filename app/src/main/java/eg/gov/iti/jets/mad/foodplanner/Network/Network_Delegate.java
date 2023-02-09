package eg.gov.iti.jets.mad.foodplanner.Network;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface Network_Delegate {
    void onSuccessResult(ArrayList<Meal> myMeal);
    void onFailureResult(String errorMessage);
}
