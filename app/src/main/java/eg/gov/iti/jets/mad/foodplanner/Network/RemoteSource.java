package eg.gov.iti.jets.mad.foodplanner.Network;

public interface RemoteSource {
    public void mealInfoCall(Network_Delegate network ,String name);
    public void randomMealCall(Network_Delegate network);
    public void categoryCall(Network_Delegate network);
    public void searchBycategoryCall(Network_Delegate network,String categoryName);
    public void getAreaCall(Network_Delegate network);
    public void getMealsByCountryCall(Network_Delegate network ,String countryName);
    public void getIngredientCall(Network_Delegate network);
    public void getMealsByIngredientCall(Network_Delegate network ,String ingredientName);
}
