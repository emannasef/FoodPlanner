package eg.gov.iti.jets.mad.foodplanner.Profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import eg.gov.iti.jets.mad.foodplanner.R;
import eg.gov.iti.jets.mad.foodplanner.welcomeScreen.WelcomeScreen;


public class ProfileFragment extends Fragment {

    Button logoutBtn;
    FirebaseAuth auth;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name_textView;
    TextView email_TextView;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logoutBtn=view.findViewById(R.id.logoutButton);
        name_textView=view.findViewById(R.id.userName);
        email_TextView=view.findViewById(R.id.email);
        auth=FirebaseAuth.getInstance();

        gso =new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(getContext(),gso);

        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(getContext());
        if(account!=null){
            name_textView.setText(account.getDisplayName());
            email_TextView.setText(account.getEmail());
        }
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                   @Override
                   public void onComplete(@NonNull Task<Void> task) {
                       Intent i =new Intent(getContext(), WelcomeScreen.class);
                       i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                       startActivity(i);
                   }
               });

            }
        });
    }
}