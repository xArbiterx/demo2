package com.example.demo2.config.quartz;

import com.example.demo2.job.TestJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail testJob() {
        return JobBuilder.newJob(TestJob.class).withIdentity("testJob").storeDurably().build();
    }

    @Bean
    public Trigger testJobTrigger() {
        //cron方式，每隔1秒执行一次
        return TriggerBuilder.newTrigger().forJob(testJob())
                .withIdentity("testJob")
                .withSchedule(CronScheduleBuilder.cronSchedule("1/1 * * * * ?"))
                .build();
    }
}
