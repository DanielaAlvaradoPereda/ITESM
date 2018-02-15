/*
 * Este programa demuestra un metodo de union de conjuntos.
 * 
 * Daniela Alvarado Pereda A01329233
 *
 * 05/05/17
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Final
{
	// para probar metodo union
	public static void main(String[] args)
	{
		// arreglos de Integer
		ArrayList<Integer> cInteger1 = new ArrayList<Integer>(Arrays.asList(4, 1, 3));
		ArrayList<Integer> cInteger2 = new ArrayList<Integer>(Arrays.asList(5, 1, 4, 7));

		// areglos de String
		ArrayList<String> cString1 = new ArrayList<String>(Arrays.asList("rojo", "azul", "verde", "morado", "negro"));
		ArrayList<String> cString2 = new ArrayList<String>(Arrays.asList("verde", "rosa", "naranja", "azul", "amarillo", "morado"));

		// pruebas de metodo union para Integer y String 
		System.out.printf("La union de %s y %s es %s%n", cInteger1, cInteger2, union(cInteger1, cInteger2));
		System.out.printf("La union de %s y %s es %s%n", cString1, cString2, union(cString1, cString2));
	}
	// calcula la union de dos conjuntos
	public static <T extends Comparable<T>> ArrayList<T> union(ArrayList<T> conjunto1, ArrayList<T> conjunto2)
	{
		// arreglo que guarda la union
		ArrayList<T> union = new ArrayList<T>();
		// agregar a union todos los elemento del primer conjunto
		for(T elemento1 : conjunto1)
		{
			union.add(elemento1);
		}
		// agregar a union los elementos del segundo conjunto que no esten en el primero
		for(T elemento2 : conjunto2)
		{
			boolean existe = false;
			for(T elemento1 : conjunto1)
			{
				if(elemento2.compareTo(elemento1) == 0)
				{
					existe = true;
				}
			}
			if(!existe)
			{
				union.add(elemento2);
			}
		}
		return union;
	} // fin de metodo union
} // fin de clase Final