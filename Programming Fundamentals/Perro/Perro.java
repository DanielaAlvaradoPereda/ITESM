public class Perro
{
    // atributos de la clase
    private String raza;
    private int edad;
    private boolean cola;
    
    // métodos constructores
    // constructor por default
    public Perro()
    {
        raza = null;
        edad = 0;
        cola = true;
    }
    
    // constructor con parámetro
    public Perro(String raza, int edad, boolean cola)
    {
        this.raza = raza;
        this.edad = edad;
        this.cola = cola;
    }
    
    // métodos set y get
    public void setRaza(String raza)
    {
        this.raza = raza;
    }
    public void setEdad(int edad)
    {
        this.edad = edad;
    }
    public void setCola(boolean cola)
    {
        this.cola = cola;
    }
    public String getRaza()
    {
        return raza;
    }
    public int getEdad()
    {
        return edad;
    }
    public boolean getCola()
    {
        return cola;
    }
    
    // métodos varios
    public void ladra()
    {
        System.out.println("Guau-guau");
    }
    public void corteDeCola()
    {
        if(cola == true)
        {
            setCola(false);
        }
    }
    
    public String toString()
    {
        return "[" + raza + ", " + edad + ", " + cola + "]";
    }
    public boolean equals(Perro otro)
    {
        if((raza).equals(otro.getRaza()) && edad == otro.getEdad())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
} // fin de la clase