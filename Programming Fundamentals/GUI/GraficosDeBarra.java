import java.awt.Graphics;
import javax.swing.JPanel;
public class GraficosDeBarra extends JPanel
{
    private int x =

    public void altura(int alto)
    {
        
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        for(int i = 0; i < 5; i++)
        {
            g.drawRect(i * x, y - 
        }
    }
}
