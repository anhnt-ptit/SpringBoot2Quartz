package com.spring.quartz.test.job;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class TestJob extends QuartzJobBean {

	private static Logger logger = LoggerFactory.getLogger(TestJob.class);

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Starting execute job test with key is {}", context.getJobDetail().getKey());
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		// TODO
		logger.info("Ending execute job test with key is {}", context.getJobDetail().getKey());
	}

}
