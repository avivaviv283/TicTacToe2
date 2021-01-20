package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rules extends AppCompatActivity {
    Button rules2;
    Intent goRules2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        rules2=findViewById(R.id.rules2);
    }

    public void goRules2(View view) {
        goRules2=new Intent(this,Rules2.class);
        startActivity(goRules2);

    }
}