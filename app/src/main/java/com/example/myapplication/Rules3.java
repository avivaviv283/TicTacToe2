package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rules3 extends AppCompatActivity {
    Button rules4;
    Intent goRules4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules3);
    }

    public void goRules4(View view) {
        goRules4=new Intent(this, Rules4.class);
        startActivity(goRules4);
    }
}