package com.library.libraryproject.scheduler;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author dcl
 * 2018年10月16日21:48:17
 *
 * 时间调度配置类，配置关于项目中的@scheduler注解
 *
 * 采用实现接口的方式用以实现并发（并行）
 * 此处使用ScheduledThreadPool线程池进行控制
 * */
@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(setTaskExecutor());
    }

    /**
     * 此处shutdown曾报红是因为方法的修饰符为public，应为private
     * */
    @Bean(destroyMethod = "shutdown")
    public Executor setTaskExecutor(){
        // 此处的第一个参数为最大多少个线程
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(3
                , new BasicThreadFactory.Builder().namingPattern("scheduler-pool-%d").daemon(true).build());
        return scheduledExecutorService;
    }
}
