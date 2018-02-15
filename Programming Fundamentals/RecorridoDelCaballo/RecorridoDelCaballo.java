/**
 * Este programa realiza el recorrido del caballo propuesto por Euler a partir de una posición inicial proporcionada por el usuario
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 22/11/16
 * 
 * Entradas: fila y columna inicial, ambos enteros entre 0 y 7
 * Proceso: recorrido del caballo mediante heurística de accesibilidad
 * Salidas: un tablero por cada movimiento hecho por el caballo
 */
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
public class RecorridoDelCaballo
{
	// variables de clase
    private static int tablero[][] = new int[8][8];
    private static final int vertical[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int horizontal[] = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int accesibilidad[][] = {{2, 3, 4, 4, 4, 4, 3, 2},
                                            {3, 4, 6, 6, 6, 6, 4, 3},
                                            {4, 6, 8, 8, 8, 8, 6, 4},
                                            {4, 6, 8, 8, 8, 8, 6, 4},
                                            {4, 6, 8, 8, 8, 8, 6, 4},
                                            {4, 6, 8, 8, 8, 8, 6, 4},
                                            {3, 4, 6, 6, 6, 6, 4, 3},
                                            {2, 3, 4, 4, 4, 4, 3, 2}};
    private static int filaActual;
    private static int columnaActual;
    
    public static void main(String args[])
    {
		// creación de Scanner
        Scanner entrada = new Scanner(System.in);
        
		// entradas y validación
        do
        {
            System.out.print("Ingrese una fila de inicio (entero del 0 al 7): ");
            filaActual = entrada.nextInt();
        }while(filaActual < 0 || filaActual >7);
        do
        {
            System.out.print("Ingrese una columna de inicio (entero del 0 al 7): ");
            columnaActual = entrada.nextInt();
        }while(columnaActual < 0 || columnaActual >7);
        
		// inicialización para el recorrido
        tablero[filaActual][columnaActual] = 1;
        accesibilidad[filaActual][columnaActual] = 0;

		// imprimir primer tablero
        imprimirTablero();
        
		// loop para el resto de los movimientos, espera 1 segundo antes de la siguiente iteración
        try
        {
            Thread.sleep(1000);
            for(int i = 2; i <= 64; i++)
            {
                movimiento();
                tablero[filaActual][columnaActual] = i;
                imprimirTablero();
                Thread.sleep(1000);
            }
        } 
        catch (InterruptedException ex){}
    }
	// encuentra el movimiento óptimo siguiente
    public static void movimiento()
    {
        int menor = 9;
        int movimiento = 0;
        for(int i = 0; i < 8; i++)
        {
			// el movimiento no se evalúa si excede el tablero o si ya se pasó por la casilla
            if((filaActual + vertical[i]) < 0 || (filaActual + vertical[i]) > 7 || (columnaActual + horizontal[i]) < 0 || (columnaActual + horizontal[i]) > 7 || 
                accesibilidad[filaActual + vertical[i]][columnaActual + horizontal[i]] == 0)
            {
                continue;
            }
			// si hay empates de accesibilidad se evalúan todos los casos para encontrar el que tenga posibles movimientos a la menor accesibilidad posible
            if(accesibilidad[filaActual + vertical[i]][columnaActual + horizontal[i]] == menor)
            {
                if(encontrarMenor(filaActual + vertical[i], columnaActual + horizontal[i]) < 
                   encontrarMenor(filaActual + vertical[movimiento], columnaActual + horizontal[movimiento]))
                {
                    menor = accesibilidad[filaActual + vertical[i]][columnaActual + horizontal[i]];
                    movimiento = i;
                }
            }
			// la variable "menor" almacena la menor accesbiliada encontrada hasta el momento
            else 
            {
                if(accesibilidad[filaActual + vertical[i]][columnaActual + horizontal[i]] < menor)
                {
                    menor = accesibilidad[filaActual + vertical[i]][columnaActual + horizontal[i]];
                    movimiento = i;
                }
            }
        }
		// modifica accesibilidad y posición actual
        modificarAccesibilidad(movimiento);
        filaActual += vertical[movimiento];
        columnaActual += horizontal[movimiento];
    }
	// método para encontrar el movimiento óptimo en caso de empates
    public static int encontrarMenor(int fila, int columna)
    {
        int menor = 9;
        for(int i = 0; i < 8; i++)
        {
            if((fila + vertical[i]) < 0 || (fila + vertical[i]) > 7 || (columna + horizontal[i]) < 0 || (columna + horizontal[i]) > 7 ||
                accesibilidad[fila + vertical[i]][columna + horizontal[i]] == 0)
            {
                continue;
            }
            if(accesibilidad[fila + vertical[i]][columna + horizontal[i]] < menor)
            {
                menor = accesibilidad[fila + vertical[i]][columna + horizontal[i]];
            }
        }        
        return menor;
    }
	// modifica la accesibilidad después de cada movimiento
    public static void modificarAccesibilidad(int movimiento)
    {
        for(int i = 0; i < 8; i++)
        {
            if((filaActual + vertical[i]) < 0 || (filaActual + vertical[i]) > 7 || (columnaActual + horizontal[i]) < 0 || (columnaActual + horizontal[i]) > 7 || 
                accesibilidad[filaActual + vertical[i]][columnaActual + horizontal[i]] == 0)
            {
                continue;
            }
            if(i == movimiento)
            {
                accesibilidad[filaActual + vertical[i]][columnaActual + horizontal[i]] = 0;
            }
            else
            {
                accesibilidad[filaActual + vertical[i]][columnaActual + horizontal[i]]--;
            }
        }
    }
	// salidas
    public static void imprimirTablero()
    {
        for(int fila[] : tablero)
        {
            for(int casilla : fila)
            {
                System.out.printf("%2d ", casilla);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    } // fin de imprimirTablero
} // fin de la clase