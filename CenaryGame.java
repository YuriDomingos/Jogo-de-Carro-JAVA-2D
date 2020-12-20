/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Yuri Domingos
 * Data da última alteração   : 16 - 12 - 2020
 * Objectivo : Construir um jogo de corrida
 * 
 */
public class CenaryGame extends JPanel implements ActionListener, KeyListener  {

    
    
    private int WIDTH = 1400;
    private int HEIGHT = 900;
    private Rectangle car;
     int counter = 0;
    private ArrayList <Rectangle> line;
    private Random random;
    private int width = 80;
    private int height = 70;
    private int move = 20;
    private  Timer t;
    private int count = 1;
    private JLabel label,label2;
    private Calendar cal;
    private Image road, CarStructers,background;
    private Patterns paterns;
    private Funcoes functions;
    private  Point2D.Double[] point = new Point2D.Double[1200];
    
    private boolean rainning = true; 
 

    private boolean linearF = true;
    //-Fazer o método construtor

    public CenaryGame() 
    {
        
     
        paterns = new  Patterns();
        functions = new Funcoes();
        
      //-------------------   Leitura das Imagens 
        
        road         = new ImageIcon(this.getClass().getResource("road.jpg")).getImage();
        CarStructers = new ImageIcon(this.getClass().getResource("primerCar.png")).getImage();
        background = new ImageIcon(this.getClass().getResource("landScap.jpg")).getImage();
        
        //---------------------------------------------------------------------        
        
        random = new Random();
        line = new ArrayList<Rectangle>();
        car = new Rectangle(WIDTH/2-90,HEIGHT-400,width,height); // tavl
      
      
        //-- JLabel's
        label = new JLabel("0");
        label2 = new JLabel("");
        Dimension size = label.getPreferredSize();
        Dimension sizz = label2.getPreferredSize();
        label2.setBounds(10,68,330,50);
        label.setBounds(50, 5, 450, 60);
        //-- Temos Repitições desnecessárias
        label2.setForeground(Color.WHITE);
        label.setForeground(Color.WHITE);
        label2.setFont(new Font("Serief",Font.BOLD,30));
        label.setFont(new Font("Serief",Font.BOLD,30));
        add(label);
        //add(label2);
        
        //---- Time section 
        play("Carro de condução por um.wav");
        cal = new GregorianCalendar();
        setLayout(null);
        
        //-- Cenário 
         for (int i = 0; i < point.length; i++) {

               point[i] = new Point2D.Double(Math.random(), Math.random());
      
         }
         

        addKeyListener(this);
        setFocusable(true);
        
        //--- Chamada dos carros automáticos
        
                addCars(true);
                addCars(true);
                addCars(true);
                addCars(true);
                addCars(true);
                addCars(true);
                addCars(true);
                addCars(true);
                addCars(true);
                addCars(true);

                //--- Carros do centro 

                addCars2(true);
                addCars2(true);
                addCars2(true);
                addCars2(true);
                addCars2(true);
                addCars2(true);
                addCars2(true);
                addCars2(true);
        
      
               addLines(line,WIDTH,true);
               addLines(line,WIDTH,true);
               addLines(line,WIDTH,true);
               addLines(line,WIDTH,true);
               addLines(line,WIDTH,true);
               addLines(line,WIDTH,true);
        
               t = new Timer(30,this);
               
               t.start();
    }
    
    
   //  
        public void paintComponent(Graphics g)
        {
          super.paintComponent(g);
        
          Graphics2D graphics2D = (Graphics2D) g.create();
        
          graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
    
          //graphics2D.drawImage( background, 0,0,WIDTH,HEIGHT, null);
         
          graphics2D.fill(new Rectangle(0,0,1400, 900));
         
          graphics2D.drawImage(road, WIDTH/2-200, 0,380,800, null);
          
          
          
          
         
          //--- cenarfy 
           graphics2D.setStroke(new BasicStroke(4));
          graphics2D.setPaint(Color.RED);
          graphics2D.fill(new Rectangle2D.Double(WIDTH/2+185, 0,5,900 ));
          
          
          graphics2D.setPaint(Color.RED);
          
          graphics2D.fill(new Rectangle2D.Double(490, 0, 5,900 ));
          
          graphics2D.setPaint(Color.darkGray);
          graphics2D.fill(new Rectangle2D.Double(WIDTH/2-200, 0,380,800 ));
         
          graphics2D.setColor(Color.white);
         
          
          functions.draw_atomatic_lines(graphics2D,line);
          
          functions.draw_atomatic_lines2(graphics2D,line);
   
          functions.draw_object_cars(graphics2D, paterns.getOtherCars());
          functions.draw_object_cars2(graphics2D, paterns.getAutomaticCar() );
           
          graphics2D.setFont(new Font("Serief",Font.BOLD,30));
           
          graphics2D.drawString("Score :", 49, 100);
           
          graphics2D.drawImage(CarStructers, car.x+paterns.getPosX(),car.y+paterns.getPosY(), car.width+50, car.height+50,null);
   
         /* graphics2D.setPaint(Color.GREEN);
          graphics2D.fill(new Rectangle2D.Double( car.x+paterns.getPosX()+10,car.y+paterns.getPosY(), car.width+7, car.height+10));
          graphics2D.setPaint(new GradientPaint(55, 20, Color.ORANGE, 3, 100,Color.WHITE, true));
          graphics2D.fill(new Rectangle(200,20,100,100));*/
      
  
          graphics2D.setPaint(new GradientPaint(-150,-150,Color.white,150,150,Color.gray));
          
  
          g.translate(522, 0);
          
           for (int i = 0; i < point.length; i++) {

            int x = (int)(340*point[i].x);

            int y = (int)(980*point[i].y);

            int h = (int)(25*Math.random());

          
            if ( rainning )
            {
                // graphics2D.setComposite(AlphaComposite.SrcOver.derive(2.0f));
                 g.drawLine(x, y, x, y+h);
            }
        }
            
     
    }
    
   
    
