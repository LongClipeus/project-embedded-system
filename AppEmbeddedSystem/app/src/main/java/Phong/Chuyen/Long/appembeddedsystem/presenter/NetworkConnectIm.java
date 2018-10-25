package Phong.Chuyen.Long.appembeddedsystem.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkConnectIm implements NetworkConnect {

    private Context mContext;

    public NetworkConnectIm(Context context) {
        mContext = context;
    }

    @Override
    public boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

}
