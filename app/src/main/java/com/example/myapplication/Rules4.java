package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rules4 extends AppCompatActivity {
    Button rules5;
    Intent goRules5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules4);
        rules5=findViewById(R.id.rules5);
    }

    public void goRules5(View view) {
        goRules5=new Intent(this, Rules5.class);
        startActivity(goRules5);
    }
}