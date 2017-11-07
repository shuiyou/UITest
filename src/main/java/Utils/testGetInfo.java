package Utils;

import java.util.Iterator;
import java.util.List;

/**
 * Created by hanxiaodi on 17/9/7.
 */
public class testGetInfo
{
	public static void main(String[] args){
		String filepath ="/Users/hanxiaodi/Downloads/test_file_20170804.txt";
		List a =AccountGilde.getAccountGildeFromFile(filepath);
		Iterator iter = a.iterator();

		while(iter.hasNext()){
			AccountGilde c = (AccountGilde)iter.next();
			System.out.print(c);
		}

	}
}
