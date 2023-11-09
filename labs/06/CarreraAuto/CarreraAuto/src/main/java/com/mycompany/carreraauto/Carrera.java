/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carreraauto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Carrera extends Thread{
    private JLabel eti;
    private frmauto p;
    
    public Carrera (JLabel eti, frmauto p){
        this.eti =eti;
        this.p=p;
    }
    
    public void run(){
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        while(true){
            try{
                sleep((int)(Math.random()*1000));
                c1 = p.getlbl1().getLocation().x;
                c2 = p.getlbl1().getLocation().x;
                c3 = p.getlbl1().getLocation().x;
                c4 = p.getlbl1().getLocation().x;
                if(c1<p.getlbl_barrera().getLocation().x-10&&c2<p.getlbl_barrera().getLocation().x-10&&c3<p.getlbl_barrera().getLocation().x-10&&c4<p.getlbl_barrera().getLocation().x-10){
                        eti.setLocation(eti.getLocation().x+10,eti.getLocation().y);
                        p.repaint();
                }else{
                    break;
                }  
                    
                    } catch (InterruptedException e){   
            }
            if(eti.getLocation().x>=p.getlbl_barrera().getLocation().x-10){
                if(c1>c2&&c1>c3&&c1>c4){
                    JOptionPane.showMessageDialog(null, "Gano el auto #1");
                }else if(c2>c1&&c2>c3&&c2>c4){
                    JOptionPane.showMessageDialog(null, "Gano el auto #2");
                }else if(c3>c1&&c3>c2&&c3>c4){
                    JOptionPane.showMessageDialog(null, "Gano el auto #3");
                }else if(c4>c1&&c4>c2&&c4>c3){
                    JOptionPane.showMessageDialog(null, "Gano el auto #4");
                }else{
                    JOptionPane.showMessageDialog(null, "Empate");
                }
            }
        }
    }
}
