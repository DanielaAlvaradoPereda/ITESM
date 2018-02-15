public class Clip
{
  public static void main(String args[])
  {
    Sound original = new Sound(FileChooser.getMediaPath("thisisatest.wav"));
    int inicio = 15800;
    int fin = 27300;
    Sound clip = new Sound(original.getLength() - inicio - fin + 1);
    for(int i = 0; i < inicio; i++)
    {
      int valor = original.getSampleValueAt(i);
      clip.se
    }
  }
}