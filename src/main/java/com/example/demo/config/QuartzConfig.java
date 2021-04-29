package com.example.demo.config;

import com.example.demo.controller.Quartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2021/4/6.
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(Quartz.class).withIdentity("quartz").storeDurably().build();
    }
    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(3600)  //设置时间周期单位秒
                .repeatForever();
        System.out.println("定时器启动:：：：：：3600秒执行一次定时任务");
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("myTestQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
