package eg.gov.iti.jets.mad.foodplanner.Network;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.Model.Root;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api_Service {

    @GET("categories.php")
    Single<Root> getCategory();

    @GET("list.php?a=list")
    Single<Root> getArea();
    @GET("search.php?s=")
    Single<Root> getMealInfoByName(@Query("s") String name);
    @GET("random.php")
    Single<Root> getRandomMeal();
}
