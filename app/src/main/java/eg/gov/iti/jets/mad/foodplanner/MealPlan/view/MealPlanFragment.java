package eg.gov.iti.jets.mad.foodplanner.MealPlan.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.jets.mad.foodplanner.Database.ConcreteLocalSource;
import eg.gov.iti.jets.mad.foodplanner.Database.Repository;
import eg.gov.iti.jets.mad.foodplanner.MealInfoScreen.view.MealInfoActivity;
import eg.gov.iti.jets.mad.foodplanner.MealPlan.presenter.MealPlanPresenter;
import eg.gov.iti.jets.mad.foodplanner.MealPlan.presenter.MealPlanPresenterInterface;
import eg.gov.iti.jets.mad.foodplanner.Model.Meal;
import eg.gov.iti.jets.mad.foodplanner.Model.MealPlan;
import eg.gov.iti.jets.mad.foodplanner.Network.Api_Client;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.presenter.FavPresenter;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.view.favMealAdapter;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.SharedPref;


public class MealPlanFragment extends Fragment implements OnDayClickListener, MealPlanViewInterface {
    MealPlanPresenterInterface mealPlanPresenterInterface;
    RecyclerView saturdayRecyclerView;
    RecyclerView sundayRecyclerView;
    RecyclerView mondayRecyclerView;
    RecyclerView tuesdayRecyclerView;
    RecyclerView wedenesdayRecyclerView;
    RecyclerView thursdayRecyclerView;
    RecyclerView fridayRecyclerView;

    SaturdayAdapter saturdayAdapter;
    MondayAdapter mondayAdapter;
    SundayAdapter sundayAdapter;
    TuesdayAdapter tuesdayAdapter;
    WedensdayAdapter wedenesdayAdapter;
    ThursdayAdapter thursdayAdapter;
    FridayAdapter fridayAdapter;


    List<MealPlan> mySundayList;
    List<MealPlan> myMondayList;
    List<MealPlan> mySaturdayList;

    List<MealPlan> myTuesdayList;
    List<MealPlan> myWedenesdayList;
    List<MealPlan> myThursdayList;
    List<MealPlan> myFridayList;
    SharedPref sharedPref;

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

        sharedPref=new SharedPref(getContext());
        mealPlanPresenterInterface = new MealPlanPresenter(this, Repository.getInstance(Api_Client.getInstance(), ConcreteLocalSource.getInstance(getContext()), getContext()));

        sundayRecyclerView = view.findViewById(R.id.sundayRecyclerView);
        sundayRecyclerView.setHasFixedSize(true);
        LinearLayoutManager sundayLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        sundayLayoutManager.setOrientation(sundayLayoutManager.HORIZONTAL);
        sundayRecyclerView.setLayoutManager(sundayLayoutManager);
        sundayAdapter = new SundayAdapter(getContext(), this);


        saturdayRecyclerView = view.findViewById(R.id.saturdayRecycleView);
        saturdayRecyclerView.setHasFixedSize(true);
        LinearLayoutManager saturdayLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        saturdayLayoutManager.setOrientation(saturdayLayoutManager.HORIZONTAL);
        saturdayRecyclerView.setLayoutManager(saturdayLayoutManager);
        saturdayAdapter = new SaturdayAdapter(getContext(), this);

        mondayRecyclerView = view.findViewById(R.id.mondayRecyclerView);
        mondayRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mondayLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mondayLayoutManager.setOrientation(mondayLayoutManager.HORIZONTAL);
        mondayRecyclerView.setLayoutManager(mondayLayoutManager);
        mondayAdapter = new MondayAdapter(getContext(), this);

        tuesdayRecyclerView = view.findViewById(R.id.tusedayRecyclerView);
        tuesdayRecyclerView.setHasFixedSize(true);
        LinearLayoutManager tuesdayLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        tuesdayLayoutManager.setOrientation(tuesdayLayoutManager.HORIZONTAL);
        tuesdayRecyclerView.setLayoutManager(tuesdayLayoutManager);
        tuesdayAdapter = new TuesdayAdapter(getContext(), this);

        wedenesdayRecyclerView = view.findViewById(R.id.wednesdayRecyclerView);
        wedenesdayRecyclerView.setHasFixedSize(true);
        LinearLayoutManager wedenesdayLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        wedenesdayLayoutManager.setOrientation(wedenesdayLayoutManager.HORIZONTAL);
        wedenesdayRecyclerView.setLayoutManager(wedenesdayLayoutManager);
        wedenesdayAdapter = new WedensdayAdapter(getContext(),this);

        thursdayRecyclerView = view.findViewById(R.id.thursdayRecycleView);
        thursdayRecyclerView.setHasFixedSize(true);
        LinearLayoutManager  thursdayLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        thursdayLayoutManager.setOrientation(thursdayLayoutManager.HORIZONTAL);
        thursdayRecyclerView.setLayoutManager( thursdayLayoutManager);
        thursdayAdapter = new  ThursdayAdapter(getContext(), this);

