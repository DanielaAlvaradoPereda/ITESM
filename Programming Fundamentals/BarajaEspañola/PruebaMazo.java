/**
 * Este programa simula reaprtir las cartas de una baraja española
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 17/10/16
 * 
 * Entradas: Ninguna
 * Proceso: Reparte las cartas con el metodo repartirCarta()
 * Salidas: Nombres de las cartas repartidas en orden aleatorio
 */
public class PruebaMazo
{
   public static void main(String args[])
   {
      Mazo miMazo = new Mazo();
      miMazo.mezclar();
      for (int i = 0; i < 12; i++)
      {
         System.out.printf( "%-20s%-20s%-20s%-20s\n", miMazo.repartirCarta(), miMazo.repartirCarta(),  
                            miMazo.repartirCarta(), miMazo.repartirCarta());
      }
   }
}