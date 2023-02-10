package eg.gov.iti.jets.mad.foodplanner.favoriteScreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.MealInfoActivity;
import eg.gov.iti.jets.mad.foodplanner.R;

public class FavScreenFragment extends Fragment {

    RecyclerView recyclerView;
    favMealAdapter favMealAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.favRecyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);



        ArrayList input = new ArrayList<favoriteMeal>();
        favoriteMeal f1 = new favoriteMeal( R.drawable.welcome_original_img);
        favoriteMeal f2 = new favoriteMeal( R.drawable.welcome_original_img);
        favoriteMeal f3 = new favoriteMeal( R.drawable.welcome_original_img);
        favoriteMeal f4 = new favoriteMeal( R.drawable.welcome_original_img);
        favoriteMeal f5 = new favoriteMeal( R.drawable.welcome_original_img);
        favoriteMeal f6 = new favoriteMeal( R.drawable.welcome_original_img);
        favoriteMeal f7 = new favoriteMeal( R.drawable.welcome_original_img);
        favoriteMeal f8 = new favoriteMeal( R.drawable.welcome_original_img);
        favoriteMeal f9 = new favoriteMeal( R.drawable.welcome_original_img);

        input.add(f1);
        input.add(f2);
        input.add(f3);
        input.add(f4);
        input.add(f5);
        input.add(f6);
        input.add(f7);
        input.add(f8);
        input.add(f9);

        favMealAdapter = new favMealAdapter(getContext(), input, new favMealAdapter.favMealClickListener() {
            @Override
            public void onFavMealClick(favoriteMeal obj) {
                Intent i = new Intent(getContext(), MealInfoActivity.class);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(favMealAdapter);
    }
}