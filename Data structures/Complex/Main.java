public class Main
{
	public static void main(String[] args)
	{
		Complex[] arrC = new Complex[3];

		arrC[0] = new Complex(4, 1);
		arrC[1] = new Complex();
		arrC[2] = new Complex(5);

		for(int i = 0; i < 3; i++)
		{
			System.out.println("arr[" + i + "] = " + arrC[i]);
		}
	}
}