public class PruebaGenericos {

	 public static void main(String args[]) {
 
            Integer[] intArreglo = { 1, 2, 3, 4, 5 };
            Double[] doubleArreglo = { 1.1, 2.2, 3.3, 4.4 };
            Character[] charArreglo = { 'H', 'O', 'L', 'A' };

            System.out.println("El arreglo de enteros tiene: ");
            imprimeArreglo(intArreglo);   

            System.out.println("\nEl arreglo de doubles tiene: ");
            imprimeArreglo(doubleArreglo);  

            System.out.println("\nEl arreglo de chars tiene: ");
            imprimeArreglo(charArreglo);   
         }

   	public static < E > void imprimeArreglo( E[] arreglo ) {

      for(E elemento : arreglo) {

         System.out.print(elemento + " ");

      }

      System.out.println();

   }
}