package eg.gov.iti.jets.mad.foodplanner.splashScreen.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.SharedPref;
import eg.gov.iti.jets.mad.foodplanner.welcomeScreen.WelcomeScreen;

public class SplashScreen extends AppCompatActivity {
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPref = new SharedPref(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(SplashScreen.this, WelcomeScreen.class);
//                startActivity(intent);
                String sharedVal = sharedPref.read();
                if (sharedVal.equals("foodPlanner@gmail.com")) {
                     startActivity(new Intent(SplashScreen.this, WelcomeScreen.class));
                }else if (sharedVal.equals("guest")){
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                }
                else {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                }
            }
        }, 5000);
    }
}