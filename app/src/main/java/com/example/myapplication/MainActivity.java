package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Intent goRules, goGame, goStatistics;
    Button start, rules, stats1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        rules = findViewById(R.id.rules);
        stats1 = findViewById(R.id.stats1);
    }

    public void goRules(View view) {
        goRules = new Intent(this, Rules.class);
        startActivity(goRules);
    }

    public void goGame(View view) {
        goGame = new Intent(this, Game.class);
        startActivity(goGame);
    }

    public void goStats(View view) {
        goStatistics = new Intent(this, Statistics.class);
        startActivity(goStatistics);
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
            return true;
        }
        else if (item.getItemId() == R.id.rulespage) {
            goRules = new Intent(this, Rules.class);
            startActivity(goRules);
            return true;
        }
        else if (item.getItemId()== R.id.homepage) {
            Toast.makeText(this, "You are already in the selected page!", Toast.LENGTH_LONG).show();
        }
        return true;

    }
}