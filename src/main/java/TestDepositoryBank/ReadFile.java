package TestDepositoryBank;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * Created by hanxiaodi on 17/10/31.
 */
public class ReadFile
{
	public static void main(String args[]){
		ReadFile rf = new ReadFile();
		List<String[]> b = rf.ReadFile("/Users/hanxiaodi/Documents/I_GDB10105_20171101_113_P.txt");
		System.out.print( b.get( 0 )[0]);
	}
	public List ReadFile(String pathname){
		/*读取txt文件内容*/
		File filename = new File(pathname);
		try{
			String encoding = "UTF-8";
			//InputStreamReader reader = );
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),encoding));
			String line =null;
			String[] spliteline =null;
			//Array[] linesContext =null;
			List<String[]> a = new ArrayList<String[]>();
			int count=0;
			while ((line =br.readLine())!= null) {
				spliteline =line.split("\\|");
				a.add(count,spliteline );
				line = br.readLine(); // 一次读入一行数
				count++;
			}
			return a;

		}catch (Exception e){
			e.printStackTrace();
		}









		return null;
	}
}
