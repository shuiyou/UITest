import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

/**
 * Created by hanxiaodi on 17/8/17.
 */
public class ReadJsonSample
{
	public static void main(String[] args) throws IOException
	{

			File file =
					   new File(ReadJsonSample.class.getResource("/wangxiaoer.json").getFile());

			String content = FileUtils.readFileToString(file);
		    JSONObject jsonObject = new JSONObject(content);
  			System.out.println("name is "+jsonObject.getString("name"));
		    JSONArray  marjorArray =jsonObject.getJSONArray("major");
			for(int i =0;i<marjorArray.length();i++){
				String m = (String)marjorArray.get(i);
				System.out.println("major "+(1+i)+m);

			}




	}

}
