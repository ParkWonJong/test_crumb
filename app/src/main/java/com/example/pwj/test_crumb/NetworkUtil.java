package com.example.pwj.test_crumb;
import android.annotation.SuppressLint;
import android.os.StrictMode;
/**
 * Created by PWJ on 2016-11-09.
 */

public class NetworkUtil {
    static public void setNetworkPolicy() {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}
