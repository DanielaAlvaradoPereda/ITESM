import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class Busqueda
{
	public static void main(String[] args)
	{
		ArrayList<Integer> aInteger = new ArrayList<Integer>(Arrays.asList(7, 2, 3, 4, 7));
		ArrayList<Double> aDouble = new ArrayList<Double>(Arrays.asList(1.7, 8.42, 7.49, 1.33, 5.96, 9.78, 2.29, 1.11));
		ArrayList<String> aString = new ArrayList<String>(Arrays.asList("linda", "atun", "dragon", "salsa", "papas", "trasero"));
		ArrayList<Integer> cInteger1 = new ArrayList<Integer>(Arrays.asList(8, 2, 3, 4, 7));
		ArrayList<Integer> cInteger2 = new ArrayList<Integer>(Arrays.asList(2, 5, 3, 7));
		ArrayList<Double> cDouble = new ArrayList<Double>(Arrays.asList(3.4, 8.42, 9.47, 1.31));
		ArrayList<String> cString = new ArrayList<String>(Arrays.asList("bebe", "kezo", "volapapa", "pinguino"));



		System.out.printf("%d%s se encuentra en aInteger%n", 5, buscar(aInteger, 5) ? "" : " no");
		System.out.printf("%.2f%s se encuentra en aDouble%n", 5.96, buscar(aDouble, 5.96) ? "" : " no");
		System.out.printf("%s%s se encuentra en aString%n%n", "atun", buscar(aString, "atun") ? "" : " no");

		System.out.printf("%d se encuentra en aInteger %d veces%n", 7, contar(aInteger, 7));
		System.out.printf("%.2f se encuentra en aDouble %d veces%n", 3.23, contar(aDouble, 3.23));
		System.out.printf("%s se encuentra en aString %d veces%n%n", "atun", contar(aString, "atun"));

		System.out.printf("aInteger%s es un conjunto%n", esConjunto(aInteger) ? "" : " no");
		System.out.printf("aDouble%s es un conjunto%n", esConjunto(aDouble) ? "" : " no");
		System.out.printf("aString%s es un conjunto%n%n", esConjunto(aString) ? "" : " no");

		System.out.printf("Interseccion entre cInteger1 y cInteger2: %s%n", interseccion(cInteger1, cInteger2));
		System.out.printf("Interseccion entre aDouble y cDouble: %s%n", interseccion(aDouble, cDouble));
		System.out.printf("Interseccion entre aString y cString: %s%n%n", interseccion(aString, cString));

		System.out.printf("Diferencia de cInteger1 y cInteger2: %s%n", diferencia(cInteger1, cInteger2));
		System.out.printf("Diferencia de aDouble y cDouble: %s%n", diferencia(aDouble, cDouble));
		System.out.printf("Diferencia de aString y cString: %s%n", diferencia(aString, cString));
	}
	public static <T> boolean buscar(Collection<T> coleccion, T activo)
	{
		for(T elemento : coleccion)
		{
			if(elemento.equals(activo))
			{
				return true;
			}
		}
		return false;
	}
	public static <T> int contar(Collection<T> coleccion, T activo)
	{
		int contador = 0;
		for(T elemento : coleccion)
		{
			if(elemento.equals(activo))
			{
				contador++;
			}
		}
		return contador;
	}
	public static <T> boolean esConjunto(Collection<T> coleccion)
	{
		for(T elemento : coleccion)
		{
			if(contar(coleccion, elemento) > 1)
			{
				return false;
			}
		}
		return true;
	}
	public static <T extends Comparable<T>> ArrayList<T> union(ArrayList<T> conjunto1, ArrayList<T> conjunto2)
	{
		ArrayList<T> union = new ArrayList<T>();
		for(T elemento1 : conjunto1)
		{
			union.add(elemento1);
		}
		for(T elemento2 : conjunto2)
		{
			for(T elementoUnion : union)
			{
				if(elemento2.compareTo(elementoUnion != 0))
				{
					union.add(elemento2);
				}
			}
		}
		return union;
	}
	public static <T> ArrayList<T> interseccion(Collection<T> coleccion1, Collection<T> coleccion2)
	{
		ArrayList<T> elementos = new ArrayList<T>();
		for(T elemento : coleccion1)
		{
			if(buscar(coleccion2, elemento))
			{
				elementos.add(elemento);
			}
		}
		return elementos;
	}
	public static <T> ArrayList<T> diferencia(Collection<T> coleccion1, Collection<T> coleccion2)
	{
		ArrayList<T> elementos = new ArrayList<T>();
		for(T elemento : coleccion1)
		{
			if(!buscar(coleccion2, elemento))
			{
				elementos.add(elemento);
			}
		}
		return elementos;
	}
}