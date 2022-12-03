package operator;

import java.io.IOException;
import java.util.*;

public class ConvertChemical {


	public static Chemical solve (String s) throws IOException
	{
		boolean valid = false;
		Stack<Integer> st = new Stack<Integer>();
		Chemical chemical = new Chemical();
		st.push(1);
		int count = 1;
		//Reverse the string
		s = new StringBuffer(s).reverse().toString();
		//For loop each char
		for (int i=0;i<s.length();i++) 
		{	
			char now = s.charAt(i);
			if (Character.isDigit(now)&&i!=s.length()-1)
			{
				int power = 1;
				while (Character.isDigit(now)&&i!=s.length()-1)
				{
					count = ((int)now-(int)('0'))*power;
					i++;
					now = s.charAt(i);
					power *= 10;
				}
				i--;
			}
			else if (now=='('||now=='['||now=='{') 
			{
				if (st.empty()) return null;
				st.pop();
			}
			else if (now==')'||now==']'||now=='}') 
			{
				st.push(count*st.peek());
				count = 1;
			}
			else
			{
				valid = true;
				String element = "";
				element += now; 
				while (!Character.isUpperCase(now))
				{
					if (!Character.isLetter(now)) return null;
					i++;
					now = s.charAt(i);
					element += now;
				}
				element = new StringBuffer(element).reverse().toString();
				int ID = IDconvert.GetID(element);
				if (ID==-1) return null;
				chemical.Element[ID] = chemical.Element[ID].plus(new Fraction(count*st.peek()));
				count = 1;
			}
		}
		if (!valid) return null;
		if (st.size()>1) return null;
		return chemical;
	}
}
