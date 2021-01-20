package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent goRules, goGame;
    Button start, rules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        rules=findViewById(R.id.rules);
    }

    public void goRules(View view) {
        goRules= new Intent(this,Rules.class);
        startActivity(goRules);
    }

    public void goGame(View view) {
        goGame= new Intent(this,Game.class);
        startActivity(goGame);
    }
}