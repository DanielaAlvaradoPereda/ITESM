/**
 * Este programa permite al usuario simular un juego de Craps
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 17/10/16
 * 
 * Entradas: Apuestas del usuario o valor centinela
 * Proceso: Simulación del juego
 * Salidas: Indica si el usuario gana o pierde y su saldo
 */
import java.util.Scanner;
public class Craps
{
    // creación de variable de saldo inicial
    private static double saldo = 1000;
    public static void main(String args[])
    {
        // creación de Scanner
        Scanner entrada = new Scanner(System.in);
        
        // apuesta inicial y validación
        System.out.print("Su saldo inicial es " + saldo + ", ingrese su apuesta o -1 para terminar: ");
        double apuesta = entrada.nextDouble();
        while(validarApuesta(apuesta))
        {
            System.out.print("Ingrese una apuesta valida: ");
            apuesta = entrada.nextDouble();
        }
        
        // loop de juego
        while(apuesta != -1 && saldo > 0)
        {
            // declaración de variables
            boolean gano = false;
            int punto = 0;
            int suma = tirarDados();
            
            // tiro inicial
            switch(suma)
            {
                case 7:
                case 11:
                    gano = true;
                    break;
                case 2:
                case 3:
                case 12:
                    gano = false;
                    break;
                default:
                    punto = suma;
                    System.out.println("Su punto es: " + punto);
                    break;
            }
            
            // en caso de no haber ganado o perdido en el primer tiro
            while(punto != 0)
            {
                suma = tirarDados();
                if(suma == punto)
                {
                    gano = true;
                    punto = 0;
                }
                if(suma == 7)
                {
                    gano = false;
                    punto = 0;
                }
            }
            
            // acciones si el usaurio gana o pierde
            if(gano == true)
            {
                saldo += apuesta;
                System.out.println("Ha ganado, su saldo ahora es: " + saldo);
            }
            else
            {
                saldo -= apuesta;
                System.out.println("Ha perdido, su saldo ahora es: " + saldo);
            }
            
            // validacion de saldo y nueva apuesta
            if(saldo != 0)
            {
                System.out.print("Para seguir jugando ingrese su apuesta o ingrese -1 para terminar: ");
                apuesta = entrada.nextDouble();
                while(validarApuesta(apuesta))
                {
                    System.out.print("Ingrese una apuesta valida: ");
                    apuesta = entrada.nextDouble();
                }
            }
        }
        System.out.print("El juego a terminado, su saldo final es: " + saldo);
    }
    
    // metodo para realizar un tiro
    public static int tirarDados()
    {
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        
        int suma = dado1.tirarDado() + dado2.tirarDado();
        
        System.out.println("Ha tirado " + dado1.getCara() + " + " + dado2.getCara() + " = " + suma);
        return suma;
    }
    
    // metodo para validar la apuesta
    public static boolean validarApuesta(double apuesta)
    {
        if((apuesta <= saldo && apuesta > 0) || apuesta == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
