package eg.gov.iti.jets.mad.foodplanner.signupScreen.presenter;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;

import eg.gov.iti.jets.mad.foodplanner.Model.User;
import eg.gov.iti.jets.mad.foodplanner.signupScreen.view.SignupViewInterface;

public class SignupPresenter implements  SignupPresenterInterface{
    private static final String TAG = "Signup";
    SignupViewInterface signupViewInterface;
    FirebaseAuth auth;
    FirebaseDatabase database;
    public SignupPresenter(SignupViewInterface signupViewInterface){
        this.signupViewInterface=signupViewInterface;
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance("https://foodplanner-78891-default-rtdb.firebaseio.com/");

    }

    @Override
    public void signup(String name, String email, String password, String confirmPassword) {

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    User user1=new User();
                    assert user1 != null;
                    user1.setEmail(email);
                    user1.setName(name);
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                    auth.getCurrentUser().updateProfile(profileUpdates);
                    database.getReference().child("User").child(name).setValue(user1);
                    signupViewInterface.onSuccessSignup();
                }
                else {
                    signupViewInterface.onFailureSignup("Signup Failed");
                }
            }
        });
    }
}
