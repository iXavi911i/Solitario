/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitario;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Arely y Javier
 */
public class Mazo {
    
    private ArrayList<Carta> mazo;
    String palos[] = {"CORAZONES", "DIAMANTES", "TREBOLES", "ESPADAS"};
    //String valores[] = {"AS", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final ArrayList<Boolean> estadoP1;
    private final ArrayList<Boolean> estadoP2;
    private final ArrayList<Boolean> estadoP3;
    private final ArrayList<Boolean> estadoP4;
    private final ArrayList<Boolean> estadoP5;
    private final ArrayList<Boolean> estadoP6;
    private final ArrayList<Boolean> estadoP7;
    private ArrayList<Carta> pila1;
    private ArrayList<Carta> pila2;
    private ArrayList<Carta> pila3;
    private ArrayList<Carta> pila4;
    private ArrayList<Carta> pila5;
    private ArrayList<Carta> pila6;
    private ArrayList<Carta> pila7;
    private ArrayList<Carta> pilaP1;
    private ArrayList<Carta> pilaP2;
    private ArrayList<Carta> pilaP3;
    private ArrayList<Carta> pilaP4;
    private int apuntador;
    private String resp;
    private int apuntador2;
    
    public Mazo() {
        
        mazo = new ArrayList<>();
        estadoP1 = new ArrayList<>();
        estadoP2 = new ArrayList<>();
        estadoP3 = new ArrayList<>();
        estadoP4 = new ArrayList<>();
        estadoP5 = new ArrayList<>();
        estadoP6 = new ArrayList<>();
        estadoP7 = new ArrayList<>();
        estadoP1.add(true);
        estadoP2.add(false);
        estadoP2.add(true);
        estadoP3.add(false);
        estadoP3.add(false);
        estadoP3.add(true);
        estadoP4.add(false);
        estadoP4.add(false);
        estadoP4.add(false);
        estadoP4.add(true);
        estadoP5.add(false);
        estadoP5.add(false);
        estadoP5.add(false);
        estadoP5.add(false);
        estadoP5.add(true);
        estadoP6.add(false);
        estadoP6.add(false);
        estadoP6.add(false);
        estadoP6.add(false);
        estadoP6.add(false);
        estadoP6.add(true);
        estadoP7.add(false);
        estadoP7.add(false);
        estadoP7.add(false);
        estadoP7.add(false);
        estadoP7.add(false);
        estadoP7.add(false);
        estadoP7.add(true);
        apuntador = 0;
        apuntador2 = 0;
        resp = "[]";
        
        for(String palo: palos){
            for(int i=1;i<14;i++){
                mazo.add(new Carta(i,palo));
            }
        }
    }
    
    public void Revolver(){
        Collections.shuffle(mazo);
    }
    
    //metodo de uso interno(no se usa)
    public void imprimirPila2(ArrayList<Carta> c){
        for(int i=0;i<c.size();i++){
                System.out.println(i + " : " + c.get(i));
        }
    }
    
    //metodo de eso interno (no se usa)
    private void imprimirPila2(ArrayList<Carta> c, ArrayList<Boolean> estados){
        for(int i = 0;i<c.size();i++){
            if(true==estados.get(i)){
                System.out.printf("%-20s \t",c.get(i));
            }
        }
    }
    
    // devuelve un arreglo con todo las cartas visibless
    private ArrayList getCartasVisibles(ArrayList<Carta> c, ArrayList<Boolean> est){
        ArrayList getCartasVisibles = new ArrayList();
        for(int i=0;i<c.size();i++){
            if(est.get(i).equals(true)){
                getCartasVisibles.add(c.get(i));
            }
        }
        return getCartasVisibles;
    }
    
    private String imprimePila1(int indice){
        String resp = "              ";
        if(pila1.size()-1>=indice){
            if(estadoP1.get(indice).equals(true)){
                resp = pila1.get(indice).toString();
            }
            else {resp = "------------";}
        }
        return resp;
    }
    
    private String imprimePila2(int indice){
        String resp = "              ";
        if(pila2.size()-1>=indice){
            if(estadoP2.get(indice).equals(true)){
                resp = pila2.get(indice).toString();
            }
            else {resp = "------------";}
        }
        
        return resp;
    }
    
    private String imprimePila3(int indice){
        String resp = "              ";
        if(pila3.size()-1>=indice){
            if(estadoP3.get(indice).equals(true)){
                resp = pila3.get(indice).toString();
            }
            else {resp = "------------";}
        }
        return resp;
    }
    
    private String imprimePila4(int indice){
        String resp = "              ";
        if(pila4.size()-1>=indice){
            if(estadoP4.get(indice).equals(true)){
                resp = pila4.get(indice).toString();
            }
            else {resp = "------------";}
        }
        return resp;
    }
     
    private String imprimePila5(int indice){
        String resp = "              ";
        if(pila5.size()-1>=indice){
            if(estadoP5.get(indice).equals(true)){
                resp = pila5.get(indice).toString();
            }
            else {resp = "------------";}
        }
        return resp;
    }
      