    @Override
    
    public void actionPerformed(ActionEvent ae) {
        
        Rectangle rect = null;
        
        count++;
       car.y--;
       
       // Moviments Sectios
       
       paterns.setPosX(paterns.getPosX()+paterns.getVelX());
       paterns.setPosY(paterns.getPosY()+paterns.getVelY());
           
        bring_up_automatic_Object(rect,0,count, move, paterns.getSpeed(),  paterns.getOtherCars());
        
       
       bring_up_automatic_Object(rect,0,count, move,  paterns.getSpeed()/2,  paterns.getAutomaticCar());
        // -- Other way to build work 
        
       colision_of_double_car(paterns.getOtherCars(),car);
        
       
       colision_of_double_car(paterns.getAutomaticCar(),car);
         
       bring_up_again_object(paterns.getOtherCars(), rect,0);
       
       bring_up_again_object( paterns.getAutomaticCar(), rect,0);
       
       bring_up_automatic_Object(rect,0,count, move,  paterns.getSpeed()*2,  line);
        
       int v = 0;
       
       for (int i = 0; i < line.size(); i++)
       {
            
            rect = line.get(i);
            
            if (rect.y + rect.height > HEIGHT)
            {
                
          
                line.remove(rect);
                //linearF = false;
                addLines(line,WIDTH,false);
            }
         }
       
      
       for ( int i = 0; i <paterns.getOtherCars().size();i++)
       {
           if (paterns.getOtherCars().get(i).getY() > car.getY())
           {
               counter++;
               label2.setText(""+counter);
           }
           
       }

         
          //-- atualização da nossa hora 
         
                    Calendar cal = new GregorianCalendar();
                    
                    int day = cal.get(Calendar.HOUR_OF_DAY);
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    
                    int hour = cal.get(Calendar.HOUR);
                    int minutes = cal.get(Calendar.MINUTE);
                    int seconds = cal.get(Calendar.SECOND);
                    
                    
                    label.setText("Hora : "+ hour +" : " +minutes+ " -" +seconds);
          
        repaint();
        
      
    }
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
       
    }

    @Override
    public void keyPressed(KeyEvent ke) {
     /*   
     int choose = ke.getKeyCode();
     
     switch(choose)
     {
         
         
         case KeyEvent.VK_LEFT :
             
             mover_para_esquerda();
             
             break;
             
         case KeyEvent.VK_RIGHT :
             
              mover_para_direita();
              
              break;
              
         case KeyEvent.VK_DOWN :
             
             mover_para_baixo();
             
             break;
             
         case KeyEvent.VK_UP :
             
              mover_para_cima();
              
              break;
              
         default :
             
             System.out.println("Error Invalid operation");
             
     }*/
     
    }

    
    @Override
    public void keyReleased(KeyEvent ke) {
        
        paterns.setVelX(0);
        paterns.setVelY(0);
        int key = ke.getKeyCode();
        
        switch(key)
        {
            
            case KeyEvent.VK_UP :
                
                moveup();
                
              break ;
              
            case KeyEvent.VK_DOWN :
                
                movedown();
                break;
                
            case KeyEvent.VK_LEFT :
                
                moveLeft();
                
                break;
                
            case KeyEvent.VK_RIGHT :
                
                moveRight();
                
                break;
                
            default :
                
                break;
                
                
        }


    }
    
    
