import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class PruebaFiguras
{
    public static void main()
    {
        JOptionPane.showMessageDialog(null, "Hola");
        String opcion = JOptionPane.showInputDialog("Escriba 1 para dibujar rectangulos\nEscriba 2 para dibujar triangulos");
        Figuras panel = new Figuras(Integer.parseInt(opcion));
        JFrame ventana = new JFrame();
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 300);
        ventana.add(panel);
        ventana.setVisible(true);
    }
}
