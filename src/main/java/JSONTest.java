import bean.JsonBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanxiaodi on 17/8/11.
 */
public class JSONTest {
      public static void main(String[] args){
		//  jSONObjectSample();
		//  mapSample();
		  CreateJsonBean();


	  }

	  private static void jSONObjectSample(){
		  JSONObject wangxiaoer = new JSONObject();
		  wangxiaoer.put("name","wangxiaoer");
		  wangxiaoer.put("age",25);
		  wangxiaoer.put("birthday","1991-05-03");
		  wangxiaoer.put("has_girlfriend",false);
		  wangxiaoer.put("car",null);
		  System.out.print(wangxiaoer.toString());

	  }

	  private static  void mapSample(){
		  Map<String ,Object> wangxiaoer = new HashMap<String,Object>();
		  wangxiaoer.put("name","wangxiaoer");
		  wangxiaoer.put("age",25);
		  wangxiaoer.put("birthday","1991-05-03");
		  wangxiaoer.put("has_girlfriend",false);
		  wangxiaoer.put("car",null);
		  System.out.print(wangxiaoer.toString());

	  }

	  private static void CreateJsonBean(){
		  JsonBean wangxiaoer = new JsonBean();
		  wangxiaoer.setName("王小二");
		  wangxiaoer.setAge(15);
		  wangxiaoer.setBithday("1991-05-03");
		  wangxiaoer.setCar(null);
		  wangxiaoer.setHouse(null);
		  wangxiaoer.setHas_grilfriend(false);
		  wangxiaoer.setMajor(new String[]{"math","english"});
		  System.out.println(new org.json.JSONObject(wangxiaoer));
	  }

}
