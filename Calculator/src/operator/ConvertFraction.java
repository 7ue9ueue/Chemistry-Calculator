package operator;

import java.util.ArrayList;

public class ConvertFraction 
{
	public static int GCD (int a, int b) 
	{
		a = Math.abs(a);
		b = Math.abs(b);
		if (a<b) 
		{
			int t = a;a = b;b = t;
		}
		if (b==0) return -1;
		if (a%b==0) return b;
		else return GCD(a%b,b);
	} 
	public static int LCM (int a, int b)
	{
		return Math.abs(a*b/GCD(a,b));
	}
	public static ArrayList<Integer> solve (ArrayList<Fraction> Fractions)
	{
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int lcm = 1;
		for (int i=0;i<Fractions.size();i++)
		{
			answer.add(Fractions.get(i).x);
			lcm = LCM(lcm,Fractions.get(i).y);
		}
		for (int i=0;i<Fractions.size();i++)
		{
			answer.set(i,answer.get(i)*lcm/Fractions.get(i).y);
		}
		return answer;
	}

}
