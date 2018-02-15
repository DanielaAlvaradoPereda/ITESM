/*
 * Daniela Alvarado Pereda A01329233
 * 14/09/2017
 * This class represents a fraction as an object.
 */
public class Fraction implements Comparable<Fraction>{
	// attributes
	private int num;
	private int den;

	// constructors
	public Fraction(){
		this.num = 1;
		this.den = 1;
	}
	public Fraction(int num){
		this.num = num;
		den = 1;
	}
	public Fraction(int num, int den){
		this.num = num;
		this.den = den;
	}

	// sets and gets
	public void setNum(int num){
		this.num = num;
	}
	public void setDen(int den){
		this.den = den;
	}
	public int getNum(){
		return num;
	}
	public int getDen(){
		return den;
	}

	// other methods
	public Fraction add(Fraction other){
		int num;
		int den;

		if(this.den == other.den){
			num = this.num + other.num;
			den = this.den;
		}
		else{
			num = other.den * this.num + this.den * other.num;
			den = this.den * other.den;
		}

		Fraction sum = new Fraction(num, den);
		sum.simplify();
		return sum;
	}
	public Fraction mul(Fraction other){
		int num = this.num * other.num;
		int den = this.den * other.den;

		Fraction mul = new Fraction(num, den);
		mul.simplify();
		return mul;
	}
	public void simplify(){
		int gcd = num;
		int mod = den;

		while(mod != 0){
			int temp = gcd % mod;
			gcd = mod;
			mod = temp;
		}

		num /= gcd;
		den /= gcd;
	}
	public String toString(){
		return String.format("%d/%d", num, den);
	}
	public String toString(int n){
		return String.format("%" + n + "d/%" + n + "d", num, den);
	}
	public int compareTo(Fraction o){
		int den = this.den * o.den;
		int num1 = o.den * num;
		int num2 = this.den * o.num;

		return (num1 > num2 ? 1 : (num1 == num2 ? 0 : -1));
	}
}