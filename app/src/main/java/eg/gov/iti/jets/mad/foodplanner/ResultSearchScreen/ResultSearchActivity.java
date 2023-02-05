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
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.favMealAdapter;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.favoriteMeal;

public class ResultSearchActivity extends AppCompatActivity {

    ImageButton backResult_btn;
    RecyclerView recyclerView;
    ResultAdapter resultAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);
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


        ArrayList input = new ArrayList<resultSearch>();
        resultSearch r1 = new resultSearch( R.drawable.welcome_original_img);
        resultSearch r2 = new resultSearch( R.drawable.welcome_original_img);
        resultSearch r3 = new resultSearch( R.drawable.welcome_original_img);
        resultSearch r4 = new resultSearch( R.drawable.welcome_original_img);
        resultSearch r5 = new resultSearch( R.drawable.welcome_original_img);
        resultSearch r6 = new resultSearch( R.drawable.welcome_original_img);
        resultSearch r7 = new resultSearch( R.drawable.welcome_original_img);
        resultSearch r8 = new resultSearch( R.drawable.welcome_original_img);
        resultSearch r9 = new resultSearch( R.drawable.welcome_original_img);

        input.add(r1);
        input.add(r2);
        input.add(r3);
        input.add(r4);
        input.add(r5);
        input.add(r6);
        input.add(r7);
        input.add(r8);
        input.add(r9);

        resultAdapter = new ResultAdapter(this, input, new ResultAdapter.ResultMealClickListener() {
            @Override
            public void onresultMealClick(resultSearch obj) {
                Intent i = new Intent(ResultSearchActivity.this, MealInfoActivity.class);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(resultAdapter);
    }

}