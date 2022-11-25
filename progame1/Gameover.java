/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progame1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Gameover extends JPanel{
	
     private ImageIcon feildover = new ImageIcon("bg3.gif");
	 
      //private ImageIcon restart = new ImageIcon(this.getClass().getResource("start.png"));
       //public JButton BStartover = new JButton(restart);
	Allgame all = new Allgame();
	
	Gameover(){
		
		this.setLayout(null);
		this.remove(all);
                //BStartover.setBounds(350,300,170,90);
                //add(BStartover);
		
	}
	public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  g.drawImage(feildover.getImage(),0,0,1000,800,this);
		  
		  
	      
	  }
        
}
