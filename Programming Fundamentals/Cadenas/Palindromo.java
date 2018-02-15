import java.util.Scanner;
public class Palindromo
{
    public static void main(String args[])
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese una frase:");
        String cad1 = entrada.nextLine();
        
        StringBuilder cadena = new StringBuilder(minusculas(quitarEspacios(cad1)));
        StringBuilder invertida = new StringBuilder (cadena);
        invertida = invertida.reverse();
        
        System.out.println(cadena);
        System.out.println(invertida);
        
        if(cadena.equals(invertida))
        {
            System.out.println("La frase es un palíndromo");
        }
        else
        {
            System.out.println("La frase no es un palíndromo");
        }
    }
    public static String quitarEspacios(String cadena)
    {
        
        return cadena.replaceAll("\\s+","");
    }
    public static String minusculas(String cadena)
    {
        
        return cadena.toLowerCase();
    }
}