        fridayRecyclerView = view.findViewById(R.id.fridayRecycleView);
        fridayRecyclerView.setHasFixedSize(true);
        LinearLayoutManager fridayLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        fridayLayoutManager.setOrientation(fridayLayoutManager.HORIZONTAL);
        fridayRecyclerView.setLayoutManager(fridayLayoutManager);
        fridayAdapter = new FridayAdapter(getContext(), this);

        mySundayList =   new ArrayList<MealPlan>();
        myMondayList =   new ArrayList<MealPlan>();
        mySaturdayList=new ArrayList<MealPlan>();
        myTuesdayList = new ArrayList<MealPlan>();
        myWedenesdayList = new ArrayList<MealPlan>();
        myThursdayList = new ArrayList<MealPlan>();
        myFridayList = new ArrayList<MealPlan>();

        showData(sharedPref.read());

    }


    @Override
    public void goToMealInfo(String mealName) {
        Intent i = new Intent(getContext(), MealInfoActivity.class);
        i.putExtra("mealName",mealName);
        startActivity(i);
    }

    @Override
    public void showData(String email) {
        mealPlanPresenterInterface.getMealsInMealPlan(email).observe(getViewLifecycleOwner(), new Observer<List<MealPlan>>() {
            @Override
            public void onChanged(List<MealPlan> mealPlans) {

                for (int i = 0; i < mealPlans.size(); i++) {
                    if (mealPlans.get(i).getDay().equals("Sunday")) {
                        mySundayList.add(mealPlans.get(i));
                    }
                    else if (mealPlans.get(i).getDay().equals("Monday")) {
                        myMondayList.add(mealPlans.get(i));
                    }
                    else if (mealPlans.get(i).getDay().equals("Saturday")) {
                        mySaturdayList.add(mealPlans.get(i));
                    }
                    else if (mealPlans.get(i).getDay().equals("Tuesday")) {
                        myTuesdayList.add(mealPlans.get(i));
                    }
                    else if (mealPlans.get(i).getDay().equals("Wednesday")) {
                        myWedenesdayList.add(mealPlans.get(i));
                    }
                    else if (mealPlans.get(i).getDay().equals("Thursday")) {
                        myThursdayList.add(mealPlans.get(i));
                    }
                    else if (mealPlans.get(i).getDay().equals("Friday")) {
                        myFridayList.add(mealPlans.get(i));
                    }
                }

                sundayAdapter.setSundayList(mySundayList);
                sundayRecyclerView.setAdapter(sundayAdapter);

                mondayAdapter.setMondayList(myMondayList);
                mondayRecyclerView.setAdapter(mondayAdapter);

                saturdayAdapter.setSaturdayList(mySaturdayList);
                saturdayRecyclerView.setAdapter(saturdayAdapter);

                tuesdayAdapter.setTuesdayList(myTuesdayList);
                tuesdayRecyclerView.setAdapter(tuesdayAdapter);

                wedenesdayAdapter.setWedensdayList(myWedenesdayList);
                wedenesdayRecyclerView.setAdapter(wedenesdayAdapter);

                thursdayAdapter.setThursdayList(myThursdayList);
                thursdayRecyclerView.setAdapter(thursdayAdapter);

                fridayAdapter.setFridayList(myFridayList);
                fridayRecyclerView.setAdapter(fridayAdapter);

                mySundayList =   new ArrayList<MealPlan>();
                myMondayList =   new ArrayList<MealPlan>();
                mySaturdayList=new ArrayList<MealPlan>();
                myTuesdayList = new ArrayList<MealPlan>();
                myWedenesdayList = new ArrayList<MealPlan>();
                myThursdayList = new ArrayList<MealPlan>();
                myFridayList = new ArrayList<MealPlan>();
            }
        });
    }

    @Override
    public void deleteMealFromMealPlan(MealPlan meal) {
        mealPlanPresenterInterface.deleteFromMealPlan(meal);
    }

    @Override
    public void onImageClick(String mealName) {
        goToMealInfo(mealName);
    }

    @Override
    public void onDayDeleteClick(MealPlan meal) {

        if (meal.getDay().equals("Sunday")) {
            deleteMealFromMealPlan(meal);
        }
        else if (meal.getDay().equals("Monday")) {
            deleteMealFromMealPlan(meal);
        }
        else if (meal.getDay().equals("Saturday")) {
            deleteMealFromMealPlan(meal);
        }
        else if (meal.getDay().equals("Tuesday")) {
            deleteMealFromMealPlan(meal);
        }
        else if (meal.getDay().equals("Wednesday")) {
            deleteMealFromMealPlan(meal);
        }
        else if (meal.getDay().equals("Thursday")) {
            deleteMealFromMealPlan(meal);
        }
        else if (meal.getDay().equals("Friday")) {
            deleteMealFromMealPlan(meal);
        }

    }
}