/**
 * Este programa invierte la segunda mitad de un audio
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 29/11/2016
 * 
 * Entradas: audio original
 * Proceso: loop invierte la mitad del audio
 * Salidas: audio invertido
 */
public class InvierteMitad
{
  public static void main(String[] args)
  {
    // entrada
    String ruta = FileChooser.pickAFile();
    Sound original = new Sound(ruta);
    Sound invertido = new Sound(ruta);
    // cálculo de la mitad
    int mitad = original.getLength() / 2 - 1;
    // salida
    original.blockingPlay();
    // proceso
    for(int i = 0; i <= mitad; i++)
    {
      int valor = original.getSampleValueAt(original.getLength() - i - 1);
      invertido.setSampleValueAt(mitad + 1 + i, valor);
    }
    // salida
    invertido.play();
  } // fin del for
} // fin de la clase