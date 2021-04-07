package com.example.locationproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager locmgr;
    List<String> locproviders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        locmgr = (LocationManager) getSystemService(LOCATION_SERVICE);

        locproviders= locmgr.getAllProviders();
        String s = "";
        for (int i  = 0; i < locproviders.size(); i++) {
            s += " LocProvider : " + locproviders.get(i) + "\n"
                + " Status : " + locmgr.isProviderEnabled(locproviders.get(i)) + " \n \n";
        }
        mTextView.setText(s);
    }
}