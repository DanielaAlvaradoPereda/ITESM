import javax.swing.JFrame;
public class PruebaFiguras1
{
    public static void main()
    {
        Figuras1 panel = new Figuras1();
        JFrame ventana = new JFrame();
        
        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 600);
        ventana.setVisible(true);
    }
}
