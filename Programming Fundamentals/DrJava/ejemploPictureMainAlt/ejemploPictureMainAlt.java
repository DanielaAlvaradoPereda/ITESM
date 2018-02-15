import java.awt.Color;
public class ejemploPictureMainAlt
{
  public static void main(String[] args)
  {
    Picture foto = new Picture(FileChooser.pickAFile());
    foto.show();
    Pixel pixeles[] = foto.getPixels();
    
    for(int i = 0; i < pixeles.length; i++)
    {
      if(i % 2 == 0)
        pixeles[i].setColor(Color.WHITE);
      else
        pixeles[i].setColor(Color.BLACK);
    }
    foto.repaint();
  }
}