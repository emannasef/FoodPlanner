package eg.gov.iti.jets.mad.foodplanner.signupScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.welcomeScreen.WelcomeScreen;

public class SignupScreen extends AppCompatActivity {

    Button signUpBtn;
    ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        signUpBtn = findViewById(R.id.next_btn);
        backBtn=findViewById(R.id.back_btn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(SignupScreen.this, MainActivity.class);
                startActivity(i);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(SignupScreen.this, WelcomeScreen.class);
                startActivity(i);
            }
        });

    }
}