package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rules2 extends AppCompatActivity {
    Button rules3;
    Intent goRules3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules2);
        rules3=findViewById(R.id.rules3);
    }

    public void goRules3(View view) {
        goRules3= new Intent(this,Rules3.class);
        startActivity(goRules3);
    }
}