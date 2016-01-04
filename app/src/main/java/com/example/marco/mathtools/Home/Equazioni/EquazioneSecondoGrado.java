/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.marco.mathtools.Home.Equazioni;

/**
 *
 * @author Marco
 */
public class EquazioneSecondoGrado extends EquazionePrimoGrado {
    int termineXQuadro;

    public EquazioneSecondoGrado(int a, int b, int c) {
        super(b,c);
        termineXQuadro = a;
    }
    public void setTermineX(int x){
        termineX = x;
    }
    public void setTermineNoto(int c){
        termineNoto = c;
    }
    public void setTermineXQuadro(int x){
        termineXQuadro = x;
    }
    public int delta(){
        return (termineX * termineX - 4 * termineXQuadro * termineNoto);
    }
    public int[] soluzioni(){
        double temp = Math.round(Math.sqrt(delta()));
        int x1 = (int) (-termineX + temp) / (2*termineXQuadro);
        int x2 = (int) (-termineX - temp) / (2*termineXQuadro);
        return new int[] {x1,x2};
    }
}
