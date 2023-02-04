package eg.gov.iti.jets.mad.foodplanner.MealInfoScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.R;


public class MealInfoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    IngredientAdapter ingredientAdapter;
    YouTubePlayerView youTubePlayerView ;

    ImageView backImage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_info);
        recyclerView = (RecyclerView) findViewById(R.id.ingredientRecycleView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList input = new ArrayList<Ingredient>();
        Ingredient ingredient1 = new Ingredient("5", "garlic", R.drawable.garlic);
        Ingredient ingredient2 = new Ingredient("2", "onion", R.drawable.onion);
        Ingredient ingredient3 = new Ingredient("3", "garlic", R.drawable.garlic);

        input.add(ingredient1);
        input.add(ingredient2);
        input.add(ingredient3);

        ingredientAdapter = new IngredientAdapter(this, input);
        recyclerView.setAdapter(ingredientAdapter);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "4aZr5hZXP_s";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });


        backImage=findViewById(R.id.backImgInfoMeal);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MealInfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}