package eg.gov.iti.jets.mad.foodplanner.MealPlan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.Ingredient;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.IngredientAdapter;
import eg.gov.iti.jets.mad.foodplanner.R;


public class MealPlanFragment extends Fragment {
//    RecyclerView recyclerView;
//
//    MealPlanAdapter mealPlanAdapter;

    public MealPlanFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal_plan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        recyclerView = view. findViewById(R.id.mealPlanRecyclerView);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
//        recyclerView.setLayoutManager(layoutManager);
//        ArrayList input = new ArrayList<Week>();
//
//        Week week3 = new Week("Last Week");
//        Week week1 = new Week("This Week");
//        Week week2 = new Week("Next Week");
//
//        input.add(week3);
//        input.add(week1);
//        input.add(week2);


//        mealPlanAdapter = new MealPlanAdapter(getContext(),input);
//        recyclerView.setAdapter(mealPlanAdapter);


    }
}