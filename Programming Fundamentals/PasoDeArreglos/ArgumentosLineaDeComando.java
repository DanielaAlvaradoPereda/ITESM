public class ArgumentosLineaDeComando
{
    public static void main(String args[])
    {
        if(args.length != 0)
            for(String cadena : args)
                System.out.println(Integer.parseInt(cadena));
    }
}