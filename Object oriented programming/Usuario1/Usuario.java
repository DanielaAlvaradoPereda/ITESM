public class Usuario
{
	// atributos
    private String nombre;
    private String apellido;
    private String cuenta;
    private String clave;
    
    // constructores
    public Usuario(String nombre, String apellido, String cuenta, String clave)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuenta = cuenta;
        this.clave = clave;
    }

    // sets y gets
    public void setNombre(String nombre)
    {
    	this.nombre = nombre;
    }
    public void setApellido(String apellido)
    {
    	this.apellido = apellido;
    }
    public void setCuenta(String cuenta)
    {
    	this.cuenta = cuenta;
    }
    public void setClave(String clave)
    {
    	this.clave = clave;
    }
    public String getNombre()
    {
    	return nombre;
    }
    public String getApellido()
    {
    	return apellido;
    }
    public String getCuenta()
    {
    	return cuenta;
    }
    public String getClave()
    {
    	return clave;
    }

    // metodos varios
    public String getNombreCompleto()
    {
        return String.format("%s %s", nombre, apellido);
    }
    public String getNombreInverso()
    {
        return String.format("%s %s", apellido, nombre);
    }
    public String getNombreCuenta()
    {
        return String.format("%s %s", nombre, cuenta);
    }
}