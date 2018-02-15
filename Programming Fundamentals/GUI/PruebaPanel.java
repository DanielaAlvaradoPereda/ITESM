import javax.swing.JFrame;
public class PruebaPanel
{
    public static void main()
    {
        PanelB miPanel = new PanelB();
        JFrame ventana = new JFrame();
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(miPanel);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
    }
}
