package com.example.temanr1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    private ArrayList<Monomial> pol = new ArrayList<Monomial>();

    void extract(String expression) {
        expression = expression.replace("-", "+-");
        String[] terms = expression.split("\\+");
        for (String term : terms) {
            if (term.charAt(0) == 'x')
                term = term.replace("x", "1x");
            if (term.contains("^")) {
                term = term.replace("x^", "x");
            } else {
                term = term.replace("x^", "x");
                term = term.replace("x", "x1");
            }
            String[] numbers = term.split("x");
            Monomial m = new Monomial();
            if (term.contains("x")) {
                m.setCoef(Float.parseFloat(numbers[0]));
                m.setExp(Integer.parseInt((numbers[1])));
            } else
                m.setCoef(Float.parseFloat(numbers[0]));

            pol.add(m);

        }
    }

    public void sort() {
        pol.sort((m1, m2) -> {
            if (m1.getExp() == m2.getExp())
                return 0;
            return m1.getExp() > m2.getExp() ? -1 : 1;
        });
    }

    Polynomial add(Polynomial p) {
        Polynomial rez = new Polynomial();

        pol.addAll(p.pol);
        sort();

        int i = 0;
        while (i < pol.size()) {
            if (i != pol.size() - 1 && pol.get(i).getExp() == pol.get(i + 1).getExp()) {
                rez.pol.add(pol.get(i).add(pol.get(i + 1)));
                i += 2;
            } else {
                rez.pol.add(pol.get(i));
                i++;
            }
        }
        return rez;
    }

    Polynomial sub(Polynomial p) {
        Polynomial rez = new Polynomial();
        Monomial zero = new Monomial();

        pol.addAll(p.pol);
        sort();

        int i = 0;
        while (i < pol.size()) {
            if (i != pol.size() - 1 && pol.get(i).getExp() == pol.get(i + 1).getExp()) {
                rez.pol.add(pol.get(i).sub(pol.get(i + 1)));
                i += 2;
            } else {
                if(p.pol.contains(pol.get(i)))
                    rez.pol.add(zero.sub(pol.get(i)));
                else
                    rez.pol.add(pol.get(i));
                i++;
            }
        }
        return rez;
    }

    public Polynomial mul(Polynomial p2) {

        Polynomial rez = new Polynomial();

        for (int i = 0; i < pol.size(); i++) {
            for (int j = 0; j < p2.pol.size(); j++) {
                Monomial m = new Monomial();
                m.setExp(pol.get(i).getExp() + p2.pol.get(j).getExp());
                m.setCoef(pol.get(i).getCoef() * p2.pol.get(j).getCoef());
                rez.pol.add(m);
            }
        }

        Polynomial rez2 = new Polynomial();

        int i = 0;
        while (i < rez.pol.size()) {
            if (i != rez.pol.size() - 1 && rez.pol.get(i).getExp() == rez.pol.get(i + 1).getExp()) {
                rez2.pol.add(rez.pol.get(i).add(rez.pol.get(i + 1)));
                i += 2;
            } else {
                rez2.pol.add(rez.pol.get(i));
                i++;
            }
        }

        return rez2;
    }

    public Polynomial div(Polynomial p) {
        Polynomial rez = new Polynomial();
        Polynomial polaux = new Polynomial();

        while (this.pol.get(0).getExp() >= p.pol.get(0).getExp()) {

            Monomial m = new Monomial();
            m.setExp(pol.get(0).getExp() - p.pol.get(0).getExp());
            m.setCoef(pol.get(0).getCoef() / p.pol.get(0).getCoef());

            Polynomial poly = new Polynomial();
            poly.pol.add(m);

            rez.pol.add(m);

            polaux = poly.mul(p);

            polaux = this.sub(polaux);
            this.pol = polaux.pol;

            for(int i=0;i<pol.size();i++)
            {
                if(pol.get(i).getCoef() ==0)
                    pol.remove(i);
            }

        }
        System.out.println(this);
        return rez;
    }

    public Polynomial deriv() {
        for (Monomial m : pol) {
            m.setCoef(m.getCoef() * m.getExp());
            m.setExp(m.getExp() - 1);
        }

        return this;
    }

    public Polynomial integ() {
        for (Monomial m : pol) {
            m.setExp(m.getExp() + 1);
            m.setCoef(m.getCoef() / m.getExp());
        }

        return this;
    }

    @Override
    public String toString() {
        String s = "";
        for (Monomial m : pol) {
            if (s.equals("")) {
                if (m.getCoef() != 0) {
                    if (m.getExp() == 0)
                        s += m.getCoef();
                    else if (m.getExp() == 1)
                        s += m.getCoef() + "x";
                    else
                        s += m.getCoef() + "x^" + m.getExp();
                }
            } else {
                if (m.getCoef() != 0) {
                    if (m.getCoef() > 0)
                        s += "+";
                    if (m.getExp() == 0)
                        s += m.getCoef();
                    else if (m.getExp() == 1)
                        s += m.getCoef() + "x";
                    else
                        s += m.getCoef() + "x^" + m.getExp();
                }

            }
        }
        if (s.equals(""))
            s += "0";

        s = s.replace("1.0x", "x");
        s = s.replace(".0", "");

        return s;
    }
}
