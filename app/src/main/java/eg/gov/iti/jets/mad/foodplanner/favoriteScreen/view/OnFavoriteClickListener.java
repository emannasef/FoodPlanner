package eg.gov.iti.jets.mad.foodplanner.favoriteScreen.view;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface OnFavoriteClickListener {
    void onImageClick(String MealName);
    void ondeleteClick(Meal meal);

}
