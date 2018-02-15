import java.util.Scanner;
import java.util.Random;
public class HighLow
{
    public static void main(String[] args)
    {
        // creación de objeto scanner y random, declaración de variables
        Random random1 = new Random();
        Scanner entrada = new Scanner(System.in);
        int x = random1.nextInt(100) + 1;
        int contador = 1;
        int respuesta = 0;
        int jugar = 1;
        
        // ciclo para repetir el juego
        while(jugar == 1)
        {
            // reinicio de variables
            x = random1.nextInt(100) + 1;
            contador = 1;
            respuesta = 0;
            System.out.println("El programa ha elegido un número aleatorio, tiene 6 oportunidades para adivinarlo");
            
            // ciclo para comparar con seis oportunidades
            while(contador <= 6 && respuesta != x)
            {
               System.out.println("Ingrese un número para su oportunidad número " + contador);
               respuesta = entrada.nextInt();
               if(respuesta == x)
               {
                   System.out.println("Felicidades! Encontró al número secreto en " + contador + " intentos");
               }
               if(respuesta > x)
               {
                   System.out.println("El número ingresado es mayor, quedan " + (6 - contador) + " oportunidades");
               }
               if(respuesta < x) 
               {
                   System.out.println("El número ingresado es menor, quedan " + (6 - contador) + " oportunidades");
               }
               contador++;
            }
            // si el usuario pierde
            if(respuesta != x)
            {
                System.out.println("Perdiste! El número secreto era " + x);
            }
            // preguntar si se desea volver a jugar
            System.out.println("Si desea volver a jugar ingrese 1, si no desea volver a jugar ingrese 2");
            jugar = entrada.nextInt();
        } // fin del while
    } // fin de main
} // fin de la clase
