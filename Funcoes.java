/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author   :  Yuri Domingos 
 * Data      :  15 - 12 - 2020
 * Objectivo :  Criar o reportório das funções gerais 
 */
public class Funcoes {
    
    
    private Image Computer_Car, segundaVia;

    
    
    
    
    public Funcoes() {
        
         Computer_Car = new ImageIcon(this.getClass().getResource("511-5e-png-top-down-car-transparent-png.png")).getImage();
          segundaVia= new ImageIcon(this.getClass().getResource("511-5112270_car-sprite-pngp-down-car-transparent-png.png")).getImage();
    }

    public Image getComputer_Car() {
        return Computer_Car;
    }

    public void setComputer_Car(Image Computer_Car) {
        this.Computer_Car = Computer_Car;
    }

    public Image getSegundaVia() {
        return segundaVia;
    }

    public void setSegundaVia(Image segundaVia) {
        this.segundaVia = segundaVia;
    }
    
    
    
    public void draw_object_cars(Graphics2D graphics2D,ArrayList<Rectangle> objecto)
    {
         for ( Rectangle rect : objecto)
         {
            
             //graphics2D.setPaint(Color.blue);
            //graphics2D.fillRect(rect.x,rect.y,rect.width+25,rect.height+25);
            graphics2D.drawImage(Computer_Car,rect.x,rect.y,rect.width+25,rect.height+25,null);
        }
    }
    
    
    
    
     public void draw_object_cars2(Graphics2D graphics2D,ArrayList<Rectangle> objecto)
    {
         for ( Rectangle rect : objecto)
         {
            
          
            graphics2D.drawImage( segundaVia,rect.x+40,rect.y+10,rect.width+25,rect.height+35, null);
            // graphics2D.setPaint(Color.RED);
             //graphics2D.fillRect(rect.x+40,rect.y+10,rect.width+25,rect.height+35);
        }
    }
    
    
    public void draw_atomatic_lines(Graphics2D graphics2D, ArrayList<Rectangle> objecto)
    {
        
          for ( Rectangle rect : objecto)
          {
              
           graphics2D.fill( new Rectangle2D.Double (rect.x-60, rect.y, rect.width, rect.height));
           
          }
    }
    
    
    
     public void draw_atomatic_lines2(Graphics2D graphics2D, ArrayList<Rectangle> objecto)
    {
        
          for ( Rectangle rect : objecto)
          {
              
           graphics2D.fill( new Rectangle2D.Double (rect.x+60, rect.y, rect.width, rect.height));
           
          }
    }
    
    
     
     
     
    
    
    
    
    
    
    
    
    
}
