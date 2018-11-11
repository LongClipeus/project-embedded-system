package phong_long_chuyen.app_android.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import static phong_long_chuyen.app_android.config.Define.PASSWORD;
import static phong_long_chuyen.app_android.config.Define.PREFERENCES_DATA;

public class PasswordPreIm {

    private Context mContext;

    public PasswordPreIm(Context context) {
        mContext = context;
    }

    public boolean savePassword(String password) {
        SharedPreferences sharedPreferences
                = mContext.getSharedPreferences(PREFERENCES_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PASSWORD, password);
        return editor.commit();
    }

    public boolean removePassword() {
        SharedPreferences sharedPreferences
                = mContext.getSharedPreferences(PREFERENCES_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(PASSWORD);
        return editor.commit();
    }

    public String getPassword() {
        SharedPreferences sharedPreferences
                = mContext.getSharedPreferences(PREFERENCES_DATA, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PASSWORD, "");
    }

    public boolean isPassword() {
        if (getPassword().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkPass(String password) {
        if (password.equals(getPassword())) {
            return true;
        } else {
            return false;
        }
    }

}
