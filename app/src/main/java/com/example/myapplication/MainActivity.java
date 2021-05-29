package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Intent goRules, goGame, goStatistics, goMaps;
    Button start, rules, stats1, maps;
    private TextView battery;
    private BroadcastReceiver batteryReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            battery.setText(String.valueOf(level) + "%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        rules = findViewById(R.id.rules);
        stats1 = findViewById(R.id.stats1);
        maps = findViewById(R.id.maps);
        battery = findViewById(R.id.battery);
        this.registerReceiver(this.batteryReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    public void goRules(View view) {
        goRules = new Intent(this, Rules.class);
        startActivity(goRules);
        overridePendingTransition(R.anim.activityin, R.anim.activityout);
    }

    public void goGame(View view) {
        goGame = new Intent(this, Game.class);
        startActivity(goGame);
        overridePendingTransition(R.anim.activityin, R.anim.activityout);
    }

    public void goStats(View view) {
        goStatistics = new Intent(this, Statistics.class);
        startActivity(goStatistics);
        overridePendingTransition(R.anim.activityin, R.anim.activityout);
    }

    public void goMaps(View view) {
        goMaps = new Intent(this, Maps.class);
        startActivity(goMaps);
        overridePendingTransition(R.anim.activityin, R.anim.activityout);
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
            goStatistics = new Intent(this, Statistics.class);
            startActivity(goStatistics);
            overridePendingTransition(R.anim.activityin, R.anim.activityout);
            return true;
        } else if (item.getItemId() == R.id.rulespage) {
            goRules = new Intent(this, Rules.class);
            startActivity(goRules);
            overridePendingTransition(R.anim.activityin, R.anim.activityout);
            return true;
        } else if (item.getItemId() == R.id.homepage) {
            Toast.makeText(this, "You are already in the selected page!", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.maps) {
            goMaps = new Intent(this, Maps.class);
            startActivity(goMaps);
            overridePendingTransition(R.anim.activityin, R.anim.activityout);
        }
        return true;

    }
}



