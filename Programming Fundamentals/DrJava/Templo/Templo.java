/**
 * Reconstrucción de imagen de templo griego
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 07/11/16
 * 
 * Entradas: foto de un templo griego con una sección destruída
 * Proceso: copia y refleja la parte correspondiente del templo para cubrir la sección dañada
 * Salidas: imágenes del templo original y restaurado
 */
public class Templo
{
  public static void main(String[] args)
  {
    // entrada
    String ruta = FileChooser.pickAFile();
    
    // creación de objetos Picture a través de la imagen seleccionada
    Picture original = new Picture(ruta);
    Picture reconstruido = new Picture(ruta);
    
    // objetos Pixel para realizar la copia
    Pixel pixelOriginal = null;
    Pixel pixelReconstruido = null;
    
    // salida
    original.show();
    
    // proceso: reflejo y copia
    for(int y = 25; y <= 100; y++)
    {
      for(int x = 65; x <= 270; x++)
      {
        pixelOriginal = original.getPixel(x, y);
        pixelReconstruido = reconstruido.getPixel(original.getWidth() -10 - x, y);
        pixelReconstruido.setColor(pixelOriginal.getColor());
      }
    }
    
    // salida
    reconstruido.show();
  } // fin de main
} // fin de la clase