package com.library.libraryproject.xxl.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author van
 * 测试任务，xxl支持到方法级别的注解@xxljob
 */
@Slf4j
@Component
public class XxlTestTask extends IJobHandler {
    @Override
    @XxlJob("testJobHandler")
    public ReturnT<String> execute(String s) throws Exception {
        log.error("Xxl 调度成功！！");
        return SUCCESS;
    }
}
