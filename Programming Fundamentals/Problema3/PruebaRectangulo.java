/**
 * Probador para las clases del problema 3 del examen final
 * 
 * @author Ignacio Cabral Perdomo  
 * @version examen final agosto 2016
 */
public class PruebaRectangulo
{
    public static void main()
    {
        // Se crean dos rectángulos
        Punto p1 = new Punto(5,5);
        Punto p2 = new Punto(20,15);
        Rectangulo r1 = new Rectangulo(p1, p2);
        System.out.println("El rectángulo 1 está en: ");
        r1.print();
        
        Punto p3 = new Punto(25,7);
        Punto p4 = new Punto(32,12);
        Rectangulo r2 = new Rectangulo(p3, p4);
        System.out.println("El rectángulo 2 está en: ");
        r2.print();
        
        System.out.println("¿Está r2 dentro de r1? " + r1.dentro(r2));
        
        // se mueve a r2 un diferencial dx y dy y se prueba si ahora está dentro de r1
        r2.mover(-16, 0);
        System.out.println("\nDespués de moverlos, r1 y r2 están en: ");
        System.out.println("El rectángulo 1 está en: ");
        r1.print();
        System.out.println("El rectángulo 2 está en: ");
        r2.print();
        System.out.println("¿Está r2 dentro de r1? " + r1.dentro(r2));
        
        System.out.println("\nEl área del rectángulo 1 es: " + r1.area() + " unidades cuadradas.");
        System.out.println("\nEl área del rectángulo 2 es: " + r2.area() + " unidades cuadradas.");
    }
}