
package progame1;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/**
 *
 * @author SSP
 */
public class Rocket {
   public ImageIcon rocket = new ImageIcon(this.getClass().getResource("Rocket.gif"));
    public int y;
    public int x;
    public int h=110;
    public int w=83;
    public int count = 0;
    
    
  Rocket(){
      this.x=x;
      this.y=y;
    }
  public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,110,83));
    }
}