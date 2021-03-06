package com.kapcb.ccc.test;

import com.kapcb.ccc.job.MyFirstJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.GregorianCalendar;

/**
 * <a>Title:JobTest</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/30 21:39
 */
public class JobTest {
    public static void main(String[] args) throws SchedulerException {
        //1.创建 scheduler，调度器，核心组件
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2.定义一个 triggerBuilder，触发器
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();

        //创建触发器：Trigger
        triggerBuilder
                .withIdentity("trigger01", "group01")//定义name/group
                .startNow()//一旦加入 scheduler ，立即生效，即开始时间
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInHours(1)//每秒执行一次
                        //.withRepeatCount() 执行几次，withRepeatCount()/repeatForever() 二选一
                        .repeatForever())//一直执行，直到结束时间
                //可以设置执行结束时间，如果不设置，则一直执行
                .endAt(new GregorianCalendar().getTime());
        Trigger build = triggerBuilder.build();

        //3.定义一个JobDetail
        //定义Job类为MyFirstJob类，真正的执行逻辑所在
        JobDetail job = JobBuilder.newJob(MyFirstJob.class)
                .withIdentity("测试任务", "test")//定义name/group
                .usingJobData("data", "Hello,World!")//定义属性，数据存储
                .build();

        //4.调度器中加入任务和触发器
        scheduler.scheduleJob(job, build);

        //5.启动任务调度,内部注册所有的触发器开始计时
        scheduler.start();

        //6.关闭调度器
        scheduler.shutdown();
    }
}
