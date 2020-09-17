package com.example.demo2.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class TestTask implements BaseTask {

    @Scheduled(cron = "0 0/59 * * * ?")
    @Override
    public void execute() {
        log.info("execute TestTask");
    }
}
