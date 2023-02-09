package eg.gov.iti.jets.mad.foodplanner.loginScreen.presenter;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import eg.gov.iti.jets.mad.foodplanner.loginScreen.view.LoginScreenActivity;
import eg.gov.iti.jets.mad.foodplanner.loginScreen.view.LoginViewInterface;

public class LoginPresenter implements LoginPresenterInterface {
    private static final String TAG = "Login";

    private FirebaseAuth firebaseAuth;

    LoginViewInterface loginViewInterface;

    public LoginPresenter(LoginViewInterface loginViewInterface) {

        this.firebaseAuth = FirebaseAuth.getInstance();

        this.loginViewInterface = loginViewInterface;
    }

    @Override
    public void Login(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    loginViewInterface.onSuccessLogin();
                } else {
                    loginViewInterface.onFailureLogin("Login Failed");
                }
            }
        });

    }
}
