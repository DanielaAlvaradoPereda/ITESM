import java.awt.Graphics;
import javax.swing.JPanel;
public class PanelB extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        int ancho = getWidth();
        int alto = getHeight();
        
        int unidad = 25;
        
        for(int i = 1; i <= 20; i++)
        {
            g.drawLine(0, 0, unidad * i, alto - unidad * i);
        }
        for(int i = 1; i <= 20; i++)
        {
            g.drawLine(ancho, 0, unidad * i, unidad * i);
        }
        for(int i = 1; i <= 20; i++)
        {
            g.drawLine(ancho, alto, unidad * i, alto - unidad * i);
        }
        for(int i = 1; i <= 20; i++)
        {
            g.drawLine(0, alto, unidad * i, unidad * i);
        }
    }
}
