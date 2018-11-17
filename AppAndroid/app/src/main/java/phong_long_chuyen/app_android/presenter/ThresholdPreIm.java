package phong_long_chuyen.app_android.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import static phong_long_chuyen.app_android.config.Define.FIRE_THRES;
import static phong_long_chuyen.app_android.config.Define.FIRE_THRESHOLD;
import static phong_long_chuyen.app_android.config.Define.GAS_THRES;
import static phong_long_chuyen.app_android.config.Define.GAS_THRESHOLD;
import static phong_long_chuyen.app_android.config.Define.PREFERENCES_DATA;

public class ThresholdPreIm {

    private Context mContext;

    public ThresholdPreIm(Context context) {
        mContext = context;
    }

    public boolean saveThreshold(float gasThreshold, float fireThreshold) {
        SharedPreferences sharedPreferences
                = mContext.getSharedPreferences(PREFERENCES_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(GAS_THRES, gasThreshold);
        editor.putFloat(FIRE_THRES, fireThreshold);
        return editor.commit();
    }

    public float getGasThreshold() {
        SharedPreferences sharedPreferences
                = mContext.getSharedPreferences(PREFERENCES_DATA, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(GAS_THRES, GAS_THRESHOLD);
    }

    public float getFireThreshold() {
        SharedPreferences sharedPreferences
                = mContext.getSharedPreferences(PREFERENCES_DATA, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(FIRE_THRES, FIRE_THRESHOLD);
    }

}
