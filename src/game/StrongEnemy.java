/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import static java.lang.Math.max;
import static java.lang.StrictMath.max;
import static javafx.scene.paint.Color.color;


/**
 *
 * @author user
 */
public class StrongEnemy extends GameObject{

    public StrongEnemy(int x, int y, ID id) {
        super(x, y, id);
        width = 35;
        height = 35;
        velX = 8;
        velY = 6;
    }

     
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);  
    }

    @Override
    public void tick() {
         
       x += velX;
       y += velY;

       if( y >= Game.HEIGHT    || y <=0)
       {
           velY *= -1;
       }
       if( x >= Game.WIDTH    || x <=0)
       {
           velX *= -1; 
       }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);

       g.fillOval(x, y, width, height);
       

  

      
    
}     


    
}


