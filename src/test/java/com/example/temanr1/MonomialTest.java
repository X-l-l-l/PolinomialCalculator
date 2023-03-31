package com.example.temanr1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {

    @Test
    void add() {
        Monomial rez = new Monomial();
        Monomial a = new Monomial();
        Monomial b = new Monomial();

        rez.setCoef(2);
        rez.setExp(2);

        a.setCoef(1);
        a.setExp(2);

        b.setCoef(1);
        b.setExp(2);

        assertEquals(rez,a.add(b));

    }

    @Test
    void sub() {
        Monomial rez = new Monomial();
        Monomial a = new Monomial();
        Monomial b = new Monomial();

        rez.setCoef(1);
        rez.setExp(2);

        a.setCoef(2);
        a.setExp(2);

        b.setCoef(1);
        b.setExp(2);

        assertEquals(rez,a.sub(b));
    }
}