package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Game extends AppCompatActivity implements View.OnClickListener, LocationListener {

    Button[] btnsg1, btnsg2, btnsg3, btnsg4, btnsg5, btnsg6, btnsg7, btnsg8, btnsg9;
    Button btnResetGame;
    Button[][] arr = new Button[9][9];
    int[] boardState = new int[9];
    int goTo = 0;
    final int noWin = 0;
    final int X = 1;
    final int O = 2;
    final int Tie = 3;
    TextView tvWin, indicateTurn;
    Intent goMenu;
    int counter = 0;
    int btnCount = 0;
    GridLayout grid;
    String provider;
    LocationManager locman;
    Location local;
    String lonString, latString;
    String[] permissions = {Manifest.permission.INTERNET, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_NETWORK_STATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tvWin = findViewById(R.id.tvWin);
        tvWin.setVisibility(View.INVISIBLE);
        btnResetGame = findViewById(R.id.btnResetGame);
        btnResetGame.setOnClickListener(this);
        btnResetGame.setVisibility(View.INVISIBLE);
        indicateTurn = findViewById(R.id.indicateTurn);
        grid = findViewById(R.id.grid);
        btnsg1 = new Button[9];
        btnsg2 = new Button[9];
        btnsg3 = new Button[9];
        btnsg4 = new Button[9];
        btnsg5 = new Button[9];
        btnsg6 = new Button[9];
        btnsg7 = new Button[9];
        btnsg8 = new Button[9];
        btnsg9 = new Button[9];
        btnsg1[0] = findViewById(R.id.g11);
        btnsg1[1] = findViewById(R.id.g12);
        btnsg1[2] = findViewById(R.id.g13);
        btnsg1[3] = findViewById(R.id.g14);
        btnsg1[4] = findViewById(R.id.g15);
        btnsg1[5] = findViewById(R.id.g16);
        btnsg1[6] = findViewById(R.id.g17);
        btnsg1[7] = findViewById(R.id.g18);
        btnsg1[8] = findViewById(R.id.g19);

        btnsg2[0] = findViewById(R.id.g21);
        btnsg2[1] = findViewById(R.id.g22);
        btnsg2[2] = findViewById(R.id.g23);
        btnsg2[3] = findViewById(R.id.g24);
        btnsg2[4] = findViewById(R.id.g25);
        btnsg2[5] = findViewById(R.id.g26);
        btnsg2[6] = findViewById(R.id.g27);
        btnsg2[7] = findViewById(R.id.g28);
        btnsg2[8] = findViewById(R.id.g29);

        btnsg3[0] = findViewById(R.id.g31);
        btnsg3[1] = findViewById(R.id.g32);
        btnsg3[2] = findViewById(R.id.g33);
        btnsg3[3] = findViewById(R.id.g34);
        btnsg3[4] = findViewById(R.id.g35);
        btnsg3[5] = findViewById(R.id.g36);
        btnsg3[6] = findViewById(R.id.g37);
        btnsg3[7] = findViewById(R.id.g38);
        btnsg3[8] = findViewById(R.id.g39);

        btnsg4[0] = findViewById(R.id.g41);
        btnsg4[1] = findViewById(R.id.g42);
        btnsg4[2] = findViewById(R.id.g43);
        btnsg4[3] = findViewById(R.id.g44);
        btnsg4[4] = findViewById(R.id.g45);
        btnsg4[5] = findViewById(R.id.g46);
        btnsg4[6] = findViewById(R.id.g47);
        btnsg4[7] = findViewById(R.id.g48);
        btnsg4[8] = findViewById(R.id.g49);

        btnsg5[0] = findViewById(R.id.g51);
        btnsg5[1] = findViewById(R.id.g52);
        btnsg5[2] = findViewById(R.id.g53);
        btnsg5[3] = findViewById(R.id.g54);
        btnsg5[4] = findViewById(R.id.g55);
        btnsg5[5] = findViewById(R.id.g56);
        btnsg5[6] = findViewById(R.id.g57);
        btnsg5[7] = findViewById(R.id.g58);
        btnsg5[8] = findViewById(R.id.g59);

        btnsg6[0] = findViewById(R.id.g61);
        btnsg6[1] = findViewById(R.id.g62);
        btnsg6[2] = findViewById(R.id.g63);
        btnsg6[3] = findViewById(R.id.g64);
        btnsg6[4] = findViewById(R.id.g65);
        btnsg6[5] = findViewById(R.id.g66);
        btnsg6[6] = findViewById(R.id.g67);
        btnsg6[7] = findViewById(R.id.g68);
        btnsg6[8] = findViewById(R.id.g69);

        btnsg7[0] = findViewById(R.id.g71);
        btnsg7[1] = findViewById(R.id.g72);
        btnsg7[2] = findViewById(R.id.g73);
        btnsg7[3] = findViewById(R.id.g74);
        btnsg7[4] = findViewById(R.id.g75);
        btnsg7[5] = findViewById(R.id.g76);
        btnsg7[6] = findViewById(R.id.g77);
        btnsg7[7] = findViewById(R.id.g78);
        btnsg7[8] = findViewById(R.id.g79);

        btnsg8[0] = findViewById(R.id.g81);
        btnsg8[1] = findViewById(R.id.g82);
        btnsg8[2] = findViewById(R.id.g83);
        btnsg8[3] = findViewById(R.id.g84);
        btnsg8[4] = findViewById(R.id.g85);
        btnsg8[5] = findViewById(R.id.g86);
        btnsg8[6] = findViewById(R.id.g87);
        btnsg8[7] = findViewById(R.id.g88);
        btnsg8[8] = findViewById(R.id.g89);

        btnsg9[0] = findViewById(R.id.g91);
        btnsg9[1] = findViewById(R.id.g92);
        btnsg9[2] = findViewById(R.id.g93);
        btnsg9[3] = findViewById(R.id.g94);
        btnsg9[4] = findViewById(R.id.g95);
        btnsg9[5] = findViewById(R.id.g96);
        btnsg9[6] = findViewById(R.id.g97);
        btnsg9[7] = findViewById(R.id.g98);
        btnsg9[8] = findViewById(R.id.g99);

        arr[0] = btnsg1;
        arr[1] = btnsg2;
        arr[2] = btnsg3;
        arr[3] = btnsg4;
        arr[4] = btnsg5;
        arr[5] = btnsg6;
        arr[6] = btnsg7;
        arr[7] = btnsg8;
        arr[8] = btnsg9;

        setArr();
        Arrays.fill(boardState, noWin);
        locman = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locman.getBestProvider(criteria, true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locman.requestLocationUpdates(provider, 0, 0, this);
        ActivityCompat.requestPermissions(this, permissions, 1);

    }

    //  Sets all Listeners for Buttons
    public void setArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j].setOnClickListener(this);
                btnCount++;
                arr[i][j].setBackgroundColor(Color.CYAN);
                arr[i][j].getBackground().setAlpha(255);
            }
        }
    }


    public void onClick(View v) {

        if (btnResetGame == v) {
            this.reset();
        } else {
            int i = Integer.parseInt(getResources().getResourceEntryName(v.getId()).substring(1, 2)) - 1; // Gets location of primary square
            int j = Integer.parseInt(getResources().getResourceEntryName(v.getId()).substring(2)) - 1; // Gets location of secondary square

            if (!arr[i][j].getText().equals("")) { // Unable to click on filled square
                Toast.makeText(this, "Square already filled!", Toast.LENGTH_SHORT).show();
            } else {
                takeTurn(i, j);
                disable();

                if (boardState[goTo] != noWin) {
                    enable();
                }
                if (allFilled(i) && boardState[i] == noWin) {
                    boardState[i] = Tie;
                }
                if (isSameSquare(i, j) && !winSquare(i, j).equals("")) {// checks if secondary square clicked goes to the same primary square
                    enable();
                }

                if (!winSquare(i, j).equals("")) { // Checks if any primary square is won
                    turnWonSquareDisabled(i);
                    indicateWin(i, j);


                    if (!isWinBigSquare(i).equals("")) {// Checks if the game ended and there is a winner
                        indicateBigWin(i);
                        sendStats(i);
                        createDialog();
                        if (latString != null || lonString != null) {
                            sendMapStats();
                        }


                    }

                    if (allFilledTie(i) && isWinBigSquare(i).equals("")) { // Checks if the game ended and there is not a winner
                        indicateNoWin(i);
                        sendStats(i);
                        createDialog();
                        if (latString != null || lonString != null) {
                            sendMapStats();
                        }


                    }


                }
            }
        }
        if (btnResetGame.getVisibility() == View.INVISIBLE) { // Reset board button
            btnResetGame.setVisibility(View.VISIBLE);
        }

    }

    public void turnWonSquareDisabled(int i) { // Setting a primary square disabled
        for (int k = 0; k < arr.length; k++) {
            arr[i][k].setEnabled(false);
            arr[i][k].getBackground().setAlpha(100);
        }
    }

    public void takeTurn(int i, int j) { // Switch turns every button click
        indicateTurn.setVisibility(View.VISIBLE);
        if (counter % 2 == 0) {
            arr[i][j].setText("O");
            indicateTurn.setText("X turn");

        } else {
            arr[i][j].setText("X");
            indicateTurn.setText("O turn");

        }
        counter++;
        goTo = j;
    }


    public void disable() { // disables entire board leaving undecided squares enabled
        Button[][] temp = arr;
        for (int i = 0; i < temp.length; i++) {
            if (i != goTo) {
                for (int j = 0; j < temp.length; j++) {
                    temp[i][j].setEnabled(false);
                    temp[i][j].getBackground().setAlpha(100);
                }
            }
            for (int k = 0; k < arr[goTo].length; k++) {
                arr[goTo][k].setEnabled(true);
                arr[goTo][k].setBackgroundColor(Color.CYAN);
                arr[goTo][k].getBackground().setAlpha(255);
            }

        }
    }

    public void enable() { // enables all squares that are undecided
        Button[][] temp = arr;
        for (int i = 0; i < temp.length; i++) {
            if (boardState[i] == noWin) {
                for (int j = 0; j < temp.length; j++) {
                    temp[i][j].setEnabled(true);
                    temp[i][j].setBackgroundColor(Color.CYAN);
                    temp[i][j].getBackground().setAlpha(255);
                }
            } else {
                for (int l = 0; l < temp.length; l++) {
                    temp[i][l].setEnabled(false);
                    temp[i][l].getBackground().setAlpha(100);
                }
            }
            if (boardState[i] == Tie) {
                for (int l = 0; l < temp.length; l++) {
                    temp[i][l].setEnabled(false);
                    temp[i][l].getBackground().setAlpha(100);
                }
            }
        }
    }

    public boolean isSameSquare(int i, int j) { // checks if a primary square and a secondary square has the same value
        return i == j;

    }


    public void reset() { // Resets entire board
        tvWin.setVisibility(View.INVISIBLE);
        indicateTurn.setVisibility(View.INVISIBLE);
        btnResetGame.setVisibility(View.INVISIBLE);
        for (int i = 0; i < arr.length; i++) {
            boardState[i] = noWin;
            for (int j = 0; j < arr.length; j++) {
                arr[i][j].setText("");
                arr[i][j].setEnabled(true);
                arr[i][j].setBackgroundColor(Color.CYAN);
                arr[i][j].getBackground().setAlpha(255);
            }
        }
    }


    public void goMenu(View view) {
        goMenu = new Intent(this, MainActivity.class);
        startActivity(goMenu);
        overridePendingTransition(R.anim.activityin, R.anim.activityout);
    }

    public boolean findColumn(int i, int j) { // Find if any player won a primary square by completing column
        int flag = 0;
        String text = arr[i][j].getText().toString();
        for (int k = j % 3; k <= 8; k += 3) {
            if (!text.equals(arr[i][k].getText().toString())) {

                break;
            }
            flag++;

        }
        return flag == 3;
    }

    public boolean findRow(int i, int j) { // Find if any player won a primary square by completing row
        int flag = 0;
        String text = arr[i][j].getText().toString();
        for (int k = j - j % 3; k < j - j % 3 + 3; k++) {
            if (!text.equals(arr[i][k].getText().toString())) {
                break;
            }
            flag++;

        }


        return flag == 3;
    }

    public boolean findDiagonal(int i, int j) { // Find if any player won a primary square by completing diagonal
        int flag = 0;
        String text = arr[i][j].getText().toString();
        if (j % 2 == 0) {
            if (j % 4 == 0) {
                for (int k = 0; k <= 8; k += 4) {

                    if (!text.equals(arr[i][k].getText().toString())) {
                        break;
                    }
                    flag++;

                }
                if (flag == 3) {
                    return true;
                }
                flag = 0;

            }
            if (j == 4 || j % 4 != 0) {
                for (int k = 2; k <= 6; k += 2) {
                    if (!text.equals(arr[i][k].getText().toString())) {
                        break;
                    }
                    flag++;

                }
                return flag == 3;
            }
        }
        return false;

    }


    public String winSquare(int i, int j) { // Checks whether any player won a primary square and returns player's played  shape
        String text = arr[i][j].getText().toString();
        if (findRow(i, j) || findColumn(i, j) || findDiagonal(i, j)) {
            return text;
        }

        return "";
    }

    public boolean findBigColumn(int i) { // Checks if any player won the game by getting 3 primary squares in a column
        int flag = 0;
        int text = boardState[i];
        for (int k = i % 3; k <= 8; k += 3) {
            if (boardState[k] != text) {
                break;
            }
            flag++;
        }
        return flag == 3;

    }

    public boolean findBigRow(int i) { // Checks if any player won the game by getting 3 primary squares in a row
        int flag = 0;
        int text = boardState[i];
        for (int k = i - i % 3; k < i - i % 3 + 3; k++) {
            if (boardState[k] != text) {
                break;
            }
            flag++;
        }
        return flag == 3;
    }

    public boolean findBigDiagonal(int i) { // Checks if any player won the game by getting 3 primary squares in a row
        int flag = 0;
        int text = boardState[i];
        if (i % 2 == 0) {
            if (i % 4 == 0) {
                for (int k = 0; k <= 8; k += 4) {

                    if (boardState[k] != text) {
                        break;
                    }
                    flag++;

                }
                if (flag == 3) {
                    return true;
                }
                flag = 0;

            }
            if (i == 4 || i % 4 != 0) {
                for (int k = 2; k <= 6; k += 2) {
                    if (boardState[k] != text) {

                        break;
                    }
                    flag++;

                }
                return flag == 3;
            }
        }
        return false;


    }

    public String isWinBigSquare(int i) { // checks whether any play won the game and returning the player's played shape
        int text = boardState[i];
        if (findBigColumn(i) || findBigRow(i) || findBigDiagonal(i)) {
            if (text == X)
                return "X";
            if (text == O)
                return "O";
        }
        return "";


    }

    public void createDialog() { // Creates a rating dialog
        AlertDialog d = new AlertDialog.Builder(this).create();
        AlertDialog d1 = new AlertDialog.Builder(this).create();
        d.setTitle("Did you enjoy the game?");
        d1.setTitle("What would you rate the game?");
        d.setCancelable(false);
        d1.setCancelable(false);
        d.setButton(AlertDialog.BUTTON_NEUTRAL, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                d1.show();
                dialog.dismiss();
            }
        });
        d.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                d1.show();
                dialog.dismiss();
            }
        });
        d1.setButton(AlertDialog.BUTTON_NEUTRAL, "5 Stars", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                makeToast();


            }

        });
        d1.setButton(AlertDialog.BUTTON_POSITIVE, "5 Stars", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                makeToast();


            }
        });

        d.show();


    }

    public void makeToast() {
        Toast.makeText(this, "Thanks for rating us!", Toast.LENGTH_LONG).show();
    }

    public void indicateWin(int i, int j) { // indicating win if any player won a primary square
        if (winSquare(i, j).equals("X")) {
            for (int l = 0; l < arr.length; l++) {
                arr[i][l].setText("");
            }
            for (int k = 0; k < arr.length; k += 2) {
                arr[i][k].setText("X");
                makeAnim(arr[i][k]);
            }
            boardState[i] = X;
        }
        if (winSquare(i, j).equals("O")) {
            for (int k = 0; k < arr.length; k++) {
                if (k != 4) {
                    arr[i][k].setText("O");
                    makeAnim(arr[i][k]);
                }
                arr[i][4].setText("");
            }
            boardState[i] = O;
        }


    }

    public void makeAnim(Object o) {
        Animation enlarge = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        if (o instanceof Button) {
            ((Button) o).setAnimation(enlarge);
        }
        if (o instanceof TextView)
            ((TextView) o).setAnimation(enlarge);

    }

    public void indicateBigWin(int i) { // indicating win if any player won the game

        tvWin.setText(isWinBigSquare(i) + "Wins!");
        indicateTurn.setVisibility(View.INVISIBLE);
        tvWin.setVisibility(View.VISIBLE);

        indicateTurn.setVisibility(View.GONE);
        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr.length; l++) {
                arr[k][l].setEnabled(false);
                arr[k][l].getBackground().setAlpha(100);
            }
        }
    }

    public boolean allFilledTie(int i) { // checks if all the primary squares are filled
        int count = 0;
        for (int k = 0; k < boardState.length; k++) {
            if (boardState[k] != noWin) {
                count++;
            }
        }
        return count == 9;
    }

    public boolean allFilled(int i) { // check if 9x9 small square is all filled
        int count = 0;
        for (int k = 0; k < btnsg1.length; k++) {
            if (arr[i][k].getText() != "") {
                count++;
            }
        }
        return count == 9;


    }

    public void indicateNoWin(int i) { // indicating a tie
        tvWin.setVisibility(View.VISIBLE);
        tvWin.setText("No one Win!");


    }

    public void sendStats(int i) { // sends stats to file

        FileOutputStream fos = null;
        String countS = Integer.toString(counter);

        try {
            fos = openFileOutput("stats.txt", Context.MODE_APPEND);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(countS + "\n");
            if (isWinBigSquare(i).equals("X"))
                bw.write("X" + "\n");
            if (isWinBigSquare(i).equals("O"))
                bw.write("O" + "\n");
            if (allFilledTie(i)) {
                bw.write("T" + "\n");
            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void sendMapStats() { // sends map stats to file
        FileOutputStream fos = null;

        try {
            fos = openFileOutput("location1.txt", Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(latString + "\n");
            bw.write(lonString + "\n");
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        double lat = location.getLatitude();
        double lon = location.getLongitude();
        latString = lat + "";
        lonString = lon + "";
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}