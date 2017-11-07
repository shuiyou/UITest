package Utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by hanxiaodi on 17/8/22.
 */
public class TestArraySort
{
	public static void main(String[] args)
	{
		String[] a = { "age", "aeb", "abc", "edg", "ead" };
		Arrays.sort(a);
		String c = a[0];
		StringBuilder outputString = new StringBuilder("");
		for (int i = 0; i < a.length; i++)
		{
			outputString.append(a[i]);
			outputString.append('&');
		}
	System.out.println(outputString);
		String request = outputString.substring(0, outputString.length() - 1);
		System.out.println(request);
	}


	
}
