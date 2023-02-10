package eg.gov.iti.jets.mad.foodplanner.MealInfoScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.R;


public class MealInfoActivity extends AppCompatActivity implements Network_Delegate {

    RecyclerView recyclerView;
    IngredientAdapter ingredientAdapter;
    YouTubePlayerView youTubePlayerView ;
    TextView mealName;
    TextView countryName;
    TextView steps;
    ImageView backImage;
    ImageView mealImage;
    Api_Client api_client;
    ArrayList ingredientArrayList;
    ArrayList measureArrayList;
    Intent intent;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_info);

        mealName=findViewById(R.id.mealNameTextView);
        countryName=findViewById(R.id.countryNameTextView);
        steps=findViewById(R.id.stepsTextView);
        youTubePlayerView = findViewById(R.id.youtube_player_view);
        mealImage=findViewById(R.id.mealImageView);

        intent=getIntent();
        api_client = Api_Client.getInstance();
        api_client.mealInfoCall(this,intent.getStringExtra("mealName"));



        recyclerView = findViewById(R.id.ingredientRecycleView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        backImage=findViewById(R.id.backImgInfoMeal);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MealInfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ingredientArrayList = new ArrayList<String>();
        measureArrayList = new ArrayList<String>();
    }

    @Override
    public void onSuccessResult(ArrayList<Meal> myMeal) {

        Glide.with(this).load(myMeal.get(0).strMealThumb)
        .apply(new RequestOptions()
        .override(150, 150)
        .placeholder(R.drawable.mealinfo))
        .into(mealImage);

        mealName.setText(myMeal.get(0).strMeal);
        countryName.setText(myMeal.get(0).strArea);
        steps.setText(myMeal.get(0).strInstructions);

        if(!myMeal.get(0).strIngredient1.isEmpty()&&myMeal.get(0).strIngredient1!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient1);
        }
        if(!myMeal.get(0).strIngredient2.isEmpty()&&myMeal.get(0).strIngredient2!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient2);
        }
        if(!myMeal.get(0).strIngredient3.isEmpty()&&myMeal.get(0).strIngredient3!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient3);
        }
        if(!myMeal.get(0).strIngredient4.isEmpty()&&myMeal.get(0).strIngredient4!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient4);
        }
        if(!myMeal.get(0).strIngredient5.isEmpty()&&myMeal.get(0).strIngredient5!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient5);
        }
        if(!myMeal.get(0).strIngredient6.isEmpty()&&myMeal.get(0).strIngredient6!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient6);
        }
        if(!myMeal.get(0).strIngredient7.isEmpty()&&myMeal.get(0).strIngredient7!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient7);
        }
        if(!myMeal.get(0).strIngredient8.isEmpty()&&myMeal.get(0).strIngredient8!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient8);
        }
        if(!myMeal.get(0).strIngredient9.isEmpty()&&myMeal.get(0).strIngredient9!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient9);
        }
        if(!myMeal.get(0).strIngredient10.isEmpty()&&myMeal.get(0).strIngredient10!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient10);
        }
        if(!myMeal.get(0).strIngredient11.isEmpty()&&myMeal.get(0).strIngredient11!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient11);
        }
        if(!myMeal.get(0).strIngredient12.isEmpty()&&myMeal.get(0).strIngredient12!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient12);
        }
        if(!myMeal.get(0).strIngredient13.isEmpty()&&myMeal.get(0).strIngredient13!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient13);
        }
        if(!myMeal.get(0).strIngredient14.isEmpty()&&myMeal.get(0).strIngredient14!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient14);
        }
        if(!myMeal.get(0).strIngredient15.isEmpty()&&myMeal.get(0).strIngredient15!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient15);
        }
        if(!myMeal.get(0).strIngredient16.isEmpty()&&myMeal.get(0).strIngredient16!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient16);
        }
        if(!myMeal.get(0).strIngredient17.isEmpty()&&myMeal.get(0).strIngredient17!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient17);
        }
        if(!myMeal.get(0).strIngredient18.isEmpty()&&myMeal.get(0).strIngredient18!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient18);
        }
        if(!myMeal.get(0).strIngredient19.isEmpty()&&myMeal.get(0).strIngredient19!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient19);
        }
        if(!myMeal.get(0).strIngredient20.isEmpty()&&myMeal.get(0).strIngredient20!=null){
            ingredientArrayList.add(myMeal.get(0).strIngredient20);
        }


        if(!myMeal.get(0).strMeasure1.isEmpty()&&myMeal.get(0).strMeasure1!=null){
            measureArrayList.add(myMeal.get(0).strMeasure1);
        }
        if(!myMeal.get(0).strMeasure2.isEmpty()&&myMeal.get(0).strMeasure2!=null){
            measureArrayList.add(myMeal.get(0).strMeasure2);
        }
        if(!myMeal.get(0).strMeasure3.isEmpty()&&myMeal.get(0).strMeasure3!=null){
            measureArrayList.add(myMeal.get(0).strMeasure3);
        }
        if(!myMeal.get(0).strMeasure4.isEmpty()&&myMeal.get(0).strMeasure4!=null){
            measureArrayList.add(myMeal.get(0).strMeasure4);
        }
        if(!myMeal.get(0).strMeasure5.isEmpty()&&myMeal.get(0).strMeasure5!=null){
            measureArrayList.add(myMeal.get(0).strMeasure5);
        }
        if(!myMeal.get(0).strMeasure6.isEmpty()&&myMeal.get(0).strMeasure6!=null){
            measureArrayList.add(myMeal.get(0).strMeasure6);
        }
        if(!myMeal.get(0).strMeasure7.isEmpty()&&myMeal.get(0).strMeasure7!=null){
            measureArrayList.add(myMeal.get(0).strMeasure7);
        }
        if(!myMeal.get(0).strMeasure8.isEmpty()&&myMeal.get(0).strMeasure8!=null){
            measureArrayList.add(myMeal.get(0).strMeasure8);
        }
        if(!myMeal.get(0).strMeasure9.isEmpty()&&myMeal.get(0).strMeasure9!=null){
            measureArrayList.add(myMeal.get(0).strMeasure9);
        }
        if(!myMeal.get(0).strMeasure10.isEmpty()&&myMeal.get(0).strMeasure10!=null){
            measureArrayList.add(myMeal.get(0).strMeasure10);
        }
        if(!myMeal.get(0).strMeasure11.isEmpty()&&myMeal.get(0).strMeasure11!=null){
            measureArrayList.add(myMeal.get(0).strMeasure11);
        }
        if(!myMeal.get(0).strMeasure12.isEmpty()&&myMeal.get(0).strMeasure12!=null){
            measureArrayList.add(myMeal.get(0).strMeasure12);
        }
        if(!myMeal.get(0).strMeasure13.isEmpty()&&myMeal.get(0).strMeasure13!=null){
            measureArrayList.add(myMeal.get(0).strMeasure13);
        }
        if(!myMeal.get(0).strMeasure14.isEmpty()&&myMeal.get(0).strMeasure14!=null){
            measureArrayList.add(myMeal.get(0).strMeasure14);
        }
        if(!myMeal.get(0).strMeasure15.isEmpty()&&myMeal.get(0).strMeasure15!=null){
            measureArrayList.add(myMeal.get(0).strMeasure15);
        }
        if(!myMeal.get(0).strMeasure16.isEmpty()&&myMeal.get(0).strMeasure16!=null){
            measureArrayList.add(myMeal.get(0).strMeasure16);
        }
        if(!myMeal.get(0).strMeasure17.isEmpty()&&myMeal.get(0).strMeasure17!=null){
            measureArrayList.add(myMeal.get(0).strMeasure17);
        }
        if(!myMeal.get(0).strMeasure18.isEmpty()&&myMeal.get(0).strMeasure18!=null){
            measureArrayList.add(myMeal.get(0).strMeasure18);
        }
        if(!myMeal.get(0).strMeasure19.isEmpty()&&myMeal.get(0).strMeasure19!=null){
            measureArrayList.add(myMeal.get(0).strMeasure19);
        }
        if(!myMeal.get(0).strMeasure20.isEmpty()&&myMeal.get(0).strMeasure20!=null){
            measureArrayList.add(myMeal.get(0).strMeasure20);
        }

        ingredientAdapter = new IngredientAdapter(this, ingredientArrayList,measureArrayList);
        recyclerView.setAdapter(ingredientAdapter);

        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String [] arr= myMeal.get(0).strYoutube.split("=");
                youTubePlayer.loadVideo(arr[1], 0);
            }
        });
        }

    @Override
    public void onFailureResult(String errorMessage) {

    }

}