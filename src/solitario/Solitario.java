/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitario;

import java.util.Scanner;

/**
 *
 * @author Xavi
 */
public class Solitario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Scanner s = new Scanner(System.in);
          int opcion = 0;
          int opcion2 = 0;
          int cI = 0;
          int cD = 0;
          int ini = 0;
          Mazo juego = new Mazo(); //Crea nuevo mazo
          juego.Revolver();
          juego.CrearPilasPalos();
          juego.CrearPilasDeMesa();
          juego.CrearPilaDescarte();
          juego.actualizaPantalla();
          while(opcion!=4){
          System.out.println("\n \n ****MENU PRINCIPAL****");
          System.out.println("");
          System.out.println("1.- Mover carta");
          System.out.println("2.- Mover escalera de cartas");
          System.out.println("3.- Pedir carta");
          System.out.println("4.- Salir");
          System.out.println("");
          System.out.println("****MENU PRINCIPAL****");
          System.out.println("ELIGE UNA OPCION:");
          opcion = s.nextInt();
          switch(opcion){
              case 1:
                  System.out.println("Ingresa donde se ubica la carta a mover:");
                  System.out.println("De pila de mesa: 1 - 7");
                  System.out.println("De pila de palos: 8 - 11");
                  System.out.println("De baraja descarte: 12");
                  cI = s.nextInt();
                  System.out.println("A pila de mesa: 1 - 7");
                  System.out.println("A pila de palos: 8 - 11");
                  cD = s.nextInt();
                  juego.MoverCartas(cI, cD);
                  break;
                  
              case 2:
                  System.out.println("Ingresa la columna de inicio: (1 - 7):");
                  cI = s.nextInt();
                  System.out.println("Ingresa la columna de destino: (1 - 7):");
                  cD = s.nextInt();
                  System.out.println("Ingresa el numero de cartas a mover:");
                  ini = s.nextInt();
                  opcion2=3;
                  juego.MoverCartas(cI,cD,ini);
                  break;
                  
              case 3:
                  juego.PedirCarta();
                  juego.actualizaPantalla();
                  while(opcion2!=3){
                  System.out.println("ELIGE UNA OPCION");
                  System.out.println("1.- Utilizar carta mostrada");
                  System.out.println("2.- Pedir otra carta");
                  System.out.println("3.- Regresar");
                  System.out.println("");
                  opcion2 = s.nextInt();
                  switch(opcion2){
                      case 1:
                          System.out.println("Ingresa la columna destino: (1 - 7) a pila de mesa y (8 - 11) a pila de palos");
                          cD = s.nextInt();
                          opcion2=3;
                          juego.MoverCartas(12, cD);
                          break;
                      case 2:
                          juego.PedirCarta();
                          juego.actualizaPantalla();
                          break;         
                    }
                  }
                  opcion2 = 1;
                  break;
          }
          juego.actualizaPantalla();
          }
          }
    }
