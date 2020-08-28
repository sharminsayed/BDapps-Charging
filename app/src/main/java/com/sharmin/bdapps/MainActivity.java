package com.sharmin.bdapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sharmin.charging.AdsLib;
import com.sharmin.charging.SP;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize adslib
        AdsLib adsLib=ChargingInstance.getAdsLib();
        //Checking Subscription Status
        adsLib.checkSubStatus(SP.getSubCode());
        //Subscribe for this application
        adsLib.subscribe();
    }
}