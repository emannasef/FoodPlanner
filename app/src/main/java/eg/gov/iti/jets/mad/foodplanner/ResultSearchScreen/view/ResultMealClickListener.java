package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.view;


import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;

public interface ResultMealClickListener{
    void onImageClick(String name);
    void onAddToMealPlanClick(MealPlan result);
    void onheartClick(Meal result ,String method );
}