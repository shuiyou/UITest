import bean.JsonBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by hanxiaodi on 17/8/18.
 */
public class TestArrayList
{
    public  static void main(String[] args){
//		List<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		System.out.println(list);
//		list.add(1,"E");
//		System.out.println(list);
//		List<String> list1 = new ArrayList<String>();
//		list1.add("f");
//		list1.add("g");
//
//		list.addAll(list1);
//		System.out.println(list);


		List<JsonBean> yanshi = new ArrayList<JsonBean>();
		yanshi.addAll(builderJsonBeans(3));
		for(JsonBean js :yanshi){
			System.out.println(js.getName());
		}
	//	System.out.println(yanshi);

	}


	public static JsonBean buiderJsonBean(String name,int age,String birthday){
		JsonBean jsonBean = new JsonBean();
		jsonBean.setAge(age);
		jsonBean.setName(name);
		jsonBean.setCar(null);
		jsonBean.setBithday(birthday);
		jsonBean.setSchool(null);
		jsonBean.setHouse(null);
		jsonBean.setMajor(new String[]{"math","english" });
		return jsonBean;

	}


	public static String randomName(){
		String name ="" ;
		String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","y"};
		Random random = new Random();
		for(int i =0 ;i<6;i++){
			int j = random.nextInt(11);
			String charname = alphabet[j];
			name += charname;
		}
		return name;
	}

	public static List<JsonBean> builderJsonBeans(int number){
		List<JsonBean> JSN = new ArrayList<JsonBean>();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-DD-mm HH:ss");
		Date nowtime = new Date();

		for(int i = 0; i<number;i++){
			JsonBean jsonBean = null;
		    jsonBean = buiderJsonBean(randomName(),15+i,sf.format(nowtime));
			JSN.add(i,jsonBean);
		}
		return JSN;
	}

}
