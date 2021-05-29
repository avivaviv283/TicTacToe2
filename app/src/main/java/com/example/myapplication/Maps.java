package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Maps extends AppCompatActivity {

    FileInputStream fis;
    InputStreamReader isr;
    BufferedReader br;
    String st;
    String geoUriString;
    Button maps, reset;
    ArrayList<String> locations = new ArrayList<String>();
    Uri geoUri;
    Intent goRules, goMenu, goStatistics;
    String[] permissions = {Manifest.permission.INTERNET,Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_NETWORK_STATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        maps = findViewById(R.id.maps);
        reset = findViewById(R.id.reset);
        readStats();
        ActivityCompat.requestPermissions(this,permissions,1);
    }

    public void readStats() {
        try {
            fis = openFileInput("location1.txt");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            while ((st = br.readLine()) != null) {
                locations.add(st);
            }
            fis.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public void showMaps(View view) {
        if (locations.isEmpty() || locations.get(0) == null || locations.get(1) == null) {
            Toast.makeText(this, "Location Not Available, Please Finish a Game to Submit Current Location.", Toast.LENGTH_LONG).show();
            return;
        } else {
            geoUriString = "geo:" + locations.get(0) + "," + locations.get(1) + "?z=13";
            geoUri = Uri.parse(geoUriString);
            Intent map = new Intent(Intent.ACTION_VIEW, geoUri);
            startActivity(map);
        }
    }

    public void resetLocations(View view) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("location1.txt", Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        locations.clear();
        Toast.makeText(this, "Location Cleared", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.statspage) {
            Toast.makeText(this, "You are already in the selected page!", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.rulespage) {
            goRules = new Intent(this, Rules.class);
            startActivity(goRules);
            overridePendingTransition(R.anim.activityin, R.anim.activityout);
            return true;
        } else if (item.getItemId() == R.id.homepage) {
            goMenu = new Intent(this, MainActivity.class);
            startActivity(goMenu);
            overridePendingTransition(R.anim.activityin, R.anim.activityout);
        }
        if (item.getItemId() == R.id.maps) {
            Toast.makeText(this, "You are already in the selected page!", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.statspage) {
            goStatistics = new Intent(this, Statistics.class);
            startActivity(goStatistics);
            overridePendingTransition(R.anim.activityin, R.anim.activityout);
        }
        return true;

    }

    public void goMenu(View view) {
        goMenu = new Intent(this, MainActivity.class);
        startActivity(goMenu);
        overridePendingTransition(R.anim.activityin, R.anim.activityout);
    }
}

