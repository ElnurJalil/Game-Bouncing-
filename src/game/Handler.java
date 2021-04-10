/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
 
 
public class Handler  {
    ArrayList<GameObject> object = new ArrayList();
    
    public void tick(){
    for (int i = 0;i<object.size();i++){
    GameObject tempObject = object.get(i);
    if(tempObject !=null) tempObject.tick();
    
    }

    }
    public void render(Graphics g){
    for(int i = 0;i<object.size();i++){
    GameObject tempObject = object.get(i);
            if(tempObject != null)tempObject.render(g);
    }
   // g.setColor(Color.yellow);
   // g.fill3DRect(0, 0, 200, 30, true);
    }

     public void addObject(GameObject object){
     this.object.add(object);
     }

   
}
