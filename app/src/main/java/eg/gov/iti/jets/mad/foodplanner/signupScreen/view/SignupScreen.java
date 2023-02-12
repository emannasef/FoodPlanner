package eg.gov.iti.jets.mad.foodplanner.signupScreen.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;

import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.Model.User;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.SharedPref;
import eg.gov.iti.jets.mad.foodplanner.signupScreen.presenter.SignupPresenter;
import eg.gov.iti.jets.mad.foodplanner.welcomeScreen.WelcomeScreen;

public class SignupScreen extends AppCompatActivity implements SignupViewInterface{

    SignupPresenter signupPresenter;
    Button signUpBtn;
    ImageButton backBtn;

    EditText name_editText;
    EditText email_editText;
    EditText password_editText;
    EditText confirmPassword_editText;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        sharedPref=new SharedPref(this);
        name_editText =findViewById(R.id.name_EditText);
        email_editText =findViewById(R.id.email_EditText);
        password_editText=findViewById(R.id.password_EditText);
        confirmPassword_editText=findViewById(R.id.confirmPassword_EditText);
        signUpBtn = findViewById(R.id.next_btn);
        backBtn=findViewById(R.id.back_btn);

        signupPresenter=new SignupPresenter(this);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =name_editText.getText().toString();
                String email =email_editText.getText().toString();
                String password =password_editText.getText().toString();
                String confirmPassword =confirmPassword_editText.getText().toString();

                if(!name.isEmpty()&&!email.isEmpty()&&password.equals(confirmPassword)&&!password.isEmpty()) {
                    signupPresenter.signup(name,email,password,confirmPassword);
                    sharedPref.write(email);
                }else{
                    if((name.isEmpty()||name==null)&&(email.isEmpty()||email==null)&&(password.isEmpty()||password==null)&&(confirmPassword.isEmpty()||confirmPassword==null)){
                        name_editText.setError("Name can't be empty");
                        email_editText.setError("Email can't be empty");
                        password_editText.setError("Password can't be empty");
                        confirmPassword_editText.setError("Confirm password can't be empty");

                    }
                    else{
                        if(email.isEmpty()||email==null){
                            email_editText.setError("Email can't be empty");
                        }
                        if(password.isEmpty()||password==null){
                            password_editText.setError("Password can't be empty");
                        }
                        if(confirmPassword.isEmpty()||confirmPassword==null){
                            confirmPassword_editText.setError("Confirm password can't be empty");
                        }
                        if(!password.equals(confirmPassword)){
                            password_editText.setError("Password and Comfirm Password should be the same");
                            confirmPassword_editText.setError("Password and Comfirm Password should be the same");
                        }
                    }
                }
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

    @Override
    public void onSuccessSignup() {
        Toast.makeText(SignupScreen.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(SignupScreen.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onFailureSignup(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}