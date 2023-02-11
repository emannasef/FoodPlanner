package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.view;


import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface ResultMealClickListener{
    void onImageClick(String name);
    void onheartClick(Meal result ,String method );
}