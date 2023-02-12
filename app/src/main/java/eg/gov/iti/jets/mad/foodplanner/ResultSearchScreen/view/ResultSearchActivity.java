package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Database.ConcreteLocalSource;
import eg.gov.iti.jets.mad.foodplanner.Database.Repository;
import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.MealInfoActivity;
import eg.gov.iti.jets.mad.foodplanner.Model.Category;

import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.presenter.ResultSearchPresenter;
import eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen.presenter.ResultSearchPresenterInterface;

public class ResultSearchActivity extends AppCompatActivity implements  ResultMealClickListener ,ResultSearchViewInterface{

    ResultAdapter resultAdapter;
    ImageButton backResult_btn;
    RecyclerView recyclerView;
    ResultSearchPresenterInterface resultSearchPresenterInterface;

    Api_Client api_client;
    Intent intent;
    ArrayList<Meal> countryMealsResult = new ArrayList();
    ArrayList<Meal> ingredientMealsResult = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);
        //api_client=Api_Client.getInstance();
        resultSearchPresenterInterface=new ResultSearchPresenter(this, Repository.getInstance(Api_Client.getInstance(), ConcreteLocalSource.getInstance(this),this));
        intent=getIntent();
        if(intent.getStringExtra("searchType").equals("category")) {
             //api_client.searchBycategoryCall(this,intent.getStringExtra("searchCategory"));
            resultSearchPresenterInterface.getMeals("searchCategory",intent.getStringExtra("searchCategory"));
        }
        else if(intent.getStringExtra("searchType").equals("name")) {
           // api_client.mealInfoCall(this, intent.getStringExtra("searchName"));
            resultSearchPresenterInterface.getMeals("searchName",intent.getStringExtra("searchName"));
        }
        else if(intent.getStringExtra("searchType").equals("country")) {
            //api_client.getMealsByCountryCall(this, intent.getStringExtra("countryName"));
            resultSearchPresenterInterface.getMeals("countryName",intent.getStringExtra("countryName"));
        }else if (intent.getStringExtra("searchType").equals("ingredient")){
            //api_client.getMealsByIngredientCall(this, intent.getStringExtra("ingredientName"));
            resultSearchPresenterInterface.getMeals("ingredientName",intent.getStringExtra("ingredientName"));
        }
        backResult_btn=findViewById(R.id.backResult_btn);
        recyclerView = findViewById(R.id.resultRecyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        backResult_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        resultAdapter = new ResultAdapter(this, countryMealsResult,this );
        resultAdapter = new ResultAdapter(this, ingredientMealsResult,this );
        recyclerView.setAdapter(resultAdapter);
    }
    
    @Override
    public void showData(List<Meal> myMeal) {
        resultAdapter = new ResultAdapter(this, myMeal, this);
        recyclerView.setAdapter(resultAdapter);
        for (Meal name : myMeal) {
            System.out.println("##################" + name);
            countryMealsResult.add(name);
            resultAdapter.notifyDataSetChanged();
        }

        for (Meal ingredientName : myMeal) {
            System.out.println("##################" + ingredientName);
            ingredientMealsResult.add(ingredientName);
            resultAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void addMeal(Meal meal) {
        resultSearchPresenterInterface.addToFav(meal);
    }

    @Override
    public void addMeal_MeaPlan(MealPlan meal) {
        resultSearchPresenterInterface.addToMealPlan(meal);
    }

    @Override
    public void onImageClick(String name) {
        Intent intent = new Intent(ResultSearchActivity.this, MealInfoActivity.class);
        intent.putExtra("mealName",name);
        startActivity(intent);
    }

    @Override
    public void onheartClick(Meal result) {
        addMeal(result);
    }

    @Override
    public void onAddToMealPlanClick(MealPlan result) {
        addMeal_MeaPlan(result);
    }


}