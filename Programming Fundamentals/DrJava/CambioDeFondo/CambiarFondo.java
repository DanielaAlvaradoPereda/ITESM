/**
 * Este programa cambia el fondo de una fotografía con pantalla verde
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Miguel Ángel López Muñoz A01327503
 * @version 11/11/16
 * 
 * Entradas: primero se elige la fotografía original, después el fondo que se quiere poner en lugar de la pantalla verde
 * Proceso: ciclo que recorre los pixeles y los compara con el color de la pantalla para decidir si remplazarlos o no
 * Salidas: foto original y con en el nuevo fondo
 */import java.awt.Color;
public class CambiarFondo
{
  public static void main(String[] args)
  {
    // creación de objetos Picture
    String ruta = FileChooser.pickAFile();
    Picture original = new Picture(ruta);
    Picture nueva = new Picture(ruta);
    Picture fondo = new Picture(FileChooser.pickAFile());
    
    // creación de objetos Pixel y Color
    Pixel pixelOriginal = null;
    Pixel pixelNuevo = null;
    Color colorNuevo = null;
    Color colorVerde = new Color(119, 218, 92);
    
    // salida
    original.show();
    
    // proceso
    for(int y = 0; y < original.getHeight(); y++)
    {
      for(int x = 0; x < original.getWidth(); x++)
      {
        pixelOriginal = nueva.getPixel(x, y);
        pixelNuevo = fondo.getPixel(x, y);
        colorNuevo = pixelNuevo.getColor();
        if(pixelOriginal.colorDistance(colorVerde) < 90)
        {
          pixelOriginal.setColor(colorNuevo);
        }
      }
    }
    
    // salida
    nueva.show();
  } // fin de main
} // fin de la clase