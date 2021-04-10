/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.lang.Math;
 
public class Spawn {
    Handler handler;
    Player player;
    int counter = 0;
    
     
 
    public Spawn(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
    }
   public void tick(){
       
       
       
         ++counter;
          
         if(counter == 200){
               if(player.coins<80)handler.addObject(new Coin(80,120,ID.Coins)); 
               if(player.health <= 20 )handler.addObject(new Health(45,200,ID.Health));
                   {
                    counter = 0;
                    }
            }
       
       
       
       }
        
 
    
      // if(player.coins<100)handler.addObject(new Coin(60,100,ID.Coins)); 
     //if(player.health <= 20 )handler.addObject(new Health(45,200,ID.Health)); 

     
       
         
            
    
        
        
       
   
}
