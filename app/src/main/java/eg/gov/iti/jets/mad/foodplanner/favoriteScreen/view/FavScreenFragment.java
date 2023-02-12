package eg.gov.iti.jets.mad.foodplanner.favoriteScreen.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Database.ConcreteLocalSource;
import eg.gov.iti.jets.mad.foodplanner.Database.Repository;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.view.MealInfoActivity;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.presenter.FavPresenter;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.presenter.FavPresenterInterface;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.SharedPref;

public class FavScreenFragment extends Fragment implements OnFavoriteClickListener,FavViewInterface {

    RecyclerView recyclerView;
    favMealAdapter favMealAdapter;
    FavPresenterInterface favPresenterInterface;
    Intent intent;
    SharedPref sharedPref;
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

        sharedPref=new SharedPref(getContext());
        recyclerView = view.findViewById(R.id.favRecyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        favMealAdapter = new favMealAdapter(getContext(),this);
        favPresenterInterface=new FavPresenter(this, Repository.getInstance(Api_Client.getInstance(), ConcreteLocalSource.getInstance(getContext()),getContext()));
        showData(sharedPref.read());
    }

    @Override
    public void onImageClick(String mealName) {
        goToMealInfo(mealName);
    }

    @Override
    public void ondeleteClick(Meal meal) {
        deleteMeal(meal);
    }

    @Override
    public void showData(String email) {
       favPresenterInterface.getFavMeals(email).observe(getViewLifecycleOwner(), new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                if(meals!=null) {
                    favMealAdapter.setList(meals);
                    recyclerView.setAdapter(favMealAdapter);
                }
            }
        });
    }
    @Override
    public void goToMealInfo(String mealName) {
        Intent i = new Intent(getContext(), MealInfoActivity.class);
        i.putExtra("mealName",mealName);
        startActivity(i);
    }

    @Override
    public void deleteMeal(Meal meal) {
        favPresenterInterface.deleteFromFav(meal);
    }
}