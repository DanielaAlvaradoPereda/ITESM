/**
 * Este programa muestra varias estadísiticas de 1000000 de simulaciones de una partida de Craps
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 31/10/16
 * 
 * Entradas: ninguna
 * Proceso: simulación de partidas y acumulación de frecuencias
 * Salidas: estadísticas de la simulación
 */
import java.util.Random;
public class EstadisticasCraps
{
   private static final Random aleatorio = new Random();
   private enum Estado {CONTINUA, GANO, PERDIO};
   private static final int DOS = 2;
   private static final int TRES = 3;
   private static final int SIETE = 7;
   private static final int ONCE = 11;
   private static final int DOCE = 12;
  
   private static int[] contadores = new int[10]; // 0: tiros
                                                  // 1: ganadas
                                                  // 2: ganadas en el primer tiro
                                                  // 3: ganadas en el segundo tiro
                                                  // 4: ganadas en el vigésimo tiro
                                                  // 5: ganadas después del vigésimo tiro
                                                  // 6: perdidas en el primer tiro
                                                  // 7: perdidas en el segundo tiro
                                                  // 8: perdidas en el vigésimo tiro
                                                  // 9: perdidas después del vigésimo tiro
   public static void main(String[] args)
   {
       // proceso
       for(int i = 1; i <= 1000000; i++)
       {
           Craps();
       }
       
       // salida
       System.out.print("Juegos ganados en el primer tiro: " + contadores[2] +
                        "\nJuegos ganados en el segundo tiro: " + contadores[3] +
                        "\nJuegos ganados en el vigésimo tiro: " + contadores[4] +
                        "\nJuegos ganados después del vigésimo tiro: " + contadores[5] +
                        "\nJuegos perdidos en el primer tiro: " + contadores[6] +
                        "\nJuegos perdidos en el segundo tiro: " + contadores[7] +
                        "\nJuegos perdidos en el vigésimo tiro: " + contadores[8] +
                        "\nJuegos perdidos después del vigésimo tiro: " + contadores[9] +
                        "\nProbabilidad de ganar: " + (contadores[1] / 1000000.0 * 100) + "%" +
                        "\nDuración promedio de un juego: " + (contadores[0] / 1000000.0) + " turnos");
   }
   public static void Craps()
   {
      int punto = 0;
      Estado estadoJuego;

      int suma = tirarDados();

      switch (suma)
      {
         case SIETE:
         case ONCE:
            estadoJuego = Estado.GANO;
            contadores[2]++;
            break;
         case DOS:
         case TRES:
         case DOCE:
            estadoJuego = Estado.PERDIO;
            contadores[6]++;
            break;
         default:
            estadoJuego = Estado.CONTINUA;
            punto = suma;
            break;
      }

      for(int i = 2; estadoJuego == Estado.CONTINUA; i++)
      {
         suma = tirarDados();

         if (suma == punto)
         {
            estadoJuego = Estado.GANO;
            switch(i)
            {
                case 2:
                    contadores[3]++;
                    break;
                case 20:
                    contadores[4]++;
                    break;
                default:
                    if(i > 20)
                        contadores[5]++;
                    break;
            }
        }else
            if (suma == SIETE)
            {
               estadoJuego = Estado.PERDIO;
               switch(i)
            {
                case 2:
                    contadores[7]++;
                    break;
                case 20:
                    contadores[8]++;
                    break;
                default:
                    if(i > 20)
                        contadores[9]++;
                    break;
            }
            }
      }

      if (estadoJuego == Estado.GANO)
      {
          contadores[1]++;
      }
   }

   public static int tirarDados()
   {
      int dado1 = 1 + aleatorio.nextInt(6);
      int dado2 = 1 + aleatorio.nextInt(6);

      int suma = dado1 + dado2;
      
      contadores[0]++;
      return suma;
   }
}