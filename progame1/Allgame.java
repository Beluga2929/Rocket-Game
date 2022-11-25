
package progame1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Allgame extends JPanel  {
     private ImageIcon bg2 = new ImageIcon(this.getClass().getResource("bg2.gif"));
     private ImageIcon imgmeleon = new ImageIcon(this.getClass().getResource("Alien.gif"));
    
     Rocket r = new Rocket();
    
     //ImageIcon restart = new ImageIcon("start1.jpg");
     Homepage mg = new Homepage();
     
     
     
     public ArrayList<Bullet> bull = new ArrayList<Bullet>();
     public ArrayList<Alien> alien = new ArrayList<Alien>();
    
   
     ImageIcon feildover = new ImageIcon(this.getClass().getResource("bg3.gif"));
     private JLabel score = new JLabel();
     public int scor = 0;
     
     boolean timestart = true;
     boolean startball = false;
     boolean run =true;
     
     public int times;
    
     
     Thread actor = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });
      
     Thread tballs1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 100) + 1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    alien.add(new Alien());
                }
            }
        }
    });
      

     
     Allgame(){
      this.setFocusable(true);
      this.setLayout(null);
      this.add(score);

        
   
      
      this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
               super.keyPressed(e);
               int a = e.getKeyCode();
                if(a==KeyEvent.VK_UP )
                   r.y-=10;
                    repaint();
                if(a==KeyEvent.VK_DOWN){
                    r.y+=10;   
                    repaint();   
                }
                if(a==KeyEvent.VK_SPACE){
                     scor=0;
                     r.y=125;
                     run=true;
                    
                  
                
                } if (r.count > 3) {
                        r.count = 0;
                    }
                else if (a == KeyEvent.VK_RIGHT) {
                        bull.add(new Bullet(90,r.y+ 30));
                    }
                
              
            }
             
        });
       
       
       r.y = 125;
       actor.start();
       tballs1.start();
       
       
       
     }
     public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bg2.getImage(),0,0,1000,800,this);
            g.setColor(Color.PINK);
            g.drawString("SCORE   " + scor, 400, 40);
            
            g.drawImage(r.rocket.getImage(),r.x,r.y,r.h,r.w,this);
            
            
            for (int i = 0; i < bull.size(); i++) {
                Bullet ba = bull.get(i);
                g.drawImage(ba.imfire[ba.count % 5].getImage(), ba.x, ba.y, 25, 25, null);
                ba.move();
                
                if (ba.x  < 0) {
                    bull.remove(i);
                }
            }
            
            for (int i = 0; i < alien.size(); i++) {
                g.drawImage(alien.get(i).getImage(), alien.get(i).getX(), alien.get(i).getY(), 60, 60, this);
            }
            for (int i = 0; i < bull.size(); i++) {
                for (int j = 0; j < alien.size(); j++) {
                    if (Intersect(bull.get(i).getbound(), alien.get(j).getbound())) {
                        alien.remove(j);
                        bull.remove(i);
                         scor += 10;
                        g.drawString("+10", r.x + 100, 650);
                    }
                }
            }
            
           
           for (int j = 0; j < alien.size(); j++) {
            if (Intersect(r.getbound(), alien.get(j).getbound())) {
            this.setLayout(null);
            run=false;
          

                }
           }
            
             if(run==false){
            
              g.drawImage(feildover.getImage(), 0, 0, 1000, 800, this);
              g.setColor(Color.WHITE);
              g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 40));
              g.drawString("SCORE   " + scor, 340, 200);
              g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 70));
              g.drawString("GAME OVER", 220, 150);
              g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 27));
              g.drawString("SPACE TO RESTART", 300, 250);
             }
                
            
            
          
                
     }
     
    
     public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

   
     
     
     
    
}
     

