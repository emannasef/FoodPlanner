package eg.gov.iti.jets.mad.foodplanner.Home.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Database.ConcreteLocalSource;
import eg.gov.iti.jets.mad.foodplanner.Database.Repository;
import eg.gov.iti.jets.mad.foodplanner.Home.presenter.HomePresenter;
import eg.gov.iti.jets.mad.foodplanner.Home.presenter.HomePresenterInterface;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.view.MealInfoActivity;
import eg.gov.iti.jets.mad.foodplanner.Model.FireMeal;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.R;

public class HomeFragment extends Fragment implements HomeViewInterface,OnItemClickListener {

    ImageView mealImageView;
    TextView mealNameView;
    TextView countryMealName;
    Intent intent;
    HomePresenterInterface homePresenterInterface;
    List<Meal> mealArrayList;
    Meal meal;
    FirebaseAuth auth;
    FirebaseUser user;

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        auth=FirebaseAuth.getInstance();
        user= auth.getCurrentUser();

        homePresenterInterface=new HomePresenter(this,Repository.getInstance(Api_Client.getInstance(), ConcreteLocalSource.getInstance(getContext()),getContext()));
        homePresenterInterface.getMeals();
        mealArrayList=new ArrayList<>();
        mealImageView = view.findViewById(R.id.home_card_imageview);
        mealNameView = view.findViewById(R.id.home_meal_name_textview);
        countryMealName = view.findViewById(R.id.home_countryNameOfMeal_textView);

        mealImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(), MealInfoActivity.class);
                intent.putExtra("comingFrom","home");
                intent.putExtra("mealName",mealNameView.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void showData(List<Meal> myMeal) {

        meal=myMeal.get(0);
        Glide.with(getContext()).load(myMeal.get(0).strMealThumb).apply(new RequestOptions().override(150, 150)
                .placeholder(R.drawable.mealinfo)).into(mealImageView);

        mealNameView.setText(myMeal.get(0).strMeal);
        countryMealName.setText(myMeal.get(0).strArea);

    }

    @Override
    public void addMeal(Meal meal) {
        homePresenterInterface.addToFav(meal);
        homePresenterInterface.addDataToFirebase(meal.strMeal,meal.strMealThumb,meal.strArea);
    }

    @Override
    public void removeMeal(Meal meal) {
        homePresenterInterface.removeFromFav(meal);
    }

    @Override
    public void onItemClick(Meal meal) {
        addMeal(meal);
    }

}