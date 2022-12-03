package operator;
import java.util.*;

public class BalanceEquation 
{
	public final static int MAX_ELEMENT = 118;
	public final static Fraction ZERO = new Fraction(0,0);
	//TRUE = successful
	//BUG negative value?? FIXED: Problem Fraction.java
	public static void debug (ArrayList<Chemical> Chemicals)
	{
		System.out.println(Chemicals.size());
		for (int i=1;i<=MAX_ELEMENT;i++) 
		{
			for (int j=0;j<Chemicals.size();j++)
			{
				System.out.print(Chemicals.get(j).Element[i]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	public static void print (ArrayList<Fraction> Fractions)
	{
		System.out.println(Fractions.size());
		for (int i=0;i<Fractions.size();i++) 
		{
			System.out.println(Fractions.get(i));
		}
		System.out.println();
		System.out.println();
	}
	public static ArrayList<Fraction> solve (ArrayList<Chemical> Chemicals) 
	{
		//Matrix Solve
		HashSet<Integer> elementUsed = new HashSet<Integer>();
		ArrayList<Integer> elementOrder = new ArrayList<Integer>();
		ArrayList<Fraction> answer = new ArrayList<Fraction>();
		for (int i=0;i<Chemicals.size();i++)
		{
			answer.add(ZERO);
		}
		//debug(Chemicals);
		for (int i=0;i<Chemicals.size();i++) 
		{
			//Choose a row in the matrix to work with
			Chemical cur = Chemicals.get(i);
			int element = 0;
			Fraction value = ZERO;
			for (int j=1;j<=MAX_ELEMENT;j++) 
			{
				if (cur.Element[j].equal(ZERO)) continue;
				if (elementUsed.contains(j)) continue;
				element = j;
				value = cur.Element[j];
				break;
			}
			if (value.equal(ZERO)) break;
			elementUsed.add(element);
			elementOrder.add(element);
			//Row operation for each row
			for (int j=1;j<=MAX_ELEMENT;j++)
			{
				if (element==j) continue;
				Fraction p = Chemicals.get(i).Element[j].divide(value);
				for (int k=0;k<Chemicals.size();k++)
				{
					Fraction res = p.multiply(Chemicals.get(k).Element[element]);
					//sSystem.out.println(res);
					Chemicals.get(k).Element[j] = Chemicals.get(k).Element[j].minus(res);
				}
			}
		}
		//debug(Chemicals);
		//Make Diagonal
		for (int i=elementOrder.size()-1;i>=0;i--)
		{
			int element = elementOrder.get(i);
			int chemical = i;
			Fraction value = Chemicals.get(chemical).Element[element];
			//Row operation for each row
			for (int j=1;j<=MAX_ELEMENT;j++)
			{
				if (element==j) continue;
				Fraction p = Chemicals.get(chemical).Element[j].divide(value);
				for (int k=0;k<Chemicals.size();k++)
				{
					Fraction res = p.multiply(Chemicals.get(k).Element[element]);
					Chemicals.get(k).Element[j] = Chemicals.get(k).Element[j].minus(res);
				}
			}
		}
		//debug(Chemicals);
		//finally, balance equation
		for (int i=1;i<=MAX_ELEMENT;i++)
		{
			int count = 0;
			Fraction first = ZERO; 
			Fraction second = ZERO;
			int firstPos = 0;
			int secondPos = 0;
			for (int j=0;j<Chemicals.size();j++)
			{
				if (!Chemicals.get(j).Element[i].equal(ZERO)) 
				{
					count++;
					if (first.equal(ZERO)) 
					{
						first = Chemicals.get(j).Element[i];
						firstPos = j;
					}
					else if (second.equal(ZERO)) 
					{
						second = Chemicals.get(j).Element[i];
						secondPos = j;
					}
				}
			}
			if (count!=2&&count!=0) 
			{
				return null;
			}
			if (count==0) continue;
			Fraction firstNow = answer.get(firstPos);
			Fraction secondNow = answer.get(secondPos); 
			if (!firstNow.equal(ZERO))
			{
				answer.set(secondPos,firstNow.divide(second).multiply(first).multiply(new Fraction(-1)));
				//System.out.println(firstNow+" "+firstNow.divide(second).multiply(first).multiply(new Fraction(-1)));
			}
			else if (!secondNow.equal(ZERO))
			{
				//System.out.println(secondNow+" "+secondNow.divide(first).multiply(second).multiply(new Fraction(-1)));
				answer.set(firstPos,secondNow.divide(first).multiply(second).multiply(new Fraction(-1)));
			}
			else 
			{
				Fraction one = new Fraction(1);
				answer.set(firstPos,one);
				answer.set(secondPos,one.divide(second).multiply(first).multiply(new Fraction(-1)));
				//System.out.println(one+" "+one.divide(second).multiply(first).multiply(new Fraction(-1)));
			}
		}
		//debug(Chemicals);
		return answer;
	} 

}
