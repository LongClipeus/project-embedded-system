package io.github.longclipeus.iotsystems.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import static io.github.longclipeus.iotsystems.config.Define.PASSWORD;

public class PasswordPreIm {

    private Context mContext;

    public PasswordPreIm(Context context) {
        mContext = context;
    }

    public String getPassword() {
        SharedPreferences settings = mContext.getSharedPreferences("preferences",
                Context.MODE_PRIVATE);
        return settings.getString(PASSWORD, "");
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
