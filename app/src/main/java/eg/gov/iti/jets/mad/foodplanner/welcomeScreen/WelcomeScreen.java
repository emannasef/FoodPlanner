package eg.gov.iti.jets.mad.foodplanner.welcomeScreen;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;


import eg.gov.iti.jets.mad.foodplanner.MainActivity;
import eg.gov.iti.jets.mad.foodplanner.Model.User;
import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.SharedPref;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.view.LoginScreenActivity;
import eg.gov.iti.jets.mad.foodplanner.signupScreen.view.SignupScreen;


public class WelcomeScreen extends AppCompatActivity {
TextView alreadyHaveAnAccountTextView;
    TextView loginTextView;
    Button skip ;
    Button signUpBtn;
    private SharedPref sharedPref;
    ImageButton googleBtn;
    private GoogleSignInClient client;
    FirebaseAuth auth;
    FirebaseUser user;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        sharedPref = new SharedPref(this);
        alreadyHaveAnAccountTextView=findViewById(R.id.Already_have_an_account_textView);
        loginTextView=findViewById(R.id.login_TextView);
        signUpBtn=findViewById(R.id.signupWithEmail_btn);
        skip=findViewById(R.id.skip_btn);
        googleBtn = findViewById(R.id.google_btn);
        database=FirebaseDatabase.getInstance("https://foodplanner-78891-default-rtdb.firebaseio.com/");

        auth=FirebaseAuth.getInstance();

        GoogleSignInOptions options=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        client= GoogleSignIn.getClient(this,options);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = client.getSignInIntent();
                startActivityForResult(i,123);
            }
        });

        alreadyHaveAnAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(WelcomeScreen.this, LoginScreenActivity.class);
                startActivity(i);
            }
        });
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(WelcomeScreen.this, LoginScreenActivity.class);
                startActivity(i);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogue();

            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(WelcomeScreen.this, SignupScreen.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==123){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                GoogleSignInAccount account =task.getResult(ApiException.class);
                AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
                auth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        if(task.isSuccessful()){
                            FirebaseUser user=auth.getCurrentUser();
                            User user1=new User();
                            assert user1 != null;
                            user1.setEmail(user.getEmail());
                            user1.setName(user.getDisplayName());
                            sharedPref.write(user.getEmail());
                            database.getReference().child("User").child(user.getDisplayName()).setValue(user1);
                            Intent i =new Intent(WelcomeScreen.this,MainActivity.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(WelcomeScreen.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            catch (ApiException e){
                e.printStackTrace();
            }
        }
    }
    void dialogue(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login as Guest?");
        builder.setMessage("You Will Have Some Capabilities as Guest");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                Intent i =new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(i);
                sharedPref.write("guest");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }
}