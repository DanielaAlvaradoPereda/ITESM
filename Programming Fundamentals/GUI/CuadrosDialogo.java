import javax.swing.JOptionPane;
public class CuadrosDialogo
{
    public static void main()
    {
        JOptionPane.showMessageDialog(null, "Hola");
        String nombre = JOptionPane.showInputDialog("Cuál es su nombre?");
        
        String mensaje = String.format("Hola %s jaja", nombre);
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
