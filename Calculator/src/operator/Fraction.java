package operator;

class Fraction 
{
	public int x;
	public int y;
	Fraction (int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
	Fraction () 
	{
		this.x = 0;
		this.y = 0;
	}
	Fraction (int x) 
	{
		this.x = x;
		this.y = 1;
	}
	private int gcd (int a, int b) 
	{
		a = Math.abs(a);
		b = Math.abs(b);
		if (a<b) 
		{
			int t = a;
			a = b;
			b = t;
		}
		if (b==0) return (int)1e9;
		if (a%b==0) return b;
		else return gcd(a%b,b);
	} 
	void simplify ()
	{
		int d = gcd(x,y);
		x = x/d;
		y = y/d;
	}
	float convert ()
	{
		if (y==0) return 0f;
		else return (float)x/y;
	}
	@Override
	public String toString ()
	{
		float ans = convert();
		return Float.toString(ans);
	}
	boolean equal (Fraction other) 
	{
		other.simplify();simplify();
		if (other.x==x&&other.y==y) return true;
		else return false;
		
	}
	Fraction plus (Fraction other) 
	{
		if (other.x==0||other.y==0) return this;
		if (this.x==0||this.y==0) return other;
		Fraction answer = new Fraction();
		answer.x = other.x*y+other.y*x;
		answer.y = other.y*y;
		answer.simplify();
		return answer;
	}
	Fraction minus (Fraction other) 
	{
		if (other.x==0||other.y==0) return this;
		if (this.x==0||this.y==0) return other.multiply(new Fraction(-1));
		Fraction answer = new Fraction();
		answer.x = other.y*x-other.x*y;
		answer.y = other.y*y;
		answer.simplify();
		return answer;
	}
	Fraction multiply (Fraction other) 
	{
		if (other.x==0||other.y==0) return new Fraction();
		Fraction answer = new Fraction();
		answer.x = other.x*x;
		answer.y = other.y*y;
		answer.simplify();
		return answer;
	}
	Fraction divide (Fraction other) 
	{
		if (other.x==0||other.y==0) 
		{
			System.out.println("Fraction:Divide by zero error");
			return this;
		}
		Fraction answer = new Fraction();
		answer.x = other.y*x;
		answer.y = other.x*y;
		answer.simplify();
		return answer;
	}
} 
