public class Factura
{
    // atributos de la clase
    private String numero;
    private String descripcion;
    private int cantidad;
    private double precio;
    
    // constructor de la clase
    public Factura(String numeroDePieza, String descripcion, int cantidad, double precio)
    {
        this.numero = numero;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    // sets y gets de la clase
    public void establecerNumero(String numero)
    {
        this.numero = numero;
    }
    public void establecerDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
    public void establecerCantidad(int cantidad)
    {
        if(cantidad>0)
            this.cantidad = cantidad;
        else
            this.cantidad = 0;
    }
    public void establecerPrecio(double precio)
    {
        if(precio>0)
            this.precio = precio;
        else
            this.precio = 0;
    }
    public String obtenerNumero()
    {
        return numero;
    }
    public String obtenerDescripcion()
    {
        return descripcion;
    }
    public int obtenerCantidad()
    {
        return cantidad;
    }
    public double obtenerPrecio()
    {
        return precio;
    }
    
    // metodos varios, otener monto
    public double obtenerMontoFactura()
    {
        double monto = precio * cantidad;
        return monto;
    }
} // fin de la clase