package eg.gov.iti.jets.mad.foodplanner.loginScreen.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.presenter.LoginPresenter;
import eg.gov.iti.jets.mad.foodplanner.welcomeScreen.WelcomeScreen;


public class LoginScreenActivity extends AppCompatActivity implements LoginViewInterface {

    Button loginBtn;
    ImageView backImg;

    EditText emailEditText;
    EditText passwordEditText;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        loginBtn = findViewById(R.id.loginBtn);
        backImg = findViewById(R.id.backImg);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        loginPresenter = new LoginPresenter(this);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                loginPresenter.Login(email,password);

            }
        });

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginScreenActivity.this, WelcomeScreen.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onSuccessLogin() {
        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
        Intent i =new Intent(LoginScreenActivity.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onFailureLogin(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}