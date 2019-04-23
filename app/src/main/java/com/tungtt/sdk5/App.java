package com.tungtt.sdk5;

import android.support.multidex.MultiDexApplication;
import uizalivestream.util.UZUtil;
import vn.uiza.core.common.Constants;

public class App extends MultiDexApplication {
    public static final String DF_DoMain_Api = "ap-southeast-1-api.uiza.co";
    public static final String DF_TOKEN = "uap-b99d6b58428043ffbbc2091054ef3442-dae7e075";
    public static final String DF_AppId = "b99d6b58428043ffbbc2091054ef3442";
    public static String entityIdDefaultLIVE_TRANSCODE = "118e2ae0-7462-489d-b884-1d13eb422b48";

    @Override
    public void onCreate() {
        super.onCreate();
        Constants.setDebugMode(false);
        UZUtil.initWorkspace(this,4, DF_DoMain_Api, DF_TOKEN, DF_AppId);
    }
}
