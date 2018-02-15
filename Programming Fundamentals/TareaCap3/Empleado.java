public class Empleado
{
    // atributos de la clase
    private String nombre;
    private String apellido;
    private double salario;
    
    // constructor de la clase
    public Empleado(String nombre, String apellido, double salario)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        if(salario>0)
            this.salario = salario;
    }
    
    // sets y gets de la clase
    public void establecerNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void establecerApellido(String apellido)
    {
        this.apellido = apellido;
    }
    public void establecerSalario(double salario)
    {
        if(salario>0)
            this.salario = salario;
    }
    public String obtenerNombre()
    {
        return nombre;
    }
    public String obtenerApellido()
    {
        return apellido;
    }
    public double obtenerSalario()
    {
        return salario;
    }
    
    // metodos varios, aumento de salario
    public double salarioAnual()
    {
        return salario * 12;
    }
    public void aumentoDiez()
    {
        salario = salario + (salario*0.1);
    }
} // fin de la clase