//----------------- Funcoes Genéricas  de Automaticidade 

        public void bring_up_automatic_Object(Rectangle rect, int i, int counter, int move, int speed, ArrayList<Rectangle> objecto)
    {
        
            if ( i < objecto.size() )
            {
                 rect = objecto.get(i);
            
                 if (count%1000 == 0)
                 {
                     speed++;
                
                     if (move < 50)
                     {
                        move +=10;
                     }
                  }
                 
                   rect.y += speed; 
                   bring_up_automatic_Object(rect,i+1,counter,move,speed,objecto);
             }
           
        }
    
    
    
    public void bring_up_again_object(ArrayList<Rectangle> objecto, Rectangle rect,int i)
    {
         if( i < objecto.size())
         {
            
            rect = objecto.get(i);
            
            if (rect.y + rect.height > HEIGHT)
            {
                objecto.remove(rect);
                addCars(false);
            }
               
            bring_up_again_object( objecto,rect,i+1);
            
          }
    }
    
    public void colision_of_double_car(ArrayList<Rectangle> objecto1, Rectangle objecto2 )
    {
          
        for( Rectangle r : objecto1)
        {
           
            if (r.intersects(objecto2))
            {
                   JOptionPane.showMessageDialog(null,"Game over");
                     System.exit(0);
                       objecto2.y = r.y+height;
            }
                
            
         
        }
        
        
    }
    
    
    //--- Sequencia dos Elementos automático
   
     public void addLines(ArrayList<Rectangle> objecto,int WIDTH,boolean lenear)
    {
        int x = WIDTH/2-2;
        int y = 795;
        int sp = 130; // espcao de uma linha com a outra
        int width = 4;
        int heigth = 300;
        int space = 20;
        
        if (lenear)
        {
            
            objecto.add(new Rectangle(x,y-(objecto.size()*space),width,height));
            
        }
        else 
        {
          objecto.add(new Rectangle(x,objecto.get(objecto.size()-1).y-sp,width,height));
            
        }
    }
    
   
    public void addCars(boolean first)
    {
        
        
        int positionX = random.nextInt()%2;
        int x = 0;
        int y = 0;
        int Width = width;
        int Height = height;
        
        
        
        if ( positionX == 0)
        {
            x = (WIDTH/2-190);
            
        }else {
           
            x = (WIDTH/2+70);
            
        }
        
        
        
        if (first)
        {
            paterns.getOtherCars().add(new Rectangle(x,y-100-(paterns.getOtherCars().size()*paterns.getSpace()), Width,Height));
            
        }else
        {
          //  otherCars.add(new Rectangle(x,otherCars.get(otherCars.size()-1).y-300,width,height));
        }
    }
    
    
    
    public void addCars2(boolean first)
    {
        
    
        int x = WIDTH/2-100;
        int y = 0;
        int Width = width;
        int Height = height;
        
        int otherX =  random.nextInt()%2;
       
       
        if (first)
        {
           paterns.getAutomaticCar() .add(new Rectangle(x,y-100-(  paterns.getAutomaticCar().size()*paterns.getSpace()), Width,Height));
        }else
        {
            paterns.getAutomaticCar()  .add(new Rectangle(x,  paterns.getAutomaticCar().get( paterns.getAutomaticCar().size()-1).y-300,width,height));
        }
    }
    
    
    
    //----------------------- Movimentos Sections ------------------------------    |||  Just to do other  ---------------
    
    public void mover_para_esquerda()
    {
        
             paterns.setVelX(-5);
    }
    
    public void mover_para_direita()
    {
        paterns.setPosX(5);
        
    }
    
    public void mover_para_cima()
    {
        paterns.setPosY(-5);
        
    }
    
    public void mover_para_baixo()
    {
        paterns.setPosY(5);
    }
    
    public void movedown()
    {
        if ( car.y + move + car.height > HEIGHT-1)
        {
            System.out.println("\b");
            
        }else{
            car.y+=move;
        }
                  
    }

    
      public void moveup()
      {
        if ( car.y- move  > HEIGHT-1)
        {
            System.out.println("\b");
           // JOptionPane.showMessageDialog(null,"Game Over");
            //System.exit(0);
            
        }else{
            car.y-=move;
        }
            
            
     }
      
    public void moveLeft()
    {
        if ( car.x - move < WIDTH/2-250)
        {
             System.out.println("\b");
        }else{
            car.x-=move+4;
        }
                
    }
    

    public void moveRight()
    {
        if ( car.x + move > WIDTH/2+40)
        {
            
        }else{
            car.x+=move+4;
        }
            
            
    }
    
         
    public void play( final String audioNome) 
    {
       
        try{
            
          //  URL url = this.getClass().getClassLoader().getResource(audioNome); se estás a usar o java 11.2 em diante é melhor usares esta linha
          
           AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(audioNome));
           Clip clip = AudioSystem.getClip();
           clip.open(audio);
           clip.start();
           clip.loop(Clip.LOOP_CONTINUOUSLY);
      
         }
        catch (LineUnavailableException  | UnsupportedAudioFileException |IOException ex) {
            
            JOptionPane.showMessageDialog(null, ex);
              
         }
        
    }
    
    

    
}
