package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Intent goRules, goGame ,goStatistics;
    Button start, rules, stats1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        rules=findViewById(R.id.rules);
        stats1=findViewById(R.id.stats1);
    }

    public void goRules(View view) {
        goRules= new Intent(this,Rules.class);
        startActivity(goRules);
    }

    public void goGame(View view) {
        goGame= new Intent(this,Game.class);
        startActivity(goGame);
    }
    public void goStats(View view) {
        goStatistics=new Intent( this,Statistics.class);
        startActivity(goStatistics);
    }


}