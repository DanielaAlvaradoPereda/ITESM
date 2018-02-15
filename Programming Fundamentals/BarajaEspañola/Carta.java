public class Carta
{
   // atributos
   private String cara;
   private String palo;
   
   // constructor
   public Carta(String cara, String palo)
   {
      this.cara = cara;
      this.palo = palo;
   }

   // toString
   public String toString() 
   { 
      return cara + " de " + palo;
   }
}