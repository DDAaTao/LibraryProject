package com.library.libraryproject.xxl;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author van
 * 主要功能为注册到调度中心
 */
@Configuration
public class XxlConfig {


    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses("http://127.0.0.1:8680/xxl-job-admin");
        xxlJobSpringExecutor.setAppName("xxl-job-executor-sample");
        xxlJobSpringExecutor.setIp("");
        xxlJobSpringExecutor.setPort(9999);
        xxlJobSpringExecutor.setAccessToken("");
        xxlJobSpringExecutor.setLogPath("logs/xxl-job/jobhandler");
        xxlJobSpringExecutor.setLogRetentionDays(-1);

        return xxlJobSpringExecutor;
    }
}
