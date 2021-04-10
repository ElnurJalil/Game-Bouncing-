/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author user
 */
public class Health extends GameObject {

    public Health(int x, int y, ID id) {
        super(x, y, id);
        velX=5;
        velY=3;
    }

    @Override
    public Rectangle getBounds() {
       return new Rectangle(x,y,width,height);
    }

    @Override
    public void tick() {
       x += velX;
       y += velY;
        
    //   x = Game.clamp(x,0,Game.WIDTH - (width+15));
    //   y = Game.clamp(y,0,Game.HEIGHT - (height+15));
    
    //random moement
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
       g.setColor(Color.green);
       g.fillOval(x, y, 20, 20);
    }
    
}
