package operator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

	public static ArrayList<Integer> solve (int n, ArrayList<String> names) throws IOException {
		ArrayList<Chemical> chemicals = new ArrayList<Chemical>();
		for (int i=0;i<n;i++) 
		{
			String s = names.get(i);
			Chemical c = ConvertChemical.solve(s);
			if (c==null||s.length()==0) 
			{
				System.out.println("ERROR:invalid chemical");
				return null;
			}
			names.add(s);
			chemicals.add(c);
		}
		ArrayList<Integer> answer = new ArrayList<Integer>();
		ArrayList<Fraction> fraction = new ArrayList<Fraction>();
		fraction = BalanceEquation.solve(chemicals);
		if (fraction==null) 
		{
			System.out.println("ERROR:invalid equation");
			return null;
		}
		answer = ConvertFraction.solve(fraction);
		return answer;
	}
	
//	public static void main(String[] args) throws IOException {
//		Scanner cin = new Scanner(System.in);
//		ArrayList<Chemical> chemicals = new ArrayList<Chemical>();
//		ArrayList<String> names = new ArrayList<String>();
//		if (!cin.hasNextInt()) 
//		{
//			System.out.println("ERROR:invalid input");
//			return;
//		}
//		int n = cin.nextInt();
//		for (int i=0;i<n;i++) 
//		{
//			if (!cin.hasNext())
//			{
//				System.out.println("ERROR:invalid input");
//				return;
//			}
//			String s = cin.next();
//			Chemical c = ConvertChemical.solve(s);
//			if (c==null) 
//			{
//				System.out.println("ERROR:invalid chemical");
//				return;
//			}
//			names.add(s);
//			chemicals.add(c);
//		}
//		ArrayList<Integer> answer = new ArrayList<Integer>();
//		ArrayList<Fraction> fraction = new ArrayList<Fraction>();
//		fraction = BalanceEquation.solve(chemicals);
//		if (fraction==null) 
//		{
//			System.out.println("ERROR:invalid equation");
//			return;
//		}
//		answer = ConvertFraction.solve(fraction);
//
//		//Output answer
//		ArrayList<Integer> positive = new ArrayList<Integer>();
//		ArrayList<Integer> negative = new ArrayList<Integer>();
//		
//		for (int i=0;i<n;i++) 
//		{
//			String name = names.get(i);
//			int value = answer.get(i);
//			Fraction test = fraction.get(i);
//			if (value>0) positive.add(i);
//			else negative.add(i);
//			//System.out.println(name+" : "+test);
//		}
//		System.out.println("ANSWER");
//		for (int i=0;i<positive.size();i++) 
//		{
//			int index = positive.get(i);
//			String name = names.get(index);
//			int value = answer.get(index);
//			System.out.print(value+"("+name+") ");
//			if (i!=positive.size()-1) System.out.print("+ ");
//		}
//		System.out.print("= ");
//		for (int i=0;i<negative.size();i++) 
//		{
//			int index = negative.get(i);
//			String name = names.get(index);
//			int value = answer.get(index);
//			System.out.print(-value+"("+name+") ");
//			if (i!=negative.size()-1) System.out.print("+ ");
//		}
//	}
}
/*
3
H2O2
H2O
O2

4
Fe
Al
Al2O3
Fe3O4

4
C2H2
O2
CO2
H2O
*/
