/**
 * Clase para objeto Punto
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 29/11/2016
 */
public class Punto
{
    // campos
    private int x;
    private int y;
    // constructores
    public Punto()
    {
        x = 0;
        y = 0;
    }
    public Punto(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    // sets y gets
    public void setX (int x)
    {
        this.x = x;
    }
    public void setY (int y)
    {
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    // metodos varios
    public double distancia(Punto p)
    {
        double distancia = Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
        return distancia;
    }
    public void print()
    {
        System.out.printf("(%d, %d)%n", x, y);
    } // fin de print
} // fin de la clase
