package com.example.katsu.aspect;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BridgeActivity extends AppCompatActivity {
    private static ActivityResultListner activityResultListner = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridge);
        Intent intent;
        if (getIntent().getIntExtra("request",0) == 1) {
            intent = new Intent(this, LoginActivity.class);
        } else {
            intent = new Intent(this, AddProfileActivity.class);
        }
        this.startActivityForResult(intent,12345);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (activityResultListner != null) {
            activityResultListner.onActivityResult(this);
        }
    }
    public static void setActivityResultListner(ActivityResultListner listner) {
        activityResultListner = listner;
    }
    public interface ActivityResultListner {
        void onActivityResult(Activity activity);
    }
}
