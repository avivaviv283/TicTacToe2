package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity implements View.OnClickListener {

    Button[][]btnsg1,btnsg2,btnsg3,btnsg4,btnsg5,btnsg6,btnsg7,btnsg8,btnsg9;
    Button[] allBtns;
    Button btnResetGame;
    Button btn;
    TextView tvWIn;
    Intent goMenu;
    int counter =0;
    int btnCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tvWIn = (TextView) findViewById(R.id.tvWin);
        tvWIn.setVisibility(View.INVISIBLE);
        btnResetGame = (Button) findViewById(R.id.btnResetGame);
        btnResetGame.setOnClickListener(this);
        btnResetGame.setVisibility(View.INVISIBLE);
        btnsg1 = new Button[3][3];
        btnsg2 = new Button[3][3];
        btnsg3 = new Button[3][3];
        btnsg4 = new Button[3][3];
        btnsg5 = new Button[3][3];
        btnsg6 = new Button[3][3];
        btnsg7 = new Button[3][3];
        btnsg8 = new Button[3][3];
        btnsg9 = new Button[3][3];
        btnsg1[0][0] = (Button) findViewById(R.id.g11);
        btnsg1[0][1] = (Button) findViewById(R.id.g12);
        btnsg1[0][2] = (Button) findViewById(R.id.g13);
        btnsg1[1][0] = (Button) findViewById(R.id.g14);
        btnsg1[1][1] = (Button) findViewById(R.id.g15);
        btnsg1[1][2] = (Button) findViewById(R.id.g16);
        btnsg1[2][0] = (Button) findViewById(R.id.g17);
        btnsg1[2][1] = (Button) findViewById(R.id.g18);
        btnsg1[2][2] = (Button) findViewById(R.id.g19);


        btnsg2[0][0] = (Button) findViewById(R.id.g21);
        btnsg2[0][1] = (Button) findViewById(R.id.g22);
        btnsg2[0][2] = (Button) findViewById(R.id.g23);
        btnsg2[1][0] = (Button) findViewById(R.id.g24);
        btnsg2[1][1] = (Button) findViewById(R.id.g25);
        btnsg2[1][2] = (Button) findViewById(R.id.g26);
        btnsg2[2][0] = (Button) findViewById(R.id.g27);
        btnsg2[2][1] = (Button) findViewById(R.id.g28);
        btnsg2[2][2] = (Button) findViewById(R.id.g29);

        btnsg3[0][0] = (Button) findViewById(R.id.g31);
        btnsg3[0][1] = (Button) findViewById(R.id.g32);
        btnsg3[0][2] = (Button) findViewById(R.id.g33);
        btnsg3[1][0] = (Button) findViewById(R.id.g34);
        btnsg3[1][1] = (Button) findViewById(R.id.g35);
        btnsg3[1][2] = (Button) findViewById(R.id.g36);
        btnsg3[2][0] = (Button) findViewById(R.id.g37);
        btnsg3[2][1] = (Button) findViewById(R.id.g38);
        btnsg3[2][2] = (Button) findViewById(R.id.g39);

        btnsg4[0][0] = (Button) findViewById(R.id.g41);
        btnsg4[0][1] = (Button) findViewById(R.id.g42);
        btnsg4[0][2] = (Button) findViewById(R.id.g43);
        btnsg4[1][0] = (Button) findViewById(R.id.g44);
        btnsg4[1][1] = (Button) findViewById(R.id.g45);
        btnsg4[1][2] = (Button) findViewById(R.id.g46);
        btnsg4[2][0] = (Button) findViewById(R.id.g47);
        btnsg4[2][1] = (Button) findViewById(R.id.g48);
        btnsg4[2][2] = (Button) findViewById(R.id.g49);

        btnsg5[0][0] = (Button) findViewById(R.id.g51);
        btnsg5[0][1] = (Button) findViewById(R.id.g52);
        btnsg5[0][2] = (Button) findViewById(R.id.g53);
        btnsg5[1][0] = (Button) findViewById(R.id.g54);
        btnsg5[1][1] = (Button) findViewById(R.id.g55);
        btnsg5[1][2] = (Button) findViewById(R.id.g56);
        btnsg5[2][0] = (Button) findViewById(R.id.g57);
        btnsg5[2][1] = (Button) findViewById(R.id.g58);
        btnsg5[2][2] = (Button) findViewById(R.id.g59);

        btnsg6[0][0] = (Button) findViewById(R.id.g61);
        btnsg6[0][1] = (Button) findViewById(R.id.g62);
        btnsg6[0][2] = (Button) findViewById(R.id.g63);
        btnsg6[1][0] = (Button) findViewById(R.id.g64);
        btnsg6[1][1] = (Button) findViewById(R.id.g65);
        btnsg6[1][2] = (Button) findViewById(R.id.g66);
        btnsg6[2][0] = (Button) findViewById(R.id.g67);
        btnsg6[2][1] = (Button) findViewById(R.id.g68);
        btnsg6[2][2] = (Button) findViewById(R.id.g69);

        btnsg7[0][0] = (Button) findViewById(R.id.g71);
        btnsg7[0][1] = (Button) findViewById(R.id.g72);
        btnsg7[0][2] = (Button) findViewById(R.id.g73);
        btnsg7[1][0] = (Button) findViewById(R.id.g74);
        btnsg7[1][1] = (Button) findViewById(R.id.g75);
        btnsg7[1][2] = (Button) findViewById(R.id.g76);
        btnsg7[2][0] = (Button) findViewById(R.id.g77);
        btnsg7[2][1] = (Button) findViewById(R.id.g78);
        btnsg7[2][2] = (Button) findViewById(R.id.g79);

        btnsg8[0][0] = (Button) findViewById(R.id.g81);
        btnsg8[0][1] = (Button) findViewById(R.id.g82);
        btnsg8[0][2] = (Button) findViewById(R.id.g83);
        btnsg8[1][0] = (Button) findViewById(R.id.g84);
        btnsg8[1][1] = (Button) findViewById(R.id.g85);
        btnsg8[1][2] = (Button) findViewById(R.id.g86);
        btnsg8[2][0] = (Button) findViewById(R.id.g87);
        btnsg8[2][1] = (Button) findViewById(R.id.g88);
        btnsg8[2][2] = (Button) findViewById(R.id.g89);

        btnsg9[0][0] = (Button) findViewById(R.id.g91);
        btnsg9[0][1] = (Button) findViewById(R.id.g92);
        btnsg9[0][2] = (Button) findViewById(R.id.g93);
        btnsg9[1][0] = (Button) findViewById(R.id.g94);
        btnsg9[1][1] = (Button) findViewById(R.id.g95);
        btnsg9[1][2] = (Button) findViewById(R.id.g96);
        btnsg9[2][0] = (Button) findViewById(R.id.g97);
        btnsg9[2][1] = (Button) findViewById(R.id.g98);
        btnsg9[2][2] = (Button) findViewById(R.id.g99);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnsg1[i][j].setOnClickListener(this);
                allBtns[btnCount] = btnsg1[i][j];
                btnCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnsg2[i][j].setOnClickListener(this);
                allBtns[btnCount] = btnsg2[i][j];
                btnCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnsg3[i][j].setOnClickListener(this);
                allBtns[btnCount] = btnsg3[i][j];
                btnCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnsg4[i][j].setOnClickListener(this);
                allBtns[btnCount] = btnsg4[i][j];
                btnCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnsg5[i][j].setOnClickListener(this);
                allBtns[btnCount] = btnsg5[i][j];
                btnCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnsg6[i][j].setOnClickListener(this);
                allBtns[btnCount] = btnsg6[i][j];
                btnCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnsg7[i][j].setOnClickListener(this);
                allBtns[btnCount] = btnsg7[i][j];
                btnCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnsg8[i][j].setOnClickListener(this);
                allBtns[btnCount] = btnsg8[i][j];
                btnCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                btnsg9[i][j].setOnClickListener(this);
                allBtns[btnCount] = btnsg9[i][j];
                btnCount++;
            }
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
    }



    public int isWin()
    {
        if(counter > 4)
        {
            int j = 0;
            for (int i = 0; i < 3; i++) {
                if (btns[i][j].getText().toString().length() > 0 && btns[i][j].getText().toString().equals(btns[i][j + 1].getText().toString()) && btns[i][j].getText().toString().equals(btns[i][j + 2].getText().toString())) {
                    if (btns[i][j].getText().toString().equals("O"))
                        return 1;//0 win  - odd counting
                    return 2;//x win
                }
                else if (btns[j][i].getText().toString().length() > 0 && btns[j][i].getText().toString().equals(btns[j + 1][i].getText().toString()) && btns[j][i].getText().toString().equals(btns[j + 2][i].getText().toString())) {
                    if (btns[j][i].getText().toString().equals("O"))
                        return 1;//user win - even win
                    return 2;
                }

            }//end of for
            //checking diagonal
            if (btns[0][0].getText().toString().length() > 0 && btns[0][0].getText().toString().equals(btns[1][1].getText().toString()) && btns[0][0].getText().toString().equals(btns[2][2].getText().toString())) {
                if (btns[0][j].getText().toString().equals("O"))
                    return 1;//0 win  - odd counting
                return 2;//x win
            }
            if (btns[0][2].getText().toString().length() > 0 && btns[0][2].getText().toString().equals(btns[1][1].getText().toString()) && btns[0][2].getText().toString().equals(btns[2][0].getText().toString())) {
                if (btns[0][j].getText().toString().equals("O"))
                    return 1;//o win  - odd counting
                return 2;
            }


        }
        return -1;//no one win
    }
    public void reset()
    {
        counter =0;
        btnResetGame.setVisibility(View.INVISIBLE);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                btns[i][j].setText("");
        }
        tvWIn.setVisibility(View.INVISIBLE);
    }


    public void goMenu(View view) {
        goMenu= new Intent(this,MainActivity.class);
        startActivity(goMenu);
    }
}
