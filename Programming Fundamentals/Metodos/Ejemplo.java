
/**
 * Write a description of class Ejemplo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejemplo
{
    private static int objetosCreados;
    
    public Ejemplo()
    {
        objetosCreados++;
    }
    
    public static int getObjetosCreados()
    {
        return objetosCreados;
    }
}
