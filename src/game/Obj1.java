/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.util.Random;
import java.lang.Math;  

/**
 *
 * @author user
 */
public class Obj1 extends GameObject{
    
    public Obj1(int x,int y,ID id){
    super(x,y,id);
         
             velX = 7;
             velY = 6;
        //object own dimensions     
          //   width = 10;
          //   height = 10;
    }

  

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }

    @Override
    public void tick() {
     
      
        
        
           
         
        
        
        
        
       x += velX;
       y += velY;
        
     //  x = Game.clamp(x,0,Game.WIDTH - (width+5));
    //   y = Game.clamp(y,0,Game.HEIGHT - (height+5));
       
        
        
        
       if( y >= Game.HEIGHT-40    || y <=0)
       {
           velY *= -1;
       }
       if( x >= Game.WIDTH-25   || x <=0)
       {
           velX *= -1; 
       }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fill3DRect(x, y, width, height, true);
        
    }
    
}
