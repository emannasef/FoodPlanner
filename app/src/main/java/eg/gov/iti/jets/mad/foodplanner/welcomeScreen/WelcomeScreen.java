package eg.gov.iti.jets.mad.foodplanner.welcomeScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.signupScreen.SignupScreen;

public class WelcomeScreen extends AppCompatActivity {
TextView alreadyHaveAnAccountTextView;
    TextView loginTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        alreadyHaveAnAccountTextView=findViewById(R.id.Already_have_an_account_textView);
        loginTextView=findViewById(R.id.login_TextView);
        alreadyHaveAnAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(WelcomeScreen.this, SignupScreen.class);
                startActivity(i);
            }
        });
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(WelcomeScreen.this, SignupScreen.class);
                startActivity(i);
            }
        });
    }
}