/**
 * Este programa corta la palabra "is" de un audio que dice "this is a test"
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Miguel �ngel L�pez Mu�oz A01327503
 * @version 22/11/16
 * 
 * Entradas: audio original
 * Proceso: dos loops que copian las partes que se conservar�n a un nuevo clip
 * Salidas: audio con la palabra "is" recortada
 */
public class Clip
{
  public static void main(String args[])
  {
    Sound original = new Sound(FileChooser.pickAFile());
    int inicio = 15800;
    int fin = 27300;
    Sound clip = new Sound(original.getLength() - (fin - inicio + 1));
    for(int i = 0; i < inicio; i++)
    {
      int valor = original.getSampleValueAt(i);
      clip.setSampleValueAt(i, valor);
    }
    for(int i = fin + 1; i < original.getLength(); i++)
    {
      int valor = original.getSampleValueAt(i);
      clip.setSampleValueAt(inicio + i - fin -1, valor);
    }
    clip.play();
  }
}