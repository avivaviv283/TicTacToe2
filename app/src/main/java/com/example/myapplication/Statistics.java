package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

import static java.lang.Integer.parseInt;

public class Statistics extends AppCompatActivity {
    Button toMenu,reset;
    Intent goMenu;
    TextView timeO, timeX, timePressed;
    FileInputStream fis;
    InputStreamReader isr;
    BufferedReader br;
    String st;
    int Owin, Xwin;
    int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        toMenu = findViewById(R.id.menu);
        reset=findViewById(R.id.reset);
        timeO = findViewById(R.id.timeO);
        timeX = findViewById(R.id.timeX);
        timePressed = findViewById(R.id.timePressed);
        readStats();
    }


    public void goMenu(View view) {
        goMenu = new Intent(this, MainActivity.class);
        startActivity(goMenu);
    }


    public void readStats() {
        try {
            fis = openFileInput("stats1.txt");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            while ((st = br.readLine()) != null) {
//                if (!st.equals("X") && !st.equals("O")) {
//                    if (parseInt(st) > 0) {
//                        counter = parseInt(st);
//                    }
//                }
                if (st.equals("O"))
                    Owin++;
                if (st.equals("X"))
                    Xwin++;
            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        timePressed.setText("Time Pressed:" + counter);
        timeO.setText("Times O won: " + Owin);
        timeX.setText("Times X won: " + Xwin);
    }


    public void resetStats(View view) {
        try {
            fis = openFileInput("stats1.txt");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            while ((st = br.readLine()) != null) {
                br.reset();
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}