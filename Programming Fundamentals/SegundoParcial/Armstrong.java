/**
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 28/10/16
 */
public class Armstrong
{
    public static void main(String args[])
    {
        for(int i = 1; i < 9999; i++)
        {
            int numero = i;
            int suma = 0;
            while(numero > 0)
            {
                suma += Math.pow(numero % 10, 3);
                numero /= 10;
            }
            if(suma == i)
                System.out.println("El valor " + i + " si es un número de Armstrong");
        }
    }
}
