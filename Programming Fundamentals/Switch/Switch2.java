/**
 * Write a description of class Switch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Switch2
{
    public static void main()
    {
        String dia;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese día de la semana en mayúsculas y sin acentos: ");
        dia = entrada.nextLine();
        
        switch(dia)
        {
            case "DOMINGO":
                System.out.println("Es el día 1");
                break;
            case "LUNES":
                System.out.println("Es el día 2");
                break;
            case "MARTES":
                System.out.println("Es el día 3");
                break;
            case "MIERCOLES":
                System.out.println("Es el día 4");
                break;
            case "JUEVES":
                System.out.println("Es el día 5");
                break;
            case "VIERNES":
                System.out.println("Es el día 6");
                break;
            case "SABADO":
                System.out.println("Es el día 7");
                break;
            default:
                System.out.println("El número ingresado no es válido para un día de la semana");
                break;
        } // fin de switch
    } // fin de main
} // fin de la clase