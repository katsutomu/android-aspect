package com.example.katsu.aspect;

import android.app.Application;

import com.firefly1126.permissionaspect.PermissionCheckSDK;

public class AspectApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        PermissionCheckSDK.init(this);
    }
}

