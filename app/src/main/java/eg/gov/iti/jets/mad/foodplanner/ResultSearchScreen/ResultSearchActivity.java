package eg.gov.iti.jets.mad.foodplanner.ResultSearchScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.MealInfoActivity;
import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.favMealAdapter;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.favoriteMeal;

public class ResultSearchActivity extends AppCompatActivity implements Network_Delegate {

    ImageButton backResult_btn;
    RecyclerView recyclerView;
    ResultAdapter resultAdapter;
    Api_Client api_client;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);

        intent=getIntent();

        api_client=Api_Client.getInstance();
        if(intent.getStringExtra("searchType").equals("category")) {
             api_client.searchBycategoryCall(this,intent.getStringExtra("search"));
        }
        else if(intent.getStringExtra("searchType").equals("name")) {
            api_client.mealInfoCall(this, intent.getStringExtra("searchName"));
        }
        backResult_btn=findViewById(R.id.backResult_btn);
        recyclerView = findViewById(R.id.resultRecyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        backResult_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onSuccessResult(ArrayList<Meal> myMeal) {
        resultAdapter = new ResultAdapter(this, myMeal, new ResultAdapter.ResultMealClickListener() {
            @Override
            public void onresultMealClick(Meal obj) {
                Intent i = new Intent(ResultSearchActivity.this, MealInfoActivity.class);
                i.putExtra("mealName",obj.strMeal);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(resultAdapter);
    }

    @Override
    public void onSuccessCategoryResult(ArrayList<Category> categories) {

    }

    @Override
    public void onFailureResult(String errorMessage) {

    }
}