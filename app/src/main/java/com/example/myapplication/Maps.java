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
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

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
    int lon, lat;
    int stringCount = 0;
    String geoUriString;
    Button maps, reset;
    int[] locations;
    Uri geoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        maps = findViewById(R.id.maps);
        reset = findViewById(R.id.reset);
        readStats();

    }

    public void readStats() {

        try {
            fis = openFileInput("location1.txt");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            while ((st = br.readLine()) != null) {
                if (stringCount % 2 == 0)
                    lat = Integer.parseInt(st);
                else
                    lon = Integer.parseInt(st);
                stringCount++;
            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showMaps(View view) {
        locations = new int[stringCount];
        for (int i = 0; i < locations.length; i++) {
            geoUriString = "geo:" + locations[i] + "," + locations[i + 1] + "?z=13";
            geoUri = Uri.parse(geoUriString);
        }
        Intent map = new Intent(Intent.ACTION_VIEW, geoUri);
        startActivity(map);

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
        for (int i = 0; i < locations.length; i++) {
            locations[i] = Integer.parseInt(null);
        }

    }
}