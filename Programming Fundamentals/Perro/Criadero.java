
/**
 * Write a description of class Criadero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Criadero
{
    public static void main(String args[])
    {
        Perro perro1 = new Perro();
        perro1.setRaza("gato");
        
        Perro perro2 = new Perro("gato", 0, true);
        
        System.out.println(perro1.equals(perro2));
    }
}
