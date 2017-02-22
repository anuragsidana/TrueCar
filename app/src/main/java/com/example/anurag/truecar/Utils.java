package com.example.anurag.truecar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by anurag on 2/20/2017.
 */

public class Utils {

    public static boolean isConnected(Context context){
        ConnectivityManager cManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();
        return nInfo!=null&&nInfo.isConnectedOrConnecting()&&nInfo.isAvailable();
    }
}
