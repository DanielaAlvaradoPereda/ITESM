public class PasoDeArreglos
{
    public static void main(String args[])
    {
        int miArreglo[] = {1, 2, 3, 4, 5};
        duplicaArreglo(miArreglo);
        
        for(int elemento : miArreglo)
            System.out.println(elemento);
    }
    public static void duplicaArreglo(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] *= 2;
        }
    }
}
