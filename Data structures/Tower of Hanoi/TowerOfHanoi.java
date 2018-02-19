import java.util.Scanner;

public class TowerOfHanoi
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.printf(steps(5, 1, 3, 2));
	}

	public static String steps(int disks, int source, int dest, int temp)
	{
		if(disks == 1)
		{
			return String.format("Move top disk from tower %d to tower %d%n", source, dest);
		}
		return steps(disks - 1, source, temp, dest) + steps(1, source, dest, temp) + steps(disks - 1, temp, dest, source);
	}
}