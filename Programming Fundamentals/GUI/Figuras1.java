import java.awt.Graphics;
import javax.swing.JPanel;
public class Figuras1 extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        int centrox = getWidth() / 2;
        int centroy = getHeight() / 2;
        
         for(int i = 10; i <= 120; i+= 10)
        {
            g.drawOval(centrox - i, centroy - i, 2* i, 2 * i);
        }
    }
}
