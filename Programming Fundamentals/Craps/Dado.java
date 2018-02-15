import java.util.Random;
public class Dado
{
    // atributos de la clase
    Random aleatorio = new Random();
    private int cara;
    
    // constructor
    public Dado()
    {
        cara = aleatorio.nextInt(6) + 1;
    }
    // get
    
        public int getCara()
    {
        return cara;
    }
    
    // metodos varios
    public int tirarDado()
    {
        cara = aleatorio.nextInt(6) + 1;
        return cara;
    }
}
