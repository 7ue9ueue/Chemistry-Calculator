package operator;

import java.io.*;
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
}
