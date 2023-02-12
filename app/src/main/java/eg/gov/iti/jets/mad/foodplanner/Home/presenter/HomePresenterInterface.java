package eg.gov.iti.jets.mad.foodplanner.Home.presenter;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;

public interface HomePresenterInterface {
    public void getMeals();

    public void addToFav(Meal meal);

    public void removeFromFav(Meal meal);

    void addDataToFirebase(String mealName , String mealImage , String mealCountryName);
}
