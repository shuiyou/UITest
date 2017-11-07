import bean.JsonBean;
import sun.text.resources.cldr.ti.FormatData_ti_ER;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by hanxiaodi on 17/8/2.
 */

public class ListTest {
	// 用于存放备选课程的list
	public List coursesToSelect;

	public ListTest(){
		this.coursesToSelect = new ArrayList();
	}

	//用于网courselist 添加课程
	public void testAdd(){
		Course cr1 = new Course("1","数据课程");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0);
		System.out.print(temp);

	}



}
