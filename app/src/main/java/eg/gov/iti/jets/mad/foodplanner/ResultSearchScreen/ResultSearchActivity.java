package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.MealInfoActivity;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.favMealAdapter;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.favoriteMeal;

public class ResultSearchActivity extends AppCompatActivity implements Network_Delegate ,ResultMealClickListener{

    ImageButton backResult_btn;
    RecyclerView recyclerView;
    ResultAdapter resultAdapter;
    Intent intent;
    Api_Client api_client;

    ArrayList<Meal> countryMealsResult = new ArrayList();
    ArrayList<Meal> ingredientMealsResult = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);
        intent = getIntent();
        api_client = Api_Client.getInstance();

        if(intent.getStringExtra("searchType").equals("countryName")) {
            api_client.getMealsByCountryCall(this, intent.getStringExtra("countryName"));
        }else if (intent.getStringExtra("searchType").equals("ingredientName")){
            api_client.getMealsByIngredientCall(this, intent.getStringExtra("ingredientName"));
        }


        backResult_btn = findViewById(R.id.backResult_btn);
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
    public void onSuccessResult(ArrayList<Meal> myMeal) {

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
    public void onFailureResult(String errorMessage) {

    }

    @Override
    public void onResultMealClick(Meal result) {
        Intent intent = new Intent(ResultSearchActivity.this, MealInfoActivity.class);
        intent.putExtra("mealName",result.strMeal);
        startActivity(intent);
    }
}