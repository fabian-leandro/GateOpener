package com.gate_opener.roberto.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int PHONE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openGate(View view) {

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            // permissions granted, call the number to open gate
            Uri gateNumber = Uri.parse("tel:70940581");
            Intent openGateInt = new Intent(Intent.ACTION_CALL, gateNumber);
            startActivity(openGateInt);
        } else {
            // request permissions
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},PHONE_CALL);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PHONE_CALL: {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    // permissions granted, call the number to open gate
                    Uri gateNumber = Uri.parse("tel:70940581");
                    Intent openGateInt = new Intent(Intent.ACTION_CALL, gateNumber);
                    startActivity(openGateInt);
                }
            }
        }
    }
}
