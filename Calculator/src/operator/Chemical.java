package operator;

public class Chemical 
{
	Fraction[] Element;
	final int TOTAL_ELEMENT = 120;
	public Chemical () 
	{
		Element = new Fraction[TOTAL_ELEMENT+10];
		for (int i=1;i<=TOTAL_ELEMENT;i++) Element[i] = new Fraction();
	} 
	public void output () 
	{
		for (int i=1;i<=TOTAL_ELEMENT;i++) 
		{
			if (!Element[i].equal(new Fraction())) 
			{
				System.out.println(Element[i]+" "+i);
			}
		}
	}
}
