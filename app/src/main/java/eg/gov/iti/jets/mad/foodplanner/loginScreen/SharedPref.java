package eg.gov.iti.jets.mad.foodplanner.loginScreen;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    public static final String EMAIL_KEY = "emailKey";
    public static final String PASSWORD_KEY = "passwordKey";
    public static final String PREF_NAME = "foodPlanner";
    Context context;

    public SharedPref(Context context) {
        this.context = context;
    }

    public void write(String emailVal) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(EMAIL_KEY, emailVal);
       // editor.putString(PASSWORD_KEY, passwordVal);
        editor.commit();
    }

    public String read() {

        SharedPreferences prf = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String emailVa = prf.getString(EMAIL_KEY, "foodPlanner@gmail.com");
        return emailVa;
    }


}
