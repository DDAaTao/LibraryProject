package com.library.libraryproject.quartz.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author van
 * quartz的测试任务
 */
@Slf4j
@Service
public class QuartzTestTask {
    public void quartzTask(){
        log.error("quartz task go go go!");
    }
}
