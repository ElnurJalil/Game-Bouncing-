 
package game;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Coin extends GameObject {

    public Coin(int x, int y, ID id) {
        super(x, y, id);
        velX = 7;
        velY = 4;
        width = 18;
        height= 20;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }

    @Override
    public void tick() {
       x += velX;
       y += velY;
       
    
    //random movement
      if( y >= Game.HEIGHT -40   || y <=0)
       {
           velY *= -1;
       }
       if( x >= Game.WIDTH -20   || x <=0)
       {
           velX *= -1; 
       }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, width, height);
    }
    
}
