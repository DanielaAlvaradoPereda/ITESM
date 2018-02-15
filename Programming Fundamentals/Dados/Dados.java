import java.util.Random;
public class Dados
{
    public static void main()
    {
        Random aleatorio = new Random();
        
        int uno = 0;
        int dos = 0;
        int tres = 0;
        int cuatro = 0;
        int cinco = 0;
        int seis = 0;
        int cara = 0;
        
        for(int i = 1; i <= 6000000; i++)
        {
            cara = aleatorio.nextInt(6) + 1;
            
            switch(cara)
            {
                case 1:
                    uno++;
                    break;
                case 2:
                    dos++;
                    break;
                case 3:
                    tres++;
                    break;
                case 4:
                    cuatro++;
                    break;
                case 5:
                    cinco++;
                    break;
                case 6:
                    seis++;
                    break;
            }
        }
        
       System.out.print("1: " + uno +
                        "\n2: " + dos +
                        "\n3: " + tres +
                        "\n4: " + cuatro +
                        "\n5: " + cinco +
                        "\n6: " + seis);
    }
}