    private String imprimePila6(int indice){
        String resp = "              ";
        if(pila6.size()-1>=indice){
            if(estadoP6.get(indice).equals(true)){
                resp = pila6.get(indice).toString();
            }
            else {resp = "------------";}
        }
        return resp;
    }
       
    private String imprimePila7(int indice){
        String resp = "              ";
        if(pila7.size()-1>=indice){
            if(estadoP7.get(indice).equals(true)){
                resp = pila7.get(indice).toString();
            }
            else {resp = "------------";}
        }
        return resp;
    }
    
    private void ImprimePilas(){
        int tope;
        int tP1 = pila1.size();
        int tP2 = pila2.size();
        int tP3 = pila3.size();
        int tP4 = pila4.size();
        int tP5 = pila5.size();
        int tP6 = pila6.size();
        int tP7 = pila7.size();
        
        tope = Math.max(tP1,Math.max(tP2, Math.max(tP3, Math.max(tP4, Math.max(tP5, Math.max(tP6, tP7))))));
        
        for(int i=0;i<tope;i++){
            System.out.println(imprimePila1(i) + " | " + imprimePila2(i) + " | " + imprimePila3(i)+ " | " + imprimePila4(i)+ " | " + imprimePila5(i)+ " | " + imprimePila6(i)+ " | " + imprimePila7(i));
        }
    }
    
    private ArrayList<Carta> DarCarta(int nc){
        ArrayList<Carta> cartasTemp;
        cartasTemp = new ArrayList<>();
        for(int i=0;i<nc;i++){
            cartasTemp.add(mazo.remove(0));
        }
        return cartasTemp;
    }
    
    public void CrearPilasDeMesa(){
        pila1 = DarCarta(1);
        pila2 = DarCarta(2);
        pila3 = DarCarta(3);
        pila4 = DarCarta(4);
        pila5 = DarCarta(5);
        pila6 = DarCarta(6);
        pila7 = DarCarta(7);
    }
    
    public void actualizaPantalla(){
        System.out.println("Baraja descarte: " + getCartaMazo() + "\n");
        System.out.println("Pilas de palos: \n");
        System.out.println(getCartaPilaPalos(pilaP1) + " | " + getCartaPilaPalos(pilaP2) + " | " + getCartaPilaPalos(pilaP3) + " | " + getCartaPilaPalos(pilaP4) + "\n");
        ImprimePilas();
    }
    
    private Boolean juegoTerminado(){
        if(mazo.isEmpty() && estadoP1.contains(false))
            return true;
        return false;
    }
    
    private String getCartaPilaPalos(ArrayList<Carta> lista){
        if(lista.isEmpty())
            return "[]";
        else
            return lista.get(lista.size()-1).toString();
    }
    
    private String getCartaMazo(){
        return resp;
    }
    
    public void PedirCarta(){
        if(apuntador>mazo.size()-1){
            apuntador = 0;
            resp = "[]";
        }
        else{
            resp = mazo.get(apuntador).toString();
            apuntador++;}
    }
    
    public void CrearPilasPalos(){
        pilaP1 = new ArrayList<>();
        pilaP2 = new ArrayList<>();
        pilaP3 = new ArrayList<>();
        pilaP4 = new ArrayList<>();
        
        
//        pilaP1.add(new Carta(1,"ESPADAS"));
//        pilaP1.add(new Carta(2,"ESPADAS"));
//        pilaP1.add(new Carta(3,"ESPADAS"));
//        
//        MoverCartas(new Carta(4,"ESPADAS"),pilaP1.get(pilaP1.size()-1),8);
    }
    
    public void CrearPilaDescarte(){
//        System.out.println(pila1);
//        System.out.println(estadoP1);
//        MoverCartas(new Carta(1,"CORAZONES"),1,10);
//        System.out.println(pila1);
//        System.out.println(estadoP1);
    }
    
