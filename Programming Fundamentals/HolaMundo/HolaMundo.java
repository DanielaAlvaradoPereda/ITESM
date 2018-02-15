public class HolaMundo
{
    public static void main(String args[])
    {
        System.out.println("Hola mundo");
    } // fin de main
} // fin de la clase
import java.util.Scanner;
public class Romanos
{
    public static void main(String args[])
    {
        Scanner entrada = new Scanner(System.in);
        int numero = entrada.nextInt();
        int num =  0;
        int posicion = 1;
    
        while(numero > 0)
        {
            num = numero % 10;
            numero /= 10;
            posicion++;
            System.out.print(num);
            System.out.print(posicion);
        }
    }
}