package eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Database.ConcreteLocalSource;
import eg.gov.iti.jets.mad.foodplanner.Database.Repository;
import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.presenter.MealInfoPresenter;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.presenter.MealInfoPresenterInterface;
import eg.gov.iti.jets.mad.foodplanner.Model.Category;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.RepositoryInterface;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.R;


public class MealInfoActivity extends AppCompatActivity implements MealInfoViewInterface,OnClickListenerInterface {

    MealInfoPresenterInterface mealInfoPresenterInterface;
    RecyclerView recyclerView;
    IngredientAdapter ingredientAdapter;
    YouTubePlayerView youTubePlayerView ;
    TextView mealName;
    TextView countryName;
    TextView steps;
    ImageView backImage;
    ImageView mealImage;
    ImageView heartImageView;
    Api_Client api_client;
    List ingredientArrayList;
    List measureArrayList;
    Intent intent;
    Meal meal;
    int i;
    FirebaseAuth auth;
    FirebaseUser user;
    RepositoryInterface repositoryInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_info);

        auth=FirebaseAuth.getInstance();
        user= auth.getCurrentUser();

        mealInfoPresenterInterface=new MealInfoPresenter(this, Repository.getInstance(Api_Client.getInstance(), ConcreteLocalSource.getInstance(this),this));

        heartImageView=findViewById(R.id.MealInfoHeartImageView);
        mealName=findViewById(R.id.mealNameTextView);
        countryName=findViewById(R.id.countryNameTextView);
        steps=findViewById(R.id.stepsTextView);
        youTubePlayerView = findViewById(R.id.youtube_player_view);
        mealImage=findViewById(R.id.mealImageView);

        intent=getIntent();
        mealInfoPresenterInterface.getMeals(intent.getStringExtra("mealName"));


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
        heartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(meal.isFav==false) {
                    heartImageView.setImageResource(R.drawable.favorite_filled_black_icon);
                    Toast.makeText(MealInfoActivity.this, "Added to Favorite", Toast.LENGTH_SHORT).show();
                    meal.userEmail = user.getEmail();
                    meal.isFav = true;
                    addMeal(meal);
                }
                else if(meal.isFav==true /*&& meal.userEmail.equals(user.getEmail())*/){
                    heartImageView.setImageResource(R.drawable.favorite_outline_icon);
                    Toast.makeText(MealInfoActivity.this, "removed Successfully", Toast.LENGTH_LONG).show();
                    meal.userEmail = null;
                    meal.isFav = false;
                    deleteMeal(meal);
                }
            }
        });

        ingredientArrayList = new ArrayList<String>();
        measureArrayList = new ArrayList<String>();
    }

    @Override
    public void showData(List<Meal> myMeal) {

        meal=myMeal.get(0);
        Glide.with(this).load(myMeal.get(0).strMealThumb)
                .apply(new RequestOptions()
                        .override(150, 150)
                        .placeholder(R.drawable.mealinfo))
                .into(mealImage);

        mealName.setText(myMeal.get(0).strMeal);
        countryName.setText(myMeal.get(0).strArea);
        steps.setText(myMeal.get(0).strInstructions);
        if(meal.isFav==true /*&& meal.userEmail.equals(user.getEmail())*/) {
            heartImageView.setImageResource(R.drawable.favorite_filled_black_icon);
        }

        if(myMeal.get(0).strIngredient1!=null&&!myMeal.get(0).strIngredient1.isEmpty()&&!myMeal.get(0).strIngredient1.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient1);
        }
        if(myMeal.get(0).strIngredient2!=null&&!myMeal.get(0).strIngredient2.isEmpty()&&!myMeal.get(0).strIngredient2.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient2);
        }
        if(myMeal.get(0).strIngredient3!=null&&!myMeal.get(0).strIngredient3.isEmpty()&&!myMeal.get(0).strIngredient3.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient3);
        }
        if(myMeal.get(0).strIngredient4!=null&&!myMeal.get(0).strIngredient4.isEmpty()&&!myMeal.get(0).strIngredient4.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient4);
        }
        if(myMeal.get(0).strIngredient5!=null&&!myMeal.get(0).strIngredient5.isEmpty()&&!myMeal.get(0).strIngredient5.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient5);
        }
        if(myMeal.get(0).strIngredient6!=null&&!myMeal.get(0).strIngredient6.isEmpty()&&!myMeal.get(0).strIngredient6.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient6);
        }
        if(myMeal.get(0).strIngredient7!=null&&!myMeal.get(0).strIngredient7.isEmpty()&&!myMeal.get(0).strIngredient7.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient7);
        }
        if(myMeal.get(0).strIngredient8!=null&&!myMeal.get(0).strIngredient8.isEmpty()&&!myMeal.get(0).strIngredient8.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient8);
        }
        if(myMeal.get(0).strIngredient9!=null&&!myMeal.get(0).strIngredient9.isEmpty()&&!myMeal.get(0).strIngredient9.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient9);
        }
        if(myMeal.get(0).strIngredient10!=null&&!myMeal.get(0).strIngredient10.isEmpty()&&!myMeal.get(0).strIngredient10.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient10);
        }
        if(myMeal.get(0).strIngredient11!=null&&!myMeal.get(0).strIngredient11.isEmpty()&&!myMeal.get(0).strIngredient11.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient11);
        }
        if(myMeal.get(0).strIngredient12!=null&&!myMeal.get(0).strIngredient12.isEmpty()&&!myMeal.get(0).strIngredient12.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient12);
        }
        if(myMeal.get(0).strIngredient13!=null&&!myMeal.get(0).strIngredient13.isEmpty()&&!myMeal.get(0).strIngredient13.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient13);
        }
        if(myMeal.get(0).strIngredient14!=null&&!myMeal.get(0).strIngredient14.isEmpty()&&!myMeal.get(0).strIngredient14.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient14);
        }
        if(myMeal.get(0).strIngredient15!=null&&!myMeal.get(0).strIngredient15.isEmpty()&&!myMeal.get(0).strIngredient15.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient15);
        }
        if(myMeal.get(0).strIngredient16!=null&&!myMeal.get(0).strIngredient16.isEmpty()&&!myMeal.get(0).strIngredient16.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient16);
        }
        if(myMeal.get(0).strIngredient17!=null&&!myMeal.get(0).strIngredient17.isEmpty()&&!myMeal.get(0).strIngredient17.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient17);
        }
        if(myMeal.get(0).strIngredient18!=null&&!myMeal.get(0).strIngredient18.isEmpty()&&!myMeal.get(0).strIngredient18.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient18);
        }
        if(myMeal.get(0).strIngredient19!=null&&!myMeal.get(0).strIngredient19.isEmpty()&&!myMeal.get(0).strIngredient19.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient19);
        }
        if( myMeal.get(0).strIngredient20!=null && !myMeal.get(0).strIngredient20.isEmpty()&&!myMeal.get(0).strIngredient20.equals(" ")){
            ingredientArrayList.add(myMeal.get(0).strIngredient20);
        }


        if(myMeal.get(0).strMeasure1!=null&&!myMeal.get(0).strMeasure1.isEmpty()&&!myMeal.get(0).strMeasure1.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure1);
        }
        if(myMeal.get(0).strMeasure2!=null&&!myMeal.get(0).strMeasure2.isEmpty()&&!myMeal.get(0).strMeasure2.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure2);
        }
        if(myMeal.get(0).strMeasure3!=null&&!myMeal.get(0).strMeasure3.isEmpty()&&!myMeal.get(0).strMeasure3.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure3);
        }
        if(myMeal.get(0).strMeasure4!=null&&!myMeal.get(0).strMeasure4.isEmpty()&&!myMeal.get(0).strMeasure4.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure4);
        }
        if(myMeal.get(0).strMeasure5!=null&&!myMeal.get(0).strMeasure5.isEmpty()&&!myMeal.get(0).strMeasure5.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure5);
        }
        if(myMeal.get(0).strMeasure6!=null&&!myMeal.get(0).strMeasure6.isEmpty()&&!myMeal.get(0).strMeasure6.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure6);
        }
        if(myMeal.get(0).strMeasure7!=null&&!myMeal.get(0).strMeasure7.isEmpty()&&!myMeal.get(0).strMeasure7.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure7);
        }
        if(myMeal.get(0).strMeasure8!=null&&!myMeal.get(0).strMeasure8.isEmpty()&&!myMeal.get(0).strMeasure8.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure8);
        }
        if(myMeal.get(0).strMeasure9!=null&&!myMeal.get(0).strMeasure9.isEmpty()&&!myMeal.get(0).strMeasure9.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure9);
        }
        if(myMeal.get(0).strMeasure10!=null&&!myMeal.get(0).strMeasure10.isEmpty()&&!myMeal.get(0).strMeasure10.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure10);
        }
        if(myMeal.get(0).strMeasure11!=null&&!myMeal.get(0).strMeasure11.isEmpty()&&!myMeal.get(0).strMeasure11.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure11);
        }
        if(myMeal.get(0).strMeasure12!=null&&!myMeal.get(0).strMeasure12.isEmpty()&&!myMeal.get(0).strMeasure12.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure12);
        }
        if(myMeal.get(0).strMeasure13!=null&&!myMeal.get(0).strMeasure13.isEmpty()&&!myMeal.get(0).strMeasure13.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure13);
        }
        if(myMeal.get(0).strMeasure14!=null&&!myMeal.get(0).strMeasure14.isEmpty()&&!myMeal.get(0).strMeasure14.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure14);
        }
        if(myMeal.get(0).strMeasure15!=null&&!myMeal.get(0).strMeasure15.isEmpty()&&!myMeal.get(0).strMeasure15.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure15);
        }
        if(myMeal.get(0).strMeasure16!=null&&!myMeal.get(0).strMeasure16.isEmpty()&&!myMeal.get(0).strMeasure16.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure16);
        }
        if(myMeal.get(0).strMeasure17!=null&&!myMeal.get(0).strMeasure17.isEmpty()&&!myMeal.get(0).strMeasure17.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure17);
        }
        if(myMeal.get(0).strMeasure18!=null&&!myMeal.get(0).strMeasure18.isEmpty()&&!myMeal.get(0).strMeasure18.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure18);
        }
        if(myMeal.get(0).strMeasure19!=null&&!myMeal.get(0).strMeasure19.isEmpty()&&!myMeal.get(0).strMeasure19.equals(" ")){
            measureArrayList.add(myMeal.get(0).strMeasure19);
        }
        if(myMeal.get(0).strMeasure20!=null&&!myMeal.get(0).strMeasure20.isEmpty()&&!myMeal.get(0).strMeasure20.equals(" ")){
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
                youTubePlayer.cueVideo(arr[1],0);
            }
        });
    }

    @Override
    public void addMeal(Meal meal) {
        mealInfoPresenterInterface.addToFav(meal);
    }

    @Override
    public void deleteMeal(Meal meal) {
        mealInfoPresenterInterface.deleteFromFav(meal);
    }

    @Override
    public void onheartClick(Meal result) {
        addMeal(result);
    }
}