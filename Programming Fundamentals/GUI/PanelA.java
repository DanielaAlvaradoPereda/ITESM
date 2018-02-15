import java.awt.Graphics;
import javax.swing.JPanel;
public class PanelA extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        int ancho = getWidth();
        int alto = getHeight();
        
        int unidad = ancho/20;
        
        for(int i = 1; i <= 20; i++)
        {
            g.drawLine(0, 0, unidad * i, alto - unidad * i);
        }
    }
}