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

public class Rules extends AppCompatActivity {
    Button rules2;
    Intent goRules2,goRules3,goRules4,goRules5, goMenu, goStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        rules2 = findViewById(R.id.rules2);

    }

    public void goRules2(View view) {
        goRules2 = new Intent(this, Rules2.class);
        startActivity(goRules2);
        overridePendingTransition(R.anim.activityin,R.anim.activityout);

    }

    @Override
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

        } else if (item.getItemId() == R.id.rulespage) {
            Toast.makeText(this, "You are already in the selected page!", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.homepage) {
            goMenu = new Intent(this, MainActivity.class);
            startActivity(goMenu);
            overridePendingTransition(R.anim.activityin,R.anim.activityout);

        } else if (item.getItemId() == R.id.r2) {
            goRules2 = new Intent(this, Rules2.class);
            startActivity(goRules2);
            overridePendingTransition(R.anim.activityin,R.anim.activityout);
        }
        else if (item.getItemId() == R.id.r3) {
            goRules3 = new Intent(this, Rules3.class);
            startActivity(goRules3);
            overridePendingTransition(R.anim.activityin,R.anim.activityout);
        }
        else if (item.getItemId() == R.id.r4) {
            goRules4 = new Intent(this, Rules4.class);
            startActivity(goRules4);
            overridePendingTransition(R.anim.activityin,R.anim.activityout);
        }
        else if (item.getItemId() == R.id.r5) {
            goRules5 = new Intent(this, Rules5.class);
            startActivity(goRules5);
            overridePendingTransition(R.anim.activityin,R.anim.activityout);
        }
        return true;

    }

}
