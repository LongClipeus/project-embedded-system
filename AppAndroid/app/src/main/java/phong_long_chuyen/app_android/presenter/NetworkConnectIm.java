package phong_long_chuyen.app_android.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static phong_long_chuyen.app_android.config.Define.MOBILE;
import static phong_long_chuyen.app_android.config.Define.WIFI;

public class NetworkConnectIm implements NetworkConnect {

    private Context mContext;

    public NetworkConnectIm(Context context) {
        mContext = context;
    }

    @Override
    public boolean isNetworkConnected() {
        boolean connectedWifi = false;
        boolean connectedMobile = false;
        ConnectivityManager cm = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        if (netInfo == null) {
            return false;
        }

        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase(WIFI)) {
                if (ni.isConnected()) {
                    connectedWifi = true;
                }
            }
            if (ni.getTypeName().equalsIgnoreCase(MOBILE)) {
                if (ni.isConnected()) {
                    connectedMobile = true;
                }
            }
        }
        return connectedWifi || connectedMobile;
    }

}
