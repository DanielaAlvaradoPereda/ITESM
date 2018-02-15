public class Cuenta
{
    // atributos de la clase
    private String nombre;
    private double saldo;
    
    // constructor de la clase
    public Cuenta(String nombre, double saldo)
    {
        this.nombre = nombre;
        if(saldo > 0.0)
            this.saldo = saldo;
    }
    
    // sets y gets de la clase
    public void establecerNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public double obtenerSaldo()
    {
        return saldo;
    }
    public String obtenerNombre()
    {
        return nombre;
    }
    
    // metodos varios, deposito y retiro
    public void depositar(double montoDeposito)
    {
        if(montoDeposito > 0.0)
            saldo = saldo + montoDeposito;
    }
    public void retirar(double montoRetiro)
    {
        if(montoRetiro<=saldo)
            saldo = saldo - montoRetiro;
        else
            System.out.println("El monto a retirar excede el saldo de la cuenta");
    }
} // fin de la clase