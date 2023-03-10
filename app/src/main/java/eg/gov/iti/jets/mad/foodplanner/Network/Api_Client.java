package eg.gov.iti.jets.mad.foodplanner.Network;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.Model.FireMeal;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.Root;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Client implements RemoteSource {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth auth;
    FirebaseUser user;
    FireMeal fireMeal;


    Api_Service api_service;

    private static final String base_Url = "https://www.themealdb.com/api/json/v1/1/";

    private static Api_Client client = null;

    public static Api_Client getInstance() {
        if (client == null)
            client = new Api_Client();
        return client;
    }

    public void mealInfoCall(Network_Delegate network, String name) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
        api_service = retrofit.create(Api_Service.class);
        Single<Root> Meals = api_service.getMealInfoByName(name);

        Meals.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item -> {
                            network.onSuccessResult(item.getMeals());
                        },
                        e -> e.printStackTrace()
                );
    }

    public void randomMealCall(Network_Delegate network) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
        api_service = retrofit.create(Api_Service.class);
        Single<Root> Meals = api_service.getRandomMeal();

        Meals.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item -> {
                            network.onSuccessResult(item.getMeals());
                        },
                        e -> e.printStackTrace()
                );
    }

    public void categoryCall(Network_Delegate network) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
        api_service = retrofit.create(Api_Service.class);
        Single<Root> category = api_service.getCategory();

        category.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item -> {
                            network.onSuccessCategoryResult(item.getCategories());
                        },
                        e -> e.printStackTrace()
                );
    }

    public void searchBycategoryCall(Network_Delegate network, String categoryName) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
        api_service = retrofit.create(Api_Service.class);
        Single<Root> category = api_service.getMealByCategory(categoryName);

        category.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item -> {
                            network.onSuccessResult(item.getMeals());
                        },
                        e -> e.printStackTrace()
                );
    }

    public void getAreaCall(Network_Delegate network) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
        api_service = retrofit.create(Api_Service.class);
        Single<Root> Meals = api_service.getArea();

        Meals.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item -> {
                            network.onSuccessResult(item.getMeals());
                        },
                        e -> e.printStackTrace()
                );
    }

    public void getMealsByCountryCall(Network_Delegate network, String countryName) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
        api_service = retrofit.create(Api_Service.class);
        Single<Root> Meals = api_service.getMealsByCountry(countryName);

        Meals.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item -> {
                            network.onSuccessResult(item.getMeals());
                        },
                        e -> e.printStackTrace()
                );
    }


    public void getIngredientCall(Network_Delegate network) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
        api_service = retrofit.create(Api_Service.class);
        Single<Root> Meals = api_service.getIngredient();

        Meals.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item -> {
                            network.onSuccessResult(item.getMeals());
                        },
                        e -> e.printStackTrace()
                );
    }


    public void getMealsByIngredientCall(Network_Delegate network, String ingredientName) {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
        api_service = retrofit.create(Api_Service.class);
        Single<Root> Meals = api_service.getMealsByIngredient(ingredientName);

        Meals.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item -> {
                            network.onSuccessResult(item.getMeals());
                        },
                        e -> e.printStackTrace()
                );
    }

    @Override
    public void pushToFireStore(String mealName, String mealImage, String mealCountryName) {

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserMeal");
        fireMeal = new FireMeal();
        fireMeal.setMealName(mealName);
        fireMeal.setMealImage(mealImage);
        fireMeal.setMealCountryName(mealCountryName);
        // fireMeal.setMealId(mealId);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(fireMeal);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
