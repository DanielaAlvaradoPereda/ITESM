
/**
 * Clase PruebaFrecuenciasCardiacas que prueba la clase FrecuenciasCardiacas
 * Problema 3 del primer parcial agosto-diciembre de 2016
 *
 * @author Ignacio Cabral Perdomo
 * @version 1.0
 */
public class PruebaFrecuenciasCardiacas
{
   public static void main(String args[])
   {
       FrecuenciasCardiacas frecuencia = new FrecuenciasCardiacas("Juan","López",54);

       System.out.println("Los datos de la persona son: " + frecuencia.toString());
       System.out.println("Su frecuencia cardiaca máxima es: " + frecuencia.calculaFrecuenciaMaxima());
       System.out.println("Su frecuencia cardiaca esperada es: " + frecuencia.calculaFrecuenciaEsperada());

    }
}
