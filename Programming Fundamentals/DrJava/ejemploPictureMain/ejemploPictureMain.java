import java.awt.Color;
public class ejemploPictureMain
{
  public static void main(String[] args)
  {
    Picture foto = new Picture(FileChooser.pickAFile());
    foto.show();
    Pixel pixeles[] = foto.getPixels();
    
    for(int i = 0; i < pixeles.length; i++)
    {
      pixeles[i].setColor(Color.BLACK);
    }
    foto.repaint();
  }
}