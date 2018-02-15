public class FrecuenciasCardiacas
{
    // atributos de la clase
    private String nombre;
    private String apellido;
    private int edad;
    
    // constructor de la clase
    public FrecuenciasCardiacas(String nombre, String apellido, int edad)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    
    // sets y gets de la clase
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    public void setEdad(int edad)
    {
        this.edad = edad;
    }
    public String getNombre()
    {
        return nombre;
    }
    public String getApellido()
    {
        return apellido;
    }
    public int getEdad()
    {
        return edad;
    }
    
    // toString
    public String toString()
    {
        return "[" + nombre + ", " + apellido + ", " + edad + "]";
    }
    
    // metodos varios, calcular frecuencia cardiaca máxima y esperada
    public int calculaFrecuenciaMaxima()
    {
        return 220 - edad;
    }
    public double calculaFrecuenciaEsperada()
    {
        return (220 - edad) * 0.65;
    }
}