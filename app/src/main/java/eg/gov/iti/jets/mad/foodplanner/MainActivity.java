package eg.gov.iti.jets.mad.foodplanner;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import eg.gov.iti.jets.mad.foodplanner.Home.view.HomeFragment;
import eg.gov.iti.jets.mad.foodplanner.MealPlan.MealPlanFragment;
import eg.gov.iti.jets.mad.foodplanner.Profile.ProfileFragment;
import eg.gov.iti.jets.mad.foodplanner.favoriteScreen.view.FavScreenFragment;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.SharedPref;
import eg.gov.iti.jets.mad.foodplanner.searchScreen.view.searchFragment;
import eg.gov.iti.jets.mad.foodplanner.welcomeScreen.WelcomeScreen;


public class MainActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    SharedPref sharedPref;
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref=new SharedPref(this);
        Toast.makeText(this, ""+sharedPref.read(), Toast.LENGTH_SHORT).show();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupWithNavController(bottomNavigationView, navController);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
                        return true;
                    case R.id.searchFragment2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,new searchFragment()).commit();
                        return true;
                    case R.id.profileFragment:
                        if(sharedPref.read().equals("guest")){
                            dialogue();
                        }
                        else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfileFragment()).commit();
                        }
                        return true;

                    case R.id.favScreenFragment:
                        if(sharedPref.read().equals("guest")){
                            dialogue();
                        }
                        else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new FavScreenFragment()).commit();
                        }
                        return true;

                    case R.id.mealPlanFragment:
                        if(sharedPref.read().equals("guest")){
                            dialogue();
                        }
                        else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MealPlanFragment()).commit();
                        }
                        return true;
                }
                return true;
            }
        });

    }
    void dialogue(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Register Now?");
        builder.setMessage("You Can't Access This Feature as Guest");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                startActivity(new Intent(MainActivity.this, WelcomeScreen.class));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        builder.create().show();
    }


}