public class Positivos
{
  public static void main(String args[])
  {
    int muestra = 0;
    Sound sonido = new Sound(FileChooser.pickAFile());
    SoundSample muestras[] = sonido.getSamples();
    for(int i = 0; i < muestras.length; i++)
    {
      muestra = muestras[i].getValue();
      if(muestra < 0)
      {
        muestras[i].setValue(muestra * -1);
      }
    }
    sonido.play();
  }
}