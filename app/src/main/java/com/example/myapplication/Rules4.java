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

public class Rules4 extends AppCompatActivity {
    Button rules5;
    Intent goRules5,goStats,goMenu,goRules,goRules2,goRules3;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        menu.findItem(R.id.allRules).setVisible(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.statspage) {
            goStats = new Intent(this, Statistics.class);
            startActivity(goStats);


        } else if (item.getItemId() == R.id.homepage) {
            goMenu = new Intent(this, MainActivity.class);
            startActivity(goMenu);
        }
        else if (item.getItemId() == R.id.rulespage) {
            goRules = new Intent(this, Rules.class);
            startActivity(goRules);
        } else if (item.getItemId() == R.id.r2) {
            goRules2 = new Intent(this, Rules2.class);
            startActivity(goRules2);
        } else if (item.getItemId() == R.id.r3) {
            goRules3 = new Intent(this, Rules3.class);
            startActivity(goRules3);
            return true;
        } else if (item.getItemId() == R.id.r4) {
            Toast.makeText(this, "You are already in the selected page!", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.r5) {
            goRules5 = new Intent(this, Rules5.class);
            startActivity(goRules5);
        }
        return true;

    }
}