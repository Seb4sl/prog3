/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matrices;

import java.util.Scanner;

/**
 *
 * @author jlarr
 */
public class MATRICES {

    public static void main(String[] args) {
      
    Scanner teclado = new Scanner (System.in);
    
    int primeraMatriz[][] = new int [3][3];
    int segundaMatriz[][] = new int [3][3];
    int sumaResultado[][] = new int [3][3];
    int restaResultado[][] = new int [3][3];
    int multResultado[][] = new int [3][3];
    
    
        System.out.println("Digite los elementos de la primera matriz");
        for(int i = 0 ; i<3 ; i ++){
            for (int j = 0 ; j<3 ; j++){
                System.out.println("Digite un elemento en la posicion ["+i+"]["+j+"] : ");
                primeraMatriz[i][j] = teclado.nextInt();
            }
        }
        
        System.out.println("");    

        System.out.println("Digite los elementos de la segunda matriz");
        for(int i = 0 ; i<3 ; i ++){
            for (int j = 0 ; j<3 ; j++){
                System.out.println("Digite un elemento en la posicion ["+i+"]["+j+"] : ");
                segundaMatriz[i][j] = teclado.nextInt();
            }
        }
        
        for(int i = 0 ; i<primeraMatriz.length ; i++){
            for(int j = 0 ; j<segundaMatriz.length ; j++){
                sumaResultado[i][j] = primeraMatriz[i][j] + segundaMatriz [i][j];
            }
        }
        for(int i = 0 ; i<primeraMatriz.length ; i++){
            for(int j = 0 ; j<segundaMatriz.length ; j++){
                restaResultado[i][j] = primeraMatriz[i][j] - segundaMatriz [i][j];
            }
        }
        for(int i = 0 ; i<primeraMatriz.length ; i++){
            for(int j = 0 ; j<segundaMatriz.length ; j++){
                multResultado[i][j] = primeraMatriz[i][j]* segundaMatriz [i][j];
            }
        }
        
        System.out.println("");
        
        System.out.println("La suma de las matrices es de: ");
        for(int i = 0 ; i<primeraMatriz.length; i++){
             for(int j = 0 ; j<primeraMatriz.length; j++){
                 System.out.print(" [ " +primeraMatriz[i][j] + " ]");   
             }
             
             if(i==1){
                 System.out.println("       +       ");
                 
             }else{
                 System.out.println("               ");                 
                 
             }
             for(int j = 0 ; j<segundaMatriz.length; j++){
                 System.out.print(" [ " +primeraMatriz[i][j] + " ]");   
             }
             if(i==1){
                 System.out.println("       =       ");
                 
             }else{
                 System.out.println("               ");                 
                 
             }
              for(int j = 0 ; j<sumaResultado.length; j++){
                 System.out.print(" [ " +sumaResultado[i][j] + " ]");   
             }           
             System.out.println("");
        }
    }
}
