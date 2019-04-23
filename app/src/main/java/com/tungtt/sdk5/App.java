package com.tungtt.sdk5;

import android.support.multidex.MultiDexApplication;
import uizalivestream.util.UZUtil;
import vn.uiza.core.common.Constants;

public class App extends MultiDexApplication {
    public static final String DF_DoMain_Api = "ap-southeast-1-api.uiza.co";
    public static final String DF_TOKEN = "YOUR_TOKEN_API";
    public static final String DF_AppId = "YOUR_APP_ID";
    public static String entityIdDefaultLIVE_TRANSCODE = "YOUR_ENTITY_TRANSCODE";

    @Override
    public void onCreate() {
        super.onCreate();
        Constants.setDebugMode(false);
        UZUtil.initWorkspace(this,4, DF_DoMain_Api, DF_TOKEN, DF_AppId);
    }
}
