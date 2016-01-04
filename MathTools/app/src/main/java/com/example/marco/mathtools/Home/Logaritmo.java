/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.marco.mathtools.Home;

/**
 *
 * @author Marco
 */
public class Logaritmo {
    public double calcolaLogaritmo(double a, double b){
        return arrotondamento(Math.log(b)/Math.log(a));
    }
    double calcolaNumero(double a, double x){
        return Math.pow(x, a);
    }
    public static double arrotondamento(double x){
        x = Math.floor(x*100);
        x = x/100;
        return x;
    }
}
