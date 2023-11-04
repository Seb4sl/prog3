/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carreraautos;

import javax.swing.JLabel;

/**
 *
 * @author Estudiante
 */
public class Carrera extends Thread {
    private JLabel eti;
    private autos p;
    
    public Carrera(JLabel eti,autos p){
        this.eti=eti;
        this. p=p;
    }
    
    public void run(){
        int c1=0, c2=0, c3=0, c4=0;
        while (true) {
            try {
                sleep((int)(Math.random()*1000));
                c1=p.getC1().getLocation().x;
                c2=p.getC2().getLocation().x;
                c3=p.getC3().getLocation().x;
                c4=p.getC4().getLocation().x;
                if(c1<p.finall().getLocation().x-10&&c2<p.finall().getLocation().x-10&&c3<p.finall().getLocation().x-10&&c4<p.finall().getLocation().x-10&&)
                    
                    
            } catch (Exeption e) {
                
            }
        }
    }
}
