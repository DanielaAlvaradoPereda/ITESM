import java.util.Scanner;
public class Romanos
{
    public static void main()
    {
        for(int i = 1; i <= 3999; i++)
        {
            System.out.println(i + "\t" + romanos(i));
        }
    }
    public static String romanos(int numero)
    {
        // creación de variables
        String romano = "";
        String simbolos[] = {"I", "V", "X", "L", "C", "D", "M"};
        
        // una iteración por cada posición: i = 0 - unidades
                                         // i = 2 - decenas
                                         // i = 4 - centenas
                                         // i = 6 - millares
        for(int i = 0; numero > 0; i += 2)
        {
            if((numero % 10 + 1) % 5 == 0) // si el último dígito de la derecha + 1 es múltiplo de 5
                romano = simbolos[i] + simbolos[(numero % 10 + 1) / 5 + i] + romano; // imprimir unidad + múltiplo de 5 siguiente + romano guardado
            else
            {
                for(int i2 = 1; i2 <= numero % 10 % 5; i2++) // imprimir las unidades sobrantes después del múltiplo de 5
                    romano = simbolos[i] + romano;
                romano = ((numero % 10 / 5) != 0 ? simbolos[i + 1] : "") + romano; // imprimir un 5 si cabe en el número
            }
            numero /= 10; // descartar el último dígito de la derecha
        }
        return romano;
    }
}
