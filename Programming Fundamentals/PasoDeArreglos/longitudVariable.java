public class longitudVariable
{
    public static void main()
    {
        imprime(1);
        imprime(1, 2, 3, 4, 5, 6);
    }
    public static void imprime(int...valores)
    {
        for(int elem : valores)
            System.out.print(elem);
        System.out.println();
    }
}
