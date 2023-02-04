package eg.gov.iti.jets.mad.foodplanner.loginScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.welcomeScreen.WelcomeScreen;


public class LoginScreenActivity extends AppCompatActivity {

    Button loginBtn ;
    ImageView backImg ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        loginBtn = findViewById(R.id.loginBtn);
        backImg=findViewById(R.id.backImg);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(LoginScreenActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(LoginScreenActivity.this, WelcomeScreen.class);
                startActivity(i);
            }
        });
    }
}