/**
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 28/10/16
 */
public class Prisma
{
    private final double DENSIDAD = 1.4;
    private double largo;
    private double ancho;
    private double altura;
    
    public Prisma()
    {
        largo = 1;
        ancho = largo * 2;
        altura = largo * 3;
    }
    public void setLargo(double largo)
    {
        this.largo = largo;
        ancho = largo * 2;
        altura = largo * 3;
    }
    public double getLargo()
    {
        return largo;
    }
    public double getAncho()
    {
        return ancho;
    }
    public double getAltura()
    {
        return altura;
    }
    public double getMasa()
    {
        return largo * ancho * altura * DENSIDAD;
    }
}
