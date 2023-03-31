package com.example.temanr1;

import java.util.Comparator;

public class Monomial {

    private float coef;
    private int exp;

    public float getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Monomial{" +
                "coef=" + coef +
                ", exp=" + exp +
                '}';
    }

    Monomial add(Monomial m) {
        Monomial rez = new Monomial();
        rez.coef = coef + m.coef;
        rez.exp=exp;
        return rez;
    }

    Monomial sub(Monomial m) {
        Monomial rez = new Monomial();
        rez.coef = coef - m.coef;
        rez.exp=m.exp;
        return rez;
    }

}

