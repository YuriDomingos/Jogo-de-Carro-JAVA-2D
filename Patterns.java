/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Yuri Domingos
 */
public class Patterns {
    
    
    
    
    private int space;
    private int speed;
    private ArrayList <Rectangle> otherCars;
    private ArrayList <Rectangle> automaticCar;
    private int posX = 0;
    private int posY = 0;
    
    private int velX = 0;
    private int velY = 0;
    
    
    

    
    
    
    /// construtor 

    public Patterns() {
        
          space = 300;
          speed = 2;
          
            otherCars = new ArrayList<Rectangle>();
            automaticCar = new ArrayList<Rectangle>();
    }
    
    
    
    
    
    
    public ArrayList<Rectangle> getOtherCars() {
        return otherCars;
    }

    public void setOtherCars(ArrayList<Rectangle> otherCars) {
        this.otherCars = otherCars;
    }

    public ArrayList<Rectangle> getAutomaticCar() {
        return automaticCar;
    }

    public void setAutomaticCar(ArrayList<Rectangle> automaticCar) {
        this.automaticCar = automaticCar;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    
    
}
