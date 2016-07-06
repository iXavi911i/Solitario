/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitario;

/**
 *
 * @author Xavi
 */
public class Carta {
    private String palo;
    private String prueba;
    private int valor;
    public Carta(int valor1, String palo1){
        valor = valor1;
        palo = palo1;
    }
    
    public int Valor(){
        return valor;
    }
    
    public String Palo(){
        return palo;
    }
    
    public String getRango(){
        switch (valor){
            case 1:
                return "AS";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(valor);
        }
    }
    
    public String toString(){
        return(getRango() + " de " + palo);
    }
}
