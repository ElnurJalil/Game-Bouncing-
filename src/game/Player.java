/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JOptionPane;






public class Player extends GameObject {
    Handler handler;
    Color col;
    int point = 0;
    
    boolean[] keyPressed = new boolean[5];
    //objects dimensions player
    int health = 100;
    private Component frame;
    int coins;
    int StrongEnemy;//n
    

    public Player(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        col = Color.white;
        //object speed
             velX = 7;
             velY = 0;
        //object own dimensions     
             width = 30;
             height = 30;
             
             keyPressed[0] = false;
             keyPressed[1] = false;
             keyPressed[2] = false;
             keyPressed[3] = false;
             keyPressed[4] = false;
             
             
             
             
    }

    @Override
    public Rectangle getBounds() {
      return new Rectangle(x,y,width,height);
    }

    @Override
    public void tick() {
        int s = 10;
        if(keyPressed[1]) velX = -s;
        else if(keyPressed[2])
            velX=s;
        else velX=0;
        
        
        if(keyPressed[3]) velY = -s;         
        else if(keyPressed[4]) 
            velY = s;
        else velY =0;
        
        
        
        //for move
        x += velX;
        y += velY;
        
        //screen width - object width + 5
        
        x = Game.clamp(x,0,Game.WIDTH - (width+5));    
        y = Game.clamp(y,0,Game.HEIGHT - (height+30));
        
        collision();
    }

    
    private void collision(){
    
    
     
        for(int i = 0;i<handler.object.size();i++)
        {
            
        GameObject tempObj = handler.object.get(i);
        
        
        if(tempObj.getId()==ID.Enemy)
        {
        if(getBounds().intersects(tempObj.getBounds()))
        {
        col = Color.red;
         //adding bound to health
             if(health>-1)
             {
             --health;
             if(health == -1)
             {
             JOptionPane.showMessageDialog(frame,"You Lose");               
             //result==health;
             int result = 0;             
             if(result == JOptionPane.YES_OPTION)
             {
                 System.exit(0);
             }
             }else{ col = Color.white;}
             }        
         }
        
        }
        else if (tempObj.getId()==ID.Health)
            {
               if(this.getBounds().intersects(tempObj.getBounds()))
            {
            col = Color.white;
            if(health<100)
                {
                 health += 5;
                  
                }
                handler.object.remove(tempObj);
                }
               else
               {
                col =Color.white;
                }
            }
        else if(tempObj.getId() == ID.Coins){
         if(this.getBounds().intersects(tempObj.getBounds())){
          coins += 2;
         handler.object.remove(tempObj);
          if(coins==50){
          JOptionPane.showMessageDialog(frame,"You Win :)");
          int result = 0;             
             if(result == JOptionPane.YES_OPTION)
             {
                 System.exit(0);
             }
            
          }
          if(coins==20){
              // handler.addObject(new StrongEnemy(100,150,ID.StrongEnemy));
              JOptionPane.showMessageDialog(frame,"    You reached Level 2");
              
              health+=20;
              if(health>100){
                 health =100;//new
                 }
              
              
                  
          }
           if(coins==30){
                handler.addObject(new StrongEnemy(100,150,ID.StrongEnemy));
              JOptionPane.showMessageDialog(frame,"                     You Reached Level 3");
              
              if(health<80){
              health+=20;
              }
              
               
          }
            if(coins==40){
                handler.addObject(new StrongEnemy(200,250,ID.StrongEnemy));
              JOptionPane.showMessageDialog(frame,"                     You Reached Level 4");
              
              if(health<80){
              health+=20;
              }
              
               
          }
             if(coins==40){
                 
               if(health<80){
              health+=20;
              }
               
               
          }
         }
         
        }
        else if(tempObj.getId() == ID.StrongEnemy){
            if(this.getBounds().intersects(tempObj.getBounds())){
                JOptionPane.showMessageDialog(frame,"You Lose :( ");
          int result = 0;             
             if(result == JOptionPane.YES_OPTION)
             {
                 System.exit(0);
             }
            
             }    
          
        }
        }
        
        
        
    }
           
      
            
      
    
        
               
                       
    
     
    
    
 
    
    @Override
    public void render(Graphics g) {
        g.setColor(col);
        g.fillOval(x, y, width, height);
        g.setColor(col);
     //   g.drawRect(x,y,width,height);
    }
    }

  
       

    
  
