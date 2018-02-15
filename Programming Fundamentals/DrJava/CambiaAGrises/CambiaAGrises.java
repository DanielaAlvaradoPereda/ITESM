/**
 * Convierte una foto a escala de grises haciendo un promedio de la intensidad del color de cada pixel
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 03/11/16
 * 
 * Entradas: imagen original
 * Proceso: asignar a los campos RGB de cada pixel el promedio de la intensidad de su color
 * Salidas: imagen original y en escala de grises
 */
import java.awt.Color;
public class CambiaAGrises
{
  public static void main(String args[])
  {
    // declaración de variables
    int promedio;
    String archivo = FileChooser.pickAFile();
    Picture original = new Picture(archivo);
    Picture copia = new Picture(archivo);
    Pixel pixeles[] = copia.getPixels();
   
    // salida
    original.show();
    
    // proceso
    for( int i = 0; i < pixeles.length; i++ )
    {
      promedio = (pixeles[i].getRed() + pixeles[i].getGreen() + pixeles[i].getBlue()) / 3;
      pixeles[i].setColor(new Color(promedio, promedio, promedio));
    }
    // salida
    copia.show();
  } // fin de main
} // fin de la clase