/**
 * Este programa invierte una foto vertical y horizontalmente
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 29/11/2016
 * 
 * Entradas: foto original
 * Proceso: loop que copia los pixeles invertidos
 * Salidas: foto invertida
 */
public class InvierteFoto
{
  public static void main(String[] args)
  {
    // entrada
    String ruta = FileChooser.pickAFile();
    Picture original = new Picture(ruta);
    Picture invertida = new Picture(ruta);
    // salida
    original.show();
    // creacion de objetos Pixel
    Pixel pixelOriginal = null;
    Pixel pixelInvertido = null;
    // proceso
    for(int y = 0; y < original.getHeight(); y++)
    {
      for(int x = 0; x <original.getWidth(); x++)
      {
        pixelOriginal = original.getPixel(original.getWidth() - x - 1, original.getHeight() - y - 1);
        pixelInvertido = invertida.getPixel(x, y);
        pixelInvertido.setColor(pixelOriginal.getColor());
      }
    }
    // salida
    invertida.show();
  } // fin del main
} // fin de la clase