    // metodo para distribuir operaciones de mover cartas
    public void MoverCartas(int pI, int pD){
            switch(pI){
            case 1:
                switch(pD){
                    case 2:
                        if(!pila2.isEmpty())
                            MoverCartas(pila1.get(pila1.size()-1),pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(pila1.get(pila1.size()-1),pI,pD);
                        break;
                    case 3:
                        if(!pila3.isEmpty())
                            MoverCartas(pila1.get(pila1.size()-1),pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(pila1.get(pila1.size()-1),pI,pD);
                        break;
                    case 4:
                        if(!pila4.isEmpty())
                            MoverCartas(pila1.get(pila1.size()-1),pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(pila1.get(pila1.size()-1),pI,pD);
                        break;
                    case 5:    
                        if(!pila5.isEmpty())
                            MoverCartas(pila1.get(pila1.size()-1),pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(pila1.get(pila1.size()-1),pI,pD);
                        break;
                    case 6:
                        if(!pila6.isEmpty())
                            MoverCartas(pila1.get(pila1.size()-1),pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(pila1.get(pila1.size()-1),pI,pD);
                        break;
                    case 7:
                        if(!pila7.isEmpty())
                            MoverCartas(pila1.get(pila1.size()-1),pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(pila1.get(pila1.size()-1),pI,pD);
                        break;
                    case 8:
                        if(pilaP1.isEmpty())
                            MoverCartas(pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(pila1.get(pila1.size()-1),pilaP1.get(pilaP1.size()-1),pI,pD);
                        break;
                    case 9:
                        if(pilaP2.isEmpty())
                            MoverCartas(pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(pila1.get(pila1.size()-1),pilaP2.get(pilaP2.size()-1),pI,pD);
                        break;
                    case 10:
                        if(pilaP3.isEmpty())
                            MoverCartas(pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(pila1.get(pila1.size()-1),pilaP3.get(pilaP3.size()-1),pI,pD);
                        break;
                    case 11:
                        if(pilaP4.isEmpty())
                            MoverCartas(pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(pila1.get(pila1.size()-1),pilaP4.get(pilaP4.size()-1),pI,pD);
                        break;
                }
                break;
            case 2:
                switch(pD){
                    case 1:
                        if(!pila1.isEmpty())
                            MoverCartas(pila2.get(pila2.size()-1),pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(pila2.get(pila2.size()-1),pI,pD);
                        break;
                    case 3:
                        if(!pila3.isEmpty())
                            MoverCartas(pila2.get(pila2.size()-1),pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(pila2.get(pila2.size()-1),pI,pD);
                        break;
                    case 4:
                        if(!pila4.isEmpty())
                            MoverCartas(pila2.get(pila2.size()-1),pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(pila2.get(pila2.size()-1),pI,pD);
                        break;
                    case 5:
                        if(!pila5.isEmpty())
                            MoverCartas(pila2.get(pila2.size()-1),pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(pila2.get(pila2.size()-1),pI,pD);
                        break;
                    case 6:
                        if(!pila6.isEmpty())
                            MoverCartas(pila2.get(pila2.size()-1),pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(pila2.get(pila2.size()-1),pI,pD);
                        break;
                    case 7:
                        if(!pila7.isEmpty())
                            MoverCartas(pila2.get(pila2.size()-1),pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(pila2.get(pila2.size()-1),pI,pD);
                        break;
                    case 8:
                        if(pilaP1.isEmpty())
                            MoverCartas(pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(pila2.get(pila2.size()-1),pilaP1.get(pilaP1.size()-1),pI,pD);
                        break;
                    case 9:
                        if(pilaP2.isEmpty())
                            MoverCartas(pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(pila2.get(pila2.size()-1),pilaP2.get(pilaP2.size()-1),pI,pD);
                        break;
                    case 10:
                        if(pilaP3.isEmpty())
                            MoverCartas(pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(pila2.get(pila2.size()-1),pilaP3.get(pilaP3.size()-1),pI,pD);
                        break;
                    case 11:
                        if(pilaP4.isEmpty())
                            MoverCartas(pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(pila2.get(pila2.size()-1),pilaP4.get(pilaP4.size()-1),pI,pD);
                        break;
                }
                break;
            case 3:
                switch(pD){
                    case 1:
                        if(!pila1.isEmpty())
                            MoverCartas(pila3.get(pila3.size()-1),pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(pila3.get(pila3.size()-1),pI,pD);
                        break;
                    case 2:
                        if(!pila2.isEmpty())
                            MoverCartas(pila3.get(pila3.size()-1),pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(pila3.get(pila3.size()-1),pI,pD);
                        break;
                    case 4:
                        if(!pila4.isEmpty())
                            MoverCartas(pila3.get(pila3.size()-1),pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(pila3.get(pila3.size()-1),pI,pD);
                        break;
                    case 5:
                        if(!pila5.isEmpty())
                            MoverCartas(pila3.get(pila3.size()-1),pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(pila3.get(pila3.size()-1),pI,pD);
                        break;
                    case 6:
                        if(!pila6.isEmpty())
                            MoverCartas(pila3.get(pila3.size()-1),pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(pila3.get(pila3.size()-1),pI,pD);
                        break;
                    case 7:
                        if(!pila7.isEmpty())
                            MoverCartas(pila3.get(pila3.size()-1),pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(pila3.get(pila3.size()-1),pI,pD);
                        break;
                    case 8:
                        if(pilaP1.isEmpty())
                            MoverCartas(pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(pila3.get(pila3.size()-1),pilaP1.get(pilaP1.size()-1),pI,pD);
                        break;
                    case 9:
                        if(pilaP2.isEmpty())
                            MoverCartas(pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(pila3.get(pila3.size()-1),pilaP2.get(pilaP2.size()-1),pI,pD);
                        break;
                    case 10:
                        if(pilaP3.isEmpty())
                            MoverCartas(pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(pila3.get(pila3.size()-1),pilaP3.get(pilaP3.size()-1),pI,pD);
                        break;
                    case 11:
                        if(pilaP4.isEmpty())
                            MoverCartas(pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(pila3.get(pila3.size()-1),pilaP4.get(pilaP4.size()-1),pI,pD);
                        break;
                }
                break;
            case 4:
                switch(pD){
                    case 1:
                        if(!pila1.isEmpty())
                            MoverCartas(pila4.get(pila4.size()-1),pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(pila4.get(pila4.size()-1),pI,pD);
                        break;
                    case 2:
                        if(!pila2.isEmpty())
                            MoverCartas(pila4.get(pila4.size()-1),pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(pila4.get(pila4.size()-1),pI,pD);
                        break;
                    case 3:
                        if(!pila3.isEmpty())
                            MoverCartas(pila4.get(pila4.size()-1),pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(pila4.get(pila4.size()-1),pI,pD);
                        break;
                    case 5:
                        if(!pila5.isEmpty())
                            MoverCartas(pila4.get(pila4.size()-1),pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(pila4.get(pila4.size()-1),pI,pD);
                        break;
                    case 6:
                        if(!pila6.isEmpty())
                            MoverCartas(pila4.get(pila4.size()-1),pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(pila4.get(pila4.size()-1),pI,pD);
                        break;
                    case 7:
                        if(!pila7.isEmpty())
                            MoverCartas(pila4.get(pila4.size()-1),pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(pila4.get(pila4.size()-1),pI,pD);
                        break;
                    case 8:
                        if(pilaP1.isEmpty())
                            MoverCartas(pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(pila4.get(pila4.size()-1),pilaP1.get(pilaP1.size()-1),pI,pD);
                        break;
                    case 9:
                        if(pilaP2.isEmpty())
                            MoverCartas(pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(pila4.get(pila4.size()-1),pilaP2.get(pilaP2.size()-1),pI,pD);
                        break;
                    case 10:
                        if(pilaP3.isEmpty())
                            MoverCartas(pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(pila4.get(pila4.size()-1),pilaP3.get(pilaP3.size()-1),pI,pD);
                        break;
                    case 11:
                        if(pilaP4.isEmpty())
                            MoverCartas(pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(pila4.get(pila4.size()-1),pilaP4.get(pilaP4.size()-1),pI,pD);
                        break;
                }
                break;
            case 5:
                switch(pD){
                    case 1:
                        if(!pila1.isEmpty())
                            MoverCartas(pila5.get(pila5.size()-1),pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(pila5.get(pila5.size()-1),pI,pD);
                        break;
                    case 2:
                        if(!pila2.isEmpty())
                            MoverCartas(pila5.get(pila5.size()-1),pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(pila5.get(pila5.size()-1),pI,pD);
                        break;
                    case 3:
                        if(!pila3.isEmpty())
                            MoverCartas(pila5.get(pila5.size()-1),pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(pila5.get(pila5.size()-1),pI,pD);
                        break;
                    case 4:   
                        if(!pila4.isEmpty())
                            MoverCartas(pila5.get(pila5.size()-1),pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(pila5.get(pila5.size()-1),pI,pD);
                        break;
                    case 6:
                        if(!pila6.isEmpty())
                            MoverCartas(pila5.get(pila5.size()-1),pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(pila5.get(pila5.size()-1),pI,pD);
                        break;
                    case 7:
                        if(!pila7.isEmpty())
                            MoverCartas(pila5.get(pila5.size()-1),pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(pila5.get(pila5.size()-1),pI,pD);
                        break;
                    case 8:
                        if(pilaP1.isEmpty())
                            MoverCartas(pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(pila5.get(pila5.size()-1),pilaP1.get(pilaP1.size()-1),pI,pD);
                        break;
                    case 9:
                        if(pilaP2.isEmpty())
                            MoverCartas(pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(pila5.get(pila5.size()-1),pilaP2.get(pilaP2.size()-1),pI,pD);
                        break;
                    case 10:
                        if(pilaP3.isEmpty())
                            MoverCartas(pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(pila5.get(pila5.size()-1),pilaP3.get(pilaP3.size()-1),pI,pD);
                        break;
                    case 11:
                        if(pilaP4.isEmpty())
                            MoverCartas(pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(pila5.get(pila5.size()-1),pilaP4.get(pilaP4.size()-1),pI,pD);
                        break;
                }
                break;
            case 6:
                switch(pD){
                    case 1:
                        if(!pila1.isEmpty())
                            MoverCartas(pila6.get(pila6.size()-1),pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(pila6.get(pila6.size()-1),pI,pD);
                        break;
                    case 2:
                        if(!pila2.isEmpty())
                            MoverCartas(pila6.get(pila6.size()-1),pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(pila6.get(pila6.size()-1),pI,pD);
                        break;
                    case 3:
                        if(!pila3.isEmpty())
                             MoverCartas(pila6.get(pila6.size()-1),pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(pila6.get(pila6.size()-1),pI,pD);
                        break;
                    case 4:    
                        if(!pila4.isEmpty())
                            MoverCartas(pila6.get(pila6.size()-1),pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(pila6.get(pila6.size()-1),pI,pD);
                        break;
                    case 5:
                        if(!pila5.isEmpty())
                            MoverCartas(pila6.get(pila6.size()-1),pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(pila6.get(pila6.size()-1),pI,pD);
                        break;
                    case 7:
                        if(!pila7.isEmpty())
                            MoverCartas(pila6.get(pila6.size()-1),pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(pila6.get(pila6.size()-1),pI,pD);
                        break;
                    case 8:
                        if(pilaP1.isEmpty())
                            MoverCartas(pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(pila6.get(pila6.size()-1),pilaP1.get(pilaP1.size()-1),pI,pD);
                        break;
                    case 9:
                        if(pilaP2.isEmpty())
                            MoverCartas(pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(pila6.get(pila6.size()-1),pilaP2.get(pilaP2.size()-1),pI,pD);
                        break;
                    case 10:
                        if(pilaP3.isEmpty())
                            MoverCartas(pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(pila6.get(pila6.size()-1),pilaP3.get(pilaP3.size()-1),pI,pD);
                        break;
                    case 11:
                        if(pilaP4.isEmpty())
                            MoverCartas(pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(pila6.get(pila6.size()-1),pilaP4.get(pilaP4.size()-1),pI,pD);
                        break;
                }
                break;
            case 7:
                switch(pD){
                    case 1:
                        if(!pila1.isEmpty())
                            MoverCartas(pila7.get(pila7.size()-1),pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(pila7.get(pila7.size()-1),pI,pD);
                        break;
                    case 2:
                        if(!pila2.isEmpty())
                            MoverCartas(pila7.get(pila7.size()-1),pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(pila7.get(pila7.size()-1),pI,pD);
                        break;
                    case 3:
                        if(!pila3.isEmpty())
                            MoverCartas(pila7.get(pila7.size()-1),pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(pila7.get(pila7.size()-1),pI,pD);
                        break;
                    case 4:  
                        if(!pila4.isEmpty())
                            MoverCartas(pila7.get(pila7.size()-1),pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(pila7.get(pila7.size()-1),pI,pD);
                        break;
                    case 5:
                        if(!pila5.isEmpty())
                            MoverCartas(pila7.get(pila7.size()-1),pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(pila7.get(pila7.size()-1),pI,pD);
                        break;
                    case 6:
                        if(!pila6.isEmpty())
                            MoverCartas(pila7.get(pila7.size()-1),pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(pila7.get(pila7.size()-1),pI,pD);
                        break;
                    case 8:
                        if(pilaP1.isEmpty())
                            MoverCartas(pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(pila7.get(pila7.size()-1),pilaP1.get(pilaP1.size()-1),pI,pD);
                        break;
                    case 9:
                        if(pilaP2.isEmpty())
                            MoverCartas(pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(pila7.get(pila7.size()-1),pilaP2.get(pilaP2.size()-1),pI,pD);
                        break;
                    case 10:
                        if(pilaP3.isEmpty())
                            MoverCartas(pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(pila7.get(pila7.size()-1),pilaP3.get(pilaP3.size()-1),pI,pD);
                        break;
                    case 11:
                        if(pilaP4.isEmpty())
                            MoverCartas(pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(pila7.get(pila7.size()-1),pilaP4.get(pilaP4.size()-1),pI,pD);
                        break;
                }
                break;
                
                case 8:
                    switch(pD){
                        case 1:
                            if(!pila1.isEmpty())
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pila1.get(pila1.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pI,pD);
                            break;
                        case 2:
                            if(!pila2.isEmpty())
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pila2.get(pila2.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pI,pD);
                            break;
                        case 3:
                            if(!pila3.isEmpty())
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pila3.get(pila3.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pI,pD);
                            break;
                        case 4:  
                            if(!pila4.isEmpty())
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pila4.get(pila4.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pI,pD);
                            break;
                        case 5:
                            if(!pila5.isEmpty())
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pila5.get(pila5.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pI,pD);
                            break;
                        case 6:
                            if(!pila6.isEmpty())
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pila6.get(pila6.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pI,pD);
                            break;
                        case 7:
                            if(!pila7.isEmpty())
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pila7.get(pila7.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP1.get(pilaP1.size()-1),pI,pD);
                            break;
                    }
                break;
                
                case 9:
                    switch(pD){
                        case 1:
                            if(!pila1.isEmpty())
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pila1.get(pila1.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pI,pD);
                            break;
                        case 2:
                            if(!pila2.isEmpty())
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pila2.get(pila2.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pI,pD);
                            break;
                        case 3:
                            if(!pila3.isEmpty())
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pila3.get(pila3.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pI,pD);
                            break;
                        case 4:  
                            if(!pila4.isEmpty())
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pila4.get(pila4.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pI,pD);
                            break;
                        case 5:
                            if(!pila5.isEmpty())
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pila5.get(pila5.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pI,pD);
                            break;
                        case 6:
                            if(!pila6.isEmpty())
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pila6.get(pila6.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pI,pD);
                            break;
                        case 7:
                            if(!pila7.isEmpty())
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pila7.get(pila7.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP2.get(pilaP2.size()-1),pI,pD);
                            break;
                    }
                break;
                
                case 10:
                    switch(pD){
                        case 1:
                            if(!pila1.isEmpty())
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pila1.get(pila1.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pI,pD);
                            break;
                        case 2:
                            if(!pila2.isEmpty())
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pila2.get(pila2.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pI,pD);
                            break;
                        case 3:
                            if(!pila3.isEmpty())
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pila3.get(pila3.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pI,pD);
                            break;
                        case 4:  
                            if(!pila4.isEmpty())
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pila4.get(pila4.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pI,pD);
                            break;
                        case 5:
                            if(!pila5.isEmpty())
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pila5.get(pila5.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pI,pD);
                            break;
                        case 6:
                            if(!pila6.isEmpty())
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pila6.get(pila6.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pI,pD);
                            break;
                        case 7:
                            if(!pila7.isEmpty())
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pila7.get(pila7.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP3.get(pilaP3.size()-1),pI,pD);
                            break;
                    }
                break;
                
                case 11:
                    switch(pD){
                        case 1:
                            if(!pila1.isEmpty())
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pila1.get(pila1.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pI,pD);
                            break;
                        case 2:
                            if(!pila2.isEmpty())
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pila2.get(pila2.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pI,pD);
                            break;
                        case 3:
                            if(!pila3.isEmpty())
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pila3.get(pila3.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pI,pD);
                            break;
                        case 4:  
                            if(!pila4.isEmpty())
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pila4.get(pila4.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pI,pD);
                            break;
                        case 5:
                            if(!pila5.isEmpty())
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pila5.get(pila5.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pI,pD);
                            break;
                        case 6:
                            if(!pila6.isEmpty())
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pila6.get(pila6.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pI,pD);
                            break;
                        case 7:
                            if(!pila7.isEmpty())
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pila7.get(pila7.size()-1),pI,pD);
                            else
                                MoverCartas(pilaP4.get(pilaP4.size()-1),pI,pD);
                            break;
                    }
                break;
                
            case 12:
                switch(pD){
                    case 1:
                        if(!pila1.isEmpty())
                            MoverCartas(mazo.get(apuntador-1),pila1.get(pila1.size()-1),pI,pD);
                        else
                            MoverCartas(mazo.get(apuntador-1),pI,pD);
                        break;
                    case 2:
                        if(!pila2.isEmpty())
                            MoverCartas(mazo.get(apuntador-1),pila2.get(pila2.size()-1),pI,pD);
                        else
                            MoverCartas(mazo.get(apuntador-1),pI,pD);
                        break;
                    case 3:
                        if(!pila3.isEmpty())
                            MoverCartas(mazo.get(apuntador-1),pila3.get(pila3.size()-1),pI,pD);
                        else
                            MoverCartas(mazo.get(apuntador-1),pI,pD);
                        break;
                    case 4:
                        if(!pila4.isEmpty())
                            MoverCartas(mazo.get(apuntador-1),pila4.get(pila4.size()-1),pI,pD);
                        else
                            MoverCartas(mazo.get(apuntador-1),pI,pD);
                        break;
                    case 5:
                        if(!pila5.isEmpty())
                            MoverCartas(mazo.get(apuntador-1),pila5.get(pila5.size()-1),pI,pD);
                        else
                            MoverCartas(mazo.get(apuntador-1),pI,pD);
                        break;
                    case 6:
                        if(!pila6.isEmpty())
                            MoverCartas(mazo.get(apuntador-1),pila6.get(pila6.size()-1),pI,pD);
                        else
                            MoverCartas(mazo.get(apuntador-1),pI,pD);
                        break;
                    case 7:
                        if(!pila7.isEmpty())
                            MoverCartas(mazo.get(apuntador-1),pila7.get(pila7.size()-1),pI,pD);
                        else
                            MoverCartas(mazo.get(apuntador-1),pI,pD);
                        break;
                    case 8:
                        if(pilaP1.isEmpty()){
                            MoverCartas(mazo.get(apuntador-1),pI,pD);}
                        else
                            MoverCartas(mazo.get(apuntador-1),pilaP1.get(pilaP1.size()-1),pI,pD);
                        break;
                    case 9:
                        if(pilaP2.isEmpty()){
                            MoverCartas(mazo.get(apuntador-1),pI,pD);}
                        else
                            MoverCartas(mazo.get(apuntador-1),pilaP2.get(pilaP2.size()-1),pI,pD);
                        break;
                    case 10:
                        if(pilaP3.isEmpty()){
                            MoverCartas(mazo.get(apuntador-1),pI,pD);}
                        else
                            MoverCartas(mazo.get(apuntador-1),pilaP3.get(pilaP3.size()-1),pI,pD);
                        break;
                    case 11:
                        if(pilaP4.isEmpty()){
                            MoverCartas(mazo.get(apuntador-1),pI,pD);}
                        else
                            MoverCartas(mazo.get(apuntador-1),pilaP4.get(pilaP4.size()-1),pI,pD);
                        break;
                }
                break;
    }
        
    //System.out.println(pila5 + " a " + pila3);
    
    }
    
    // metodo para mover escaleras
    public void MoverCartas(int pI, int pD, int ini){
        ArrayList<Carta> lista;
        ArrayList<Carta> lista2;
        lista = new ArrayList();
        lista2 = new ArrayList();
        switch(pI){
            case 1:
                lista = getCartasVisibles(pila1,estadoP1);
                break;
            case 2:
                lista = getCartasVisibles(pila2,estadoP2);
                break;
            case 3:
                lista = getCartasVisibles(pila3,estadoP3);
                break;
            case 4:
                lista = getCartasVisibles(pila4,estadoP4);
                break;
            case 5:
                lista = getCartasVisibles(pila5,estadoP5);
                break;
            case 6:
                lista = getCartasVisibles(pila6,estadoP6);
                break;
            case 7:
                lista = getCartasVisibles(pila7,estadoP7);
                break;
        }
        switch(pD){
            case 1:
                lista2 = pila1;
                break;
            case 2:
                lista2 = pila2;
                break;
            case 3:
                lista2 = pila3;
                break;
            case 4:
                lista2 = pila4;
                break;
            case 5:
                lista2 = pila5;
                break;
            case 6:
                lista2 = pila6;
                break;
            case 7:
                lista2 = pila7;
                break;
        }
        
        if (lista2.isEmpty()&& esK(lista.get(0))){
            MoverCartas(lista.remove(0),pI,pD);
        }
            
        for(int i =0;i<lista.size();i++){
                Carta c = getCartaSiguiente(pD);
                MoverCartas(lista.get(i),c,pI, pD);
            }
        
    }
    
    private Carta getCartaSiguiente(int pD){
        Carta cp = null;
        switch(pD){
            case 1:
                cp = pila1.get(pila1.size()-1);
                break;
            case 2:
                cp = pila2.get(pila2.size()-1);
                break;
            case 3:
                cp = pila3.get(pila3.size()-1);
                break;
            case 4:
                cp = pila4.get(pila4.size()-1);
                break;
            case 5:
                cp = pila5.get(pila5.size()-1);
                break;
            case 6:
                cp = pila6.get(pila6.size()-1);
                break;
            case 7:
                cp = pila7.get(pila7.size()-1);
                break;
        }
        
        return cp;
    }
    
    //para agregar AS a cualquier pila de palos (solo si esta vacia) donde la pila destino puede ser de la 8 a la 11
    //para agregar K a cualquier pila de mesa (solo si esta vacia) donde la pila destino puede ser de la 1 a la 7
    //Recibe una Carta y la pila inicio y destino (entero)
    private void MoverCartas(Carta i, int pI, int pD){
        if(esK(i)){
            switch(pD){
                case 1:
                    pila1.add(i);
                    estadoP1.add(Boolean.TRUE);
                    RemoveCarta(pI);
                    break;
                case 2:
                    pila2.add(i);
                    estadoP2.add(Boolean.TRUE);
                    RemoveCarta(pI);
                    break;
                case 3:
                    pila3.add(i);
                    estadoP3.add(Boolean.TRUE);
                    RemoveCarta(pI);
                    break;
                case 4:
                    pila4.add(i);
                    estadoP4.add(Boolean.TRUE);
                    RemoveCarta(pI);
                    break;
                case 5:
                    pila5.add(i);
                    estadoP5.add(Boolean.TRUE);
                    RemoveCarta(pI);
                    break;
                case 6:
                    pila6.add(i);
                    estadoP6.add(Boolean.TRUE);
                    RemoveCarta(pI);
                    break;
                case 7:
                    pila7.add(i);
                    estadoP7.add(Boolean.TRUE);
                    RemoveCarta(pI);
                    break;
                case 8:
                    System.out.println("Movimiento no valido");
                    break;
                case 9:
                    System.out.println("Movimiento no valido");
                    break;
                case 10:
                    System.out.println("Movimiento no valido");
                    break;
                case 11:
                    System.out.println("Movimiento no valido");
                    break;
            }
        }
        
        else if(esAs(i)){
            switch(pD){
                case 8:
                    pilaP1.add(i);
                    RemoveCarta(pI);
                    break;
                case 9:
                    pilaP2.add(i);
                    RemoveCarta(pI);
                    break;
                case 10:
                    pilaP3.add(i);
                    RemoveCarta(pI);
                    break;
                case 11:
                    pilaP4.add(i);
                    RemoveCarta(pI);
                    break;
            }
        }
    }
    
    //para mover cualquier carta entre pilas de mesa y pilas de palos
    // Recibe la Carta que se quiere mover y la ultima Carta de la pila destino
    // Recibe la pila destino (entero)
    private void MoverCartas(Carta i, Carta d, int pI, int pD){
        if(puedeMover(i,d,pD)){
        switch(pD){
            case 1:
                pila1.add(i);
                estadoP1.add(Boolean.TRUE);
                break;
            case 2:
                pila2.add(i);
                estadoP2.add(Boolean.TRUE);
                break;
            case 3:
                pila3.add(i);
                estadoP3.add(Boolean.TRUE);
                break;
            case 4:
                pila4.add(i); 
                estadoP4.add(Boolean.TRUE);
                break;
            case 5:
                pila5.add(i);
                estadoP5.add(Boolean.TRUE);
                break;
            case 6:
                pila6.add(i);
                estadoP6.add(Boolean.TRUE);
                break;
            case 7:
                pila7.add(i);
                estadoP7.add(Boolean.TRUE);
                break;
            case 8:
                pilaP1.add(i);
                break;
            case 9:
                pilaP2.add(i);
                break;
            case 10:
                pilaP3.add(i);
                break;
            case 11:
                pilaP4.add(i);
                break;
        }
        RemoveCarta(pI);
        }
    }
    
    private void RemoveCarta(int pI){
        switch(pI){
            case 1:
                pila1.remove(pila1.size()-1);
                estadoP1.remove(estadoP1.size()-1);
                if(!pila1.isEmpty()){
                    if(false==estadoP1.get(estadoP1.size()-1)){
                        estadoP1.set(estadoP1.size()-1, Boolean.TRUE);
                    }
                }
                break;
            case 2:
                pila2.remove(pila2.size()-1);
                estadoP2.remove(estadoP2.size()-1);
                if(!pila2.isEmpty()){
                    if(false==estadoP2.get(estadoP2.size()-1)){
                        estadoP2.set(estadoP2.size()-1, Boolean.TRUE);
                    }
                }
                break;
            case 3:
                pila3.remove(pila3.size()-1);
                estadoP3.remove(estadoP3.size()-1);
                if(!pila3.isEmpty()){
                    if(false==estadoP3.get(estadoP3.size()-1)){
                        estadoP3.set(estadoP3.size()-1, Boolean.TRUE);
                    }
                }
                break;
            case 4:
                pila4.remove(pila4.size()-1);
                estadoP4.remove(estadoP4.size()-1);
                if(!pila4.isEmpty()){
                    if(false==estadoP4.get(estadoP4.size()-1)){
                        estadoP4.set(estadoP4.size()-1, Boolean.TRUE);
                    }
                }
                break;
            case 5:
                pila5.remove(pila5.size()-1);
                estadoP5.remove(estadoP5.size()-1);
                if(!pila5.isEmpty()){
                    if(false==estadoP5.get(estadoP5.size()-1)){
                        estadoP5.set(estadoP5.size()-1, Boolean.TRUE);
                    }
                }
                break;
            case 6:
                pila6.remove(pila6.size()-1);
                estadoP6.remove(estadoP6.size()-1);
                if(!pila6.isEmpty()){
                    if(false==estadoP6.get(estadoP6.size()-1)){
                        estadoP6.set(estadoP6.size()-1, Boolean.TRUE);
                    }
                }
                break;
            case 7:
                pila7.remove(pila7.size()-1);
                estadoP7.remove(estadoP7.size()-1);
                if(!pila7.isEmpty()){
                    if(false==estadoP7.get(estadoP7.size()-1)){
                        estadoP7.set(estadoP7.size()-1, Boolean.TRUE);
                    }
                }
                break;
                
            case 8:
                pilaP1.remove(pilaP1.size()-1);
                break;
                
            case 9:
                pilaP2.remove(pilaP2.size()-1);
                break;
                
            case 10:
                pilaP3.remove(pilaP3.size()-1);
                break;
            
            case 11:
                pilaP4.remove(pilaP4.size()-1);
                break;
                
            case 12:
                if(apuntador==1){
                    resp = mazo.get(apuntador).toString();
                    mazo.remove(apuntador-1);}
                else{
                    apuntador--;
                    resp = mazo.get(apuntador-1).toString();
                    mazo.remove(apuntador);}
                break;
        }
    }

    // devuelve true si la carta es AS
    private Boolean esAs(Carta c){
        if(c.Valor()==1)
            return true;
        else
            return false;
    }
    
    // devuelve true si la carta es K
    private Boolean esK(Carta c){
        if(c.Valor()==13)
            return true;
        else
            return false; 
    }
    
    //determina si es un movimiento valido
    //Recibe la Carta que se quiere mover y la ultima Carta ubicada en la pila destino
    //asi como la pila destino (entero)
    private Boolean puedeMover(Carta pI, Carta pD, int d){
        Boolean respuesta;
        int restaMesa = pD.Valor()-pI.Valor();
        int restaPilaPalos = pI.Valor() - pD.Valor();
        String p1 = pI.Palo();
        String p2 = pD.Palo();
        
        if(d<=7){
            if((pI.Valor()<pD.Valor() && restaMesa == 1) &&( 
                    ((p1.equals("ESPADAS")||p1.equals("TREBOLES")) && 
                    (p2.equals("CORAZONES")||p2.equals("DIAMANTES"))) ||
                    ((p2.equals("ESPADAS")||p2.equals("TREBOLES")) && 
                    (p1.equals("CORAZONES")||p1.equals("DIAMANTES"))))
                    ){
                respuesta = true;
                //System.out.println("SI se pudo: Pila de mesa");
            }
            else{
                respuesta = false;
//                System.out.println("Valor/Palo Carta a mover: " + pI.Valor() + " de " + pI.Palo());
//                System.out.println("Valor/Palo Carta de pila Palo: " + pD.Valor()+ " de " + pD.Palo());
                System.out.println("\n xXx NO se puede realizar el movimiento xXx \n");
            }
        }
        else{
            if(pI.Valor()>pD.Valor() && pI.Palo().equals(pD.Palo()) && restaPilaPalos == 1){
                respuesta = true;
            }
            else{
                respuesta = false;
                System.out.println("\n xXx NO se puede realizar el movimiento xXx \n");
            }
        }
        return respuesta;
    }
}

//por hacer:
    // verificar cuando se gana

// errores conocidos: 
    // validaciones
