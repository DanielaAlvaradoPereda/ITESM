import java.util.Random;
public class Mazo
{
   // atributos
   private Carta mazo[];
   private int cartaActual;
   private final int NUMERO_DE_CARTAS = 48;
   private Random aleatorio;

   // constructor
   public Mazo()
   {
      String caras[] = {"Ase", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Jota", "Caballo", "Rey"};
      String palos[] = {"Oros", "Copas", "Espadas", "Bastos"};

      mazo = new Carta[NUMERO_DE_CARTAS];
      cartaActual = 0;
      aleatorio = new Random();

      for ( int cuenta = 0; cuenta < mazo.length; cuenta++ ) 
         mazo[cuenta] = new Carta(caras[cuenta % 12 ], palos[cuenta / 12 ] );
   }

   // metodos varios
   public void mezclar()
   {
      cartaActual = 0;

      for (int primera = 0; primera < mazo.length; primera++ ) 
      {
         int segunda =  aleatorio.nextInt(NUMERO_DE_CARTAS);
         Carta temp = mazo[primera];        
         mazo[primera] = mazo[segunda];   
         mazo[segunda] = temp;            
      }
   }
   public Carta repartirCarta()
   {
      if (cartaActual < mazo.length )
         return mazo[cartaActual++];
      else        
         return null;
   }
}