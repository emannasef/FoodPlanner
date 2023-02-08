package eg.gov.iti.jets.mad.foodplanner.Home;

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

import java.util.ArrayList;

import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.MealInfoActivity;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Service;
import eg.gov.iti.jets.mad.foodplanner.Network.Network_Delegate;
import eg.gov.iti.jets.mad.foodplanner.R;

public class HomeFragment extends Fragment implements Network_Delegate {

    ImageView mealImageView;
    TextView mealNameView;
    TextView countryMealName;
    Api_Client api_client;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        api_client = Api_Client.getInstance();
        api_client.randomMealCall(this);
        mealImageView = view.findViewById(R.id.home_card_imageview);
        mealNameView = view.findViewById(R.id.home_meal_name_textview);
        countryMealName = view.findViewById(R.id.home_countryNameOfMeal_textView);
        mealImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MealInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccessResult(ArrayList<Meal> myMeal) {
        Glide.with(getContext()).load(myMeal.get(0).getStrMealThumb()).apply(new RequestOptions().override(150, 150).placeholder(R.drawable.mealinfo)).into(mealImageView);
        Toast.makeText(getContext(), myMeal.get(0).getStrMeal() + "##############", Toast.LENGTH_SHORT).show();
        mealNameView.setText(myMeal.get(0).getStrMeal());
        countryMealName.setText(myMeal.get(0).getStrArea());
    }

    @Override
    public void onFailureResult(String errorMessage) {
        Toast.makeText(getContext(), "Faileddddddddddddddddd", Toast.LENGTH_SHORT).show();
    }
}