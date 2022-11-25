
package progame1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Playstate extends JFrame implements ActionListener{
    Homepage mg = new Homepage();
    Allgame all = new Allgame();
    Gameover gv = new Gameover();
    Playstate(){
    this.setSize(1000, 800);
   
    mg.BStart.addActionListener(this);
    this.add(mg);
    
    //this.add(all);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mg.BStart) {
            this.setLocationRelativeTo(null);
            this.setSize(950,500);
            this.remove(mg);
            this.add(all); 
            all.requestFocusInWindow();
            all.timestart = false;
           
        repaint();
        }
        
     
    }
    public static void main(String[] args) {
        JFrame jf = new Playstate();
        jf.setSize(900, 500);
        jf.setTitle("Rocket");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}
