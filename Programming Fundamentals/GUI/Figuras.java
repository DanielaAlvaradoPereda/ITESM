import java.awt.Graphics;
import javax.swing.JPanel;
public class Figuras extends JPanel
{
    private int opcion;
    
    public Figuras(int opcion)
    {
        this.opcion = opcion;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        for(int i = 0; i < 10; i++)
        {
            switch(opcion)
            {
                case 1:
                    g.drawRect(i * 10 + 10, i * 10 + 10, i * 10 + 50, i * 10 + 50);
                    break;
                case 2:
                    g.drawOval(i * 10 + 10, i * 10 + 10, i * 10 + 50, i * 10 + 50);
                    break;
            }
        }
    }
}
