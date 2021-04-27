package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Statistics extends AppCompatActivity {
    Button toMenu, reset;
    Intent goMenu, goRules;
    StatsRead stats = new StatsRead();
    FileInputStream fis;
    InputStreamReader isr;
    BufferedReader br;
    String st;
    ArrayList<String> alStats;
    ArrayAdapter adap;
    ListView lvStats;
    int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        toMenu = findViewById(R.id.menu);
        reset = findViewById(R.id.reset);
        lvStats = findViewById(R.id.lvStats);
        readStats();
    }


    public void goMenu(View view) {
        goMenu = new Intent(this, MainActivity.class);
        startActivity(goMenu);
        overridePendingTransition(R.anim.activityin,R.anim.activityout);
    }


    public void readStats() {
        try {
            fis = openFileInput("stats.txt");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            while ((st = br.readLine()) != null) {
                if (!st.equals("X") && !st.equals("O") && !st.equals("T")) {
                    if (parseInt(st) > 0) {
                        counter += Integer.parseInt(st);
                    }
                }
                if (st.equals("O"))
                    stats.setOwin(parseInt(stats.getOwin()) + 1);
                if (st.equals("X"))
                    stats.setXwin(parseInt(stats.getXwin()) + 1);
                if (st.equals("T"))
                    stats.setTie(parseInt(stats.getTie()) + 1);
            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stats.setNumPressed(counter);
        alStats = new ArrayList<>();
        alStats.add("Number of Presses: " + stats.getNumPressed());
        alStats.add("X wins: " + stats.getXwin());
        alStats.add("O wins: " + stats.getOwin());
        alStats.add("Ties: " + stats.getTie());
        adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alStats);
        lvStats.setAdapter(adap);

    }


    public void resetStats(View view) {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("stats.txt", Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        alStats.clear();
        alStats.add("Number of Presses: 0");
        alStats.add("X wins: 0");
        alStats.add("O wins: 0");
        alStats.add("Ties: 0");
        adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alStats);
        lvStats.setAdapter(adap);

        stats.setTie(0);
        stats.setXwin(0);
        stats.setNumPressed(0);
        stats.setOwin(0);

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
            overridePendingTransition(R.anim.activityin,R.anim.activityout);
            return true;
        } else if (item.getItemId() == R.id.homepage) {
            goMenu = new Intent(this, MainActivity.class);
            startActivity(goMenu);
            overridePendingTransition(R.anim.activityin,R.anim.activityout);
        }
        return true;

    }

}