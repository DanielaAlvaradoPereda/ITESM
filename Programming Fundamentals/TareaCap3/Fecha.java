public class Fecha
{
    // atributos de la clase
    private int mes;
    private int dia;
    private int año;
    
    // constructor de la clase
    public Fecha(int mes, int dia, int año)
    {
        this.mes = mes;
        this.dia = dia;
        this.año = año;
    }
    
    // sets y gets de la clase
    public void establecerMes(int mes)
    {
        this.mes = mes;
    }
    public void establecerDia(int dia)
    {
        this.dia = dia;
    }
    public void establecerAño(int año)
    {
        this.año = año;
    }
    public int obtenerMes()
    {
        return mes;
    }
    public int obtenerDia()
    {
        return dia;
    }
    public int obtenerAño()
    {
        return año;
    }
    
    // metodos varios, mostrar fecha
    public String mostrarFecha()
    {
        return (mes + "/" + dia + "/" + año);
    }
} // fin de la clase