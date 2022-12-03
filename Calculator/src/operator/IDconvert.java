package operator;

import java.io.*;
import java.util.*;

public class IDconvert {

	public static int GetID (String element) throws IOException {
		//File directory = new File("./");
		//System.out.println(directory.getAbsolutePath());
//		System.out.println(element);
//		char c = element.charAt(0);
//		return (int)c-(int)'A'+1;
//		System.out.println(element);
		File file = new File("./src/operator/elements.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String[] line = null;
		for (int i=1;i<=118;i++)
		{
			line = in.readLine().split(" ");
			int id = Integer.parseInt(line[0]);
			String name = line[1];
			if (name.equals(element))
			{
				in.close();
				return id;
			}
		}
		in.close();
		return -1;
	}
}
