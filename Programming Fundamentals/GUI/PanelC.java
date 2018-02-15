import java.awt.Graphics;
import javax.swing.JPanel;
public class PanelC extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        int ancho = getWidth();
        int alto = getHeight();
        
        int unidad = 25;
        
        for(int i = 0; i <= 20; i++)
        {
            g.drawLine(0, unidad * i, unidad * (i + 1), alto);
        }
        for(int i = 0; i <= 20; i++)
        {
            g.drawLine(unidad * i, 0, ancho, unidad * (i + 1));
        }
    }
}