import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hanxiaodi on 17/8/5.
 */
public class Hellojob implements Job{

	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
	{
		//里面编写具体的业务逻辑 类似于定时任务里面的run()方法
		//打印当前时间 格式为2017-01-01 00:0000
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Execu time is"+sf.format(date));
		//System.out.println("hello word");
		JobKey key = jobExecutionContext.getJobDetail().getKey();
		System.out.println(key.getName()+"group"+key.getGroup());
		TriggerKey trkey = jobExecutionContext.getTrigger().getKey();
		System.out.println(trkey.getName()+"tiggerGroup"+trkey.getGroup());
		JobDataMap dataMap =jobExecutionContext.getJobDetail().getJobDataMap();
		JobDataMap tdataMap =jobExecutionContext.getTrigger().getJobDataMap();
		String jobMsg=dataMap.getString("Message");
		Float jobFloateValue =dataMap.getFloatValue("floatJobvalue");
		String tiggerMsg = tdataMap.getString("message");
		Double tiggerDouble = tdataMap.getDouble("DoubleTriggerValue");
		System.out.println("jobMsg"+jobMsg);
		System.out.println("jobFloatValue"+jobFloateValue);
		System.out.println("tiggerMsg"+tiggerMsg);
		System.out.println("tiggerDouble"+tiggerDouble);
	}
}
