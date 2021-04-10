/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class HUD {
    Player player;
    public HUD(Player player){
    this.player = player;
    }
    
    public void render(Graphics g){
    g.setColor(Color.green);
    g.fill3DRect(10, 10, 2*player.health, 50, true);
    g.setColor(Color.red);
    g.fill3DRect(2*player.health+10, 10, (200-2*player.health), 50, true);
    g.setColor(Color.black);    
    g.drawString("Players health:"+player.health, 300, 25);
    g.drawString("Your Coins:"+player.coins, 450, 25);
        
    }
    
    
    
    
}
