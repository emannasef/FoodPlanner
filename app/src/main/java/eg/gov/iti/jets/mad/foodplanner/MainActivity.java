package eg.gov.iti.jets.mad.foodplanner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import eg.gov.iti.jets.mad.foodplanner.Home.HomeFragment;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.view.LoginScreenActivity;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private FirebaseAuth mAuth;


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null){
           // startActivity(new Intent(MainActivity.this, HomeFragment.class));
        }else {
            startActivity(new Intent(MainActivity.this, LoginScreenActivity.class));

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        NavController navController= Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }



}