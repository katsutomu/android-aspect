package com.example.katsu.aspect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AddProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);
        Button loginButton = (Button)findViewById(R.id.addProfileBotton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("AddProfileActivity","AddProfile!!");
                MainActivity.hasParam = true;
                setResult(12345);
                finish();
            }
        });
    }
}
