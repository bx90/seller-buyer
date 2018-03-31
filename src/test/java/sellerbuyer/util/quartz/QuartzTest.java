package sellerbuyer.util.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.testng.annotations.Test;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
public class QuartzTest {
    @Test
    public void test() throws SchedulerException {
        JobDetail job = JobBuilder.newJob(TestJob.class).withIdentity("BxJobName","groupId").build();
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();


        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
