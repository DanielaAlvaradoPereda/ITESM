public class Ardilla
{
  public static void main(String args[])
  {
    Sound original = new Sound(FileChooser.pickAFile());
    int longitud = original.getLength();
    Sound ardilla = new Sound(longitud);
    for(int i = 0; i < longitud; i++)
    {
      int valor = original.getSampleValueAt(i);
      if(valor % 2 == 0)
      {
        ardilla.setSampleValueAt(i / 2, valor);
      }
    }
    ardilla.play();
  } 
}