/**
 * Clase para objeto Rectangulo
 * 
 * @author Daniela Alvarado Pereda A01329233
 *         Ricardo Hernández Morales A01329376
 *         Miguel Ángel López Muñoz A01327503
 * @version 29/11/2016
 */
public class Rectangulo
{
    // campos
    private Punto a;
    private Punto b;
    // constructor
    public Rectangulo(Punto a, Punto b)
    {
        this.a = a;
        this.b = b;
    }
    // sets y gets
    public void setA(Punto a)
    {
        this.a = a;
    }
    public void setB(Punto b)
    {
        this.b = b;
    }
    public Punto getA()
    {
        return a;
    }
    public Punto getB()
    {
        return b;
    }
    // metodos varios
    public int alto()
    {
        return b.getY() - a.getY();
    }
    public int ancho()
    {
        return b.getX() - a.getX();
    }
    public int area()
    {
        return alto() * ancho();
    }
    public void mover(int dx, int dy)
    {
        a.setX(a.getX() + dx);
        a.setY(a.getY() + dy);
        b.setX(b.getX() + dx);
        b.setY(b.getY() + dy);
    }
    public boolean dentro(Rectangulo r)
    {
        Punto esquinaA = r.getA();
        Punto esquinaB = r.getB();
        
        if(esquinaA.getX() >= a.getX() && esquinaA.getX() <= b.getX() && esquinaA.getY() >= a.getY() && esquinaA.getY() <= b.getY() &&
           esquinaB.getX() >= a.getX() && esquinaB.getX() <= b.getX() && esquinaB.getY() >= a.getY() && esquinaB.getY() <= b.getY())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void print()
    {
        a.print();
        b.print();
    } // fin de print
} // fin de la clase
