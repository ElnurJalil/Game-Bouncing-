package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.lang.Math;  

 
    public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 800, HEIGHT = 500; // Your game Canvas dimensions.
    private window gameWindow;
    private Thread thread;
    private boolean running = false;
    private  Player player;//create player     
    private Handler handler;
    private HUD hud;    
    private Spawn spawn;
    private Obj1 enemy1;
    private Obj1 enemy2;
    private Obj1 enemy3;
    private Obj1 enemy4;
    private Coin coins;
    private StrongEnemy strongenemy; 
     
   


    public Game(){
        
     initGame();
     
     spawn = new Spawn(handler,player);
       
     addKeyListener(new KeyInput(this,player));
    
    
    
    gameWindow = new window(WIDTH,HEIGHT,"Game by Elnur Jalilov",this);
    }
    
    
 public void initGame(){ 
    handler = new Handler();//create handler
       int max = 3; 
       int min = 1; 
       int range = max - min; 
       int rand = (int)(Math.random() +min) * range; 
       int z = (int)((Math.random()+2)*100);
    player = new Player(100,100,ID.Player,handler);//create player
    enemy1 = new Obj1(100,200,ID.Enemy); //create 1.enemy
    enemy2 = new Obj1(50,150,ID.Enemy);
    enemy3 = new Obj1(150,100,ID.Enemy);
    enemy4 = new Obj1(110,80,ID.Enemy);
    coins = new Coin(z,z,ID.Coins);
    
//enemies speeds 
    
    enemy2.velX=rand*2;
    enemy2.velY=0;
    enemy3.velX=rand+4;
    enemy3.velY=rand*2;
    enemy4.velX=rand*3;
    enemy4.velY=rand+4;
     
 //enemies sizes
    enemy2.width = 30;
    enemy2.height = 30;
    enemy3.width = 20;
    enemy3.height = 22;
    
     
    
    hud = new HUD(player);
     
    
    handler.addObject(player);
    handler.addObject(enemy1);
    handler.addObject(enemy2);
    handler.addObject(enemy3);
    handler.addObject(enemy4);
    handler.addObject(coins);
 
   
    
 }
    public static void main(String[] args) {
        Component frame = null;
    JOptionPane.showMessageDialog(frame, "Are you Ready?\n"+"Run from blue objects :)"
            + "\n"+"Don`t touch Red enemies\n"+"Try to reach 50 Coins for win");
     new Game();
     
    }//call game function
   
 //--------------------------------------------------------------------------  
    //start method standart
    public synchronized void start() {
    thread = new Thread(this);
    thread.start();
    running =true;
    }
    
    //stop method standart
    public synchronized void stop() {
        
    try {
    thread.join();
    running =false;
    } 
    
    catch (InterruptedException ex) {
    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
//----------------------------------------------------------------------------
   
//GameLoop 
@Override
    public void run() { //standart run function
    this.requestFocus();//focusing
    long lastTime = System.nanoTime();//time
    double ammountOfTicks = 60.0;//tickspersecond also we can set speed of game
    double ns = 1000000000 / ammountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    
    
    while(running){
    long now = System.nanoTime();
    delta +=(now - lastTime)/ns;
    lastTime = now;
    
    
    while(delta >= 1)
    {
    tick();
    delta--;
    }
    if(running)
    {
    render();//while runnig render continuously
    frames++;
    }
    if ((System.currentTimeMillis()- timer)>1000)
    {
    timer += 1000;
    System.out.println("FPS :"+frames);
    frames = 0;
    }
    }
    stop();
    }
    
    //GAME ENGINE
    private void tick() {
      //player.tick();//object player for move x,y directions
     // enemy1.tick();
          handler.tick();
          
          spawn.tick();
    }

    private void render()
    {
    BufferStrategy bs = this.getBufferStrategy();
    if(bs == null){
    this.createBufferStrategy(3);
    return;
    }
    
    Graphics g = bs.getDrawGraphics();
    g.setColor(new Color(255,150,150));
    g.fillRect(0,0, WIDTH, HEIGHT);
    
    handler.render(g);
    hud.render(g);
    //player.render(g);
    //enemy1.render(g);
     
     

    g.dispose();
    bs.show();
    }
     public static int clamp(int number,int min,int max){
    if (number >= max)return number = max;
    else if (number <= min) return number = min;
    return number;
    }

    
}
   
 