public class Complex
{
	private double real;
	private double imag;

	public Complex()
	{
		real = 0.0;
		imag = 0.0;
	}
	public Complex(double a)
	{
		real = a;
		imag = 0.0;
	}
	public Complex(double a, double b)
	{
		real = a;
		imag = b;
	}

	public String toString()
	{
		return (real + " + " + imag + "i");
	}

	public Complex suma(Complex o)
	{
		return new Complex(this.real + o.real);
	}
}