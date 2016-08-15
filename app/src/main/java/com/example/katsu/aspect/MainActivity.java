package com.example.katsu.aspect;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.hujiang.permissiondispatcher.NeedPermission;

@NeedPermission(permissions = {Manifest.permission.READ_CONTACTS})
public class MainActivity extends AppCompatActivity {
    public static boolean isLogin = false;
    public static boolean hasParam = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clip();
//                if (ContextCompat.checkSelfPermission(MainActivity.this,
//                        Manifest.permission.READ_CONTACTS)
//                        != PackageManager.PERMISSION_GRANTED) {
//
//                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
//                            Manifest.permission.READ_CONTACTS)) {
//                        ActivityCompat.requestPermissions(MainActivity.this,
//                                new String[]{Manifest.permission.READ_CONTACTS},
//                                1);
//
//                    } else {
//                        ActivityCompat.requestPermissions(MainActivity.this,
//                                new String[]{Manifest.permission.READ_CONTACTS},
//                                1);
//
//                    }
//                }
            }
        });

    }

    @NeedLogin
    @NeedProfile
    public void Clip() {
        Log.d("clip!","Cliped!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
