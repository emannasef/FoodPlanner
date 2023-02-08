package eg.gov.iti.jets.mad.foodplanner.loginScreen;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    public static final String EMAIL_KEY = "emailKey";
    public static final String PASSWORD_KEY = "passwordKey";
    public static final String PREF_NAME = "shearedWriteHere";
    Context context;

    public SharedPref(Context context) {
        this.context = context;
    }

    public void write(){
        SharedPreferences sharedPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(EMAIL_KEY,"");
        editor.putString(PASSWORD_KEY, "");
        editor.commit();
    }
}
