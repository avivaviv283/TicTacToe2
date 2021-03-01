package com.example.myapplication;

public class StatsRead {
    private int numPressed, Xwin, Owin, Tie;

    public StatsRead(int numPressed, int xwin, int owin, int Tie) {
        this.numPressed = numPressed;
        this.Xwin = xwin;
        this.Owin = owin;
        this.Tie = Tie;
    }

    public StatsRead() {
        this.numPressed = 0;
        this.Xwin = 0;
        this.Owin = 0;
        this.Tie = 0;
    }

    public String getNumPressed() {
        return String.valueOf(numPressed);
    }

    public String getTie() {
        return String.valueOf(Tie);
    }

    public void setTie(int tie) {
        Tie = tie;
    }

    public void setNumPressed(int numPressed) {
        this.numPressed = numPressed;
    }

    public String getXwin() {
        return String.valueOf(Xwin);
    }

    public void setXwin(int xwin) {
        Xwin = xwin;
    }

    public String getOwin() {
        return String.valueOf(Owin);
    }

    public void setOwin(int owin) {
        Owin = owin;
    }

    @Override
    public String toString() {
        return "StatsRead{" +
                "numPressed=" + numPressed +
                ", Xwin=" + Xwin +
                ", Owin=" + Owin +
                '}';
    }
}

