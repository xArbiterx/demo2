package com.example.demo2.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;


@Slf4j
public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        log.info("execute TestTask");
    }
}
