/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame;

import javax.swing.JFrame;

/**
 *
 * @author Yuri Domingos
 * Data  : 16 - 12 - 2020
 * Objectivo : Construir o jogo de computação grafica 
 * 
 * 
 * 
 */
public class CarGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        JFrame frame = new JFrame("Car Game");
        
        frame.setSize(1400, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new CenaryGame());
        frame.setVisible(true);
        
    }
    
}
