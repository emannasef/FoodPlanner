package eg.gov.iti.jets.mad.foodplanner.MealPlan.view;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;

public interface MealPlanViewInterface {

    public void goToMealInfo(String mealName);
    public void showData(String email);
    public void deleteMealFromMealPlan(MealPlan meal);
}
