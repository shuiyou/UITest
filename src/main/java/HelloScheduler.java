import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by hanxiaodi on 17/8/5.
 */
public class HelloScheduler {
	public static  void main(String[] args){
		//创建一个jobDetail 实例,将该实例与Hellojob 绑定
		JobDetail jobDetail = JobBuilder.newJob(Hellojob.class)
				.withIdentity("myJob","group1").usingJobData("message","hello my job1")
				.usingJobData("floatJobvalue",3.14F)
				.build();
		//创建一个Tigger 实例 定义该job立即执行,每个4秒重复执行一次
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTirgger","group1")
				.usingJobData("message","hello my trigger")
				.usingJobData("DoubleTriggerValue",2.0D)
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(4).repeatForever())
				.build();
		//创建scheduler 实例
		SchedulerFactory sfact = new StdSchedulerFactory();
		try
		{
			Scheduler scheduler = sfact.getScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail,trigger);
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}

	}
}
