package eg.gov.iti.jets.mad.foodplanner.MealPlan.view;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;

public interface OnDayClickListener {
    void onImageClick(String MealName);
    void onDayDeleteClick(MealPlan meal);

}
