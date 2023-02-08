package eg.gov.iti.jets.mad.foodplanner.Network;

import eg.gov.iti.jets.mad.foodplanner.Model.Root;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface Api_Service {

    @GET("list.php?c=list")
    Single<Root> getCategory();

    @GET("list.php?a=list")
    Single<Root> getArea();

    @GET("list.php?i=list")
    Single<Root> getIngredient();

    @GET("search.php?f=a")
    Single<Root> getMealInfo();

    @GET("random.php")
    Single<Root> getRandomMeal();
}
