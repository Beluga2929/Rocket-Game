package progame1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Homepage extends JPanel
{
    private ImageIcon bg = new ImageIcon(this.getClass().getResource("bg4.gif"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("start.png"));
    public JButton BStart = new JButton(start);
    Homepage(){
            setLayout(null);
            BStart.setBounds(330,300,220,100);
            add(BStart);
	}
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bg.getImage(),0,0,1000,800,this);
            g.setColor(Color.PINK);
            g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));		
            g.drawString("Rocket",290,130);	
	}
}
