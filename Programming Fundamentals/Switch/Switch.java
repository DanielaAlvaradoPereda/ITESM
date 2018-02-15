/**
 * Write a description of class Switch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Switch
{
    public static void main()
    {
        int dia;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese un número entero entre 1 y 7: ");
        dia = entrada.nextInt();
        
        switch(dia)
        {
            case 1:
                System.out.println("Es domingo");
                break;
            case 2:
                System.out.println("Es lunes");
                break;
            case 3:
                System.out.println("Es martes");
                break;
            case 4:
                System.out.println("Es miércoles");
                break;
            case 5:
                System.out.println("Es jueves");
                break;
            case 6:
                System.out.println("Es viernes");
                break;
            case 7:
                System.out.println("Es sábado");
                break;
            default:
                System.out.println("El número ingresado no es válido para un día de la semana");
                break;
        } // fin de switch
    } // fin de main
} // fin de la clase
