package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity implements View.OnClickListener {

    Button[]btnsg1,btnsg2,btnsg3,btnsg4,btnsg5,btnsg6,btnsg7,btnsg8,btnsg9;
    Button[] allBtns;

    Button btnResetGame;
    Button[][] arr = {btnsg1, btnsg2, btnsg3,btnsg4,btnsg5,btnsg6,btnsg7,btnsg8,btnsg9};;
    int goTo=0;
    Button btn;
    TextView tvWIn;
    Intent goMenu;
    int counter =0;
    int btnCount=0;
    private Object Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tvWIn = (TextView) findViewById(R.id.tvWin);
        tvWIn.setVisibility(View.INVISIBLE);
        btnResetGame = (Button) findViewById(R.id.btnResetGame);
        btnResetGame.setOnClickListener(this);
        btnResetGame.setVisibility(View.INVISIBLE);
        btnsg1 = new Button[9];
        btnsg2 = new Button[9];
        btnsg3 = new Button[9];
        btnsg4 = new Button[9];
        btnsg5 = new Button[9];
        btnsg6 = new Button[9];
        btnsg7 = new Button[9];
        btnsg8 = new Button[9];
        btnsg9 = new Button[9];
        btnsg1[0] = (Button) findViewById(R.id.g11);
        btnsg1[1] = (Button) findViewById(R.id.g12);
        btnsg1[2] = (Button) findViewById(R.id.g13);
        btnsg1[3] = (Button) findViewById(R.id.g14);
        btnsg1[4] = (Button) findViewById(R.id.g15);
        btnsg1[5] = (Button) findViewById(R.id.g16);
        btnsg1[6] = (Button) findViewById(R.id.g17);
        btnsg1[7] = (Button) findViewById(R.id.g18);
        btnsg1[8] = (Button) findViewById(R.id.g19);


        btnsg2[0] = (Button) findViewById(R.id.g11);
        btnsg2[1] = (Button) findViewById(R.id.g12);
        btnsg2[2] = (Button) findViewById(R.id.g13);
        btnsg2[3] = (Button) findViewById(R.id.g14);
        btnsg2[4] = (Button) findViewById(R.id.g15);
        btnsg2[5] = (Button) findViewById(R.id.g16);
        btnsg2[6] = (Button) findViewById(R.id.g17);
        btnsg2[7] = (Button) findViewById(R.id.g18);
        btnsg2[8] = (Button) findViewById(R.id.g19);

        btnsg3[0] = (Button) findViewById(R.id.g11);
        btnsg3[1] = (Button) findViewById(R.id.g12);
        btnsg3[2] = (Button) findViewById(R.id.g13);
        btnsg3[3] = (Button) findViewById(R.id.g14);
        btnsg3[4] = (Button) findViewById(R.id.g15);
        btnsg3[5] = (Button) findViewById(R.id.g16);
        btnsg3[6] = (Button) findViewById(R.id.g17);
        btnsg3[7] = (Button) findViewById(R.id.g18);
        btnsg3[8] = (Button) findViewById(R.id.g19);

        btnsg4[0] = (Button) findViewById(R.id.g11);
        btnsg4[1] = (Button) findViewById(R.id.g12);
        btnsg4[2] = (Button) findViewById(R.id.g13);
        btnsg4[3] = (Button) findViewById(R.id.g14);
        btnsg4[4] = (Button) findViewById(R.id.g15);
        btnsg4[5] = (Button) findViewById(R.id.g16);
        btnsg4[6] = (Button) findViewById(R.id.g17);
        btnsg4[7] = (Button) findViewById(R.id.g18);
        btnsg4[8] = (Button) findViewById(R.id.g19);

        btnsg5[0] = (Button) findViewById(R.id.g11);
        btnsg5[1] = (Button) findViewById(R.id.g12);
        btnsg5[2] = (Button) findViewById(R.id.g13);
        btnsg5[3] = (Button) findViewById(R.id.g14);
        btnsg5[4] = (Button) findViewById(R.id.g15);
        btnsg5[5] = (Button) findViewById(R.id.g16);
        btnsg5[6] = (Button) findViewById(R.id.g17);
        btnsg5[7] = (Button) findViewById(R.id.g18);
        btnsg5[8] = (Button) findViewById(R.id.g19);

        btnsg6[0] = (Button) findViewById(R.id.g11);
        btnsg6[1] = (Button) findViewById(R.id.g12);
        btnsg6[2] = (Button) findViewById(R.id.g13);
        btnsg6[3] = (Button) findViewById(R.id.g14);
        btnsg6[4] = (Button) findViewById(R.id.g15);
        btnsg6[5] = (Button) findViewById(R.id.g16);
        btnsg6[6] = (Button) findViewById(R.id.g17);
        btnsg6[7] = (Button) findViewById(R.id.g18);
        btnsg6[8] = (Button) findViewById(R.id.g19);

        btnsg7[0] = (Button) findViewById(R.id.g11);
        btnsg7[1] = (Button) findViewById(R.id.g12);
        btnsg7[2] = (Button) findViewById(R.id.g13);
        btnsg7[3] = (Button) findViewById(R.id.g14);
        btnsg7[4] = (Button) findViewById(R.id.g15);
        btnsg7[5] = (Button) findViewById(R.id.g16);
        btnsg7[6] = (Button) findViewById(R.id.g17);
        btnsg7[7] = (Button) findViewById(R.id.g18);
        btnsg7[8] = (Button) findViewById(R.id.g19);

        btnsg8[0] = (Button) findViewById(R.id.g11);
        btnsg8[1] = (Button) findViewById(R.id.g12);
        btnsg8[2] = (Button) findViewById(R.id.g13);
        btnsg8[3] = (Button) findViewById(R.id.g14);
        btnsg8[4] = (Button) findViewById(R.id.g15);
        btnsg8[5] = (Button) findViewById(R.id.g16);
        btnsg8[6] = (Button) findViewById(R.id.g17);
        btnsg8[7] = (Button) findViewById(R.id.g18);
        btnsg8[8] = (Button) findViewById(R.id.g19);

        btnsg9[0] = (Button) findViewById(R.id.g11);
        btnsg9[1] = (Button) findViewById(R.id.g12);
        btnsg9[2] = (Button) findViewById(R.id.g13);
        btnsg9[3] = (Button) findViewById(R.id.g14);
        btnsg9[4] = (Button) findViewById(R.id.g15);
        btnsg9[5] = (Button) findViewById(R.id.g16);
        btnsg9[6] = (Button) findViewById(R.id.g17);
        btnsg9[7] = (Button) findViewById(R.id.g18);
        btnsg9[8] = (Button) findViewById(R.id.g19);

        setArr(btnsg1);
        setArr(btnsg2);
        setArr(btnsg3);
        setArr(btnsg4);
        setArr(btnsg5);
        setArr(btnsg6);
        setArr(btnsg7);
        setArr(btnsg8);
        setArr(btnsg9);


    }

    public void setArr(Button[] btnsg)
    {

            for (int j = 0; j < 9; j++)
            {
                btnsg[j].setOnClickListener(this);
                allBtns[btnCount] = btnsg[j];
                btnCount++;
            }
        }





    public boolean equals1(String str1,String str2)
    {
        if(str1.length()!=str2.length())
            return false;

        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i)!= str2.charAt(i))
                return false;

        }
        return true;
    }

    public void onClick(View v)
    {
        int current=0;
        int go=0;
        if(btnResetGame == v)
        {
            this.reset();
        }


        else
        {

            if (counter % 2 == 0) {
                btn.setText("O");
            } else {
                btn.setText("X");
            }
            counter++;


            if (isWin() > 0)
            {
                if (isWin() == 1) {
                    tvWIn.setText("O Win");
                } else if (isWin() == 2) {
                    tvWIn.setText("X Win");
                }
                btnResetGame.setVisibility(View.VISIBLE);
                tvWIn.setVisibility(View.VISIBLE);
            }
            else if (counter > 8)
            {
                tvWIn.setVisibility(View.VISIBLE);
                tvWIn.setText("No One Win");
                btnResetGame.setVisibility(View.VISIBLE);
            }
        }

        Button[] temp = new Button[9];
        for (int i = 0; i < allBtns.length; i++) {
            if (allBtns[i] == v) {
                goTo = (i + 1) % 9;
    }

    public void disable(Button[] arr){







    }


    public int getGoTo(View v) {

            }


        }

    }












    public void goMenu(View view) {
        goMenu= new Intent(this,MainActivity.class);
        startActivity(goMenu);
    }
}
