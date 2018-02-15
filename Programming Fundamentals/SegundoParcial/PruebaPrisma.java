/**
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 28/10/16
 */
public class PruebaPrisma
{
    public static void main(String args[])
    {
        Prisma prisma1 = new Prisma();
        Prisma prisma2 = new Prisma();
        Prisma prisma3 = new Prisma();
        
        prisma1.setLargo(4);
        prisma2.setLargo(10);
        
        System.out.print("El prisma 1 tiene:" +
                           "\nLargo: " + prisma1.getLargo() + 
                           "\nAncho: " + prisma1.getAncho() + 
                           "\nAltura: " + prisma1.getAltura() + 
                           "\nMasa: " + prisma1.getMasa());
        System.out.print("\n\nEl prisma 2 tiene:" +
                           "\nLargo: " + prisma2.getLargo() + 
                           "\nAncho: " + prisma2.getAncho() + 
                           "\nAltura: " + prisma2.getAltura() + 
                           "\nMasa: " + prisma2.getMasa());
        System.out.print("\n\nEl prisma 3 tiene:" +
                           "\nLargo: " + prisma3.getLargo() + 
                           "\nAncho: " + prisma3.getAncho() + 
                           "\nAltura: " + prisma3.getAltura() + 
                           "\nMasa: " + prisma3.getMasa());
    }
}
