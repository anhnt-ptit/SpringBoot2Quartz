package com.spring.quartz.test.api;

import java.util.Date;
import java.util.UUID;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.quartz.test.job.TestJob;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	Scheduler scheduler;

	@RequestMapping(value = "/status", method = { RequestMethod.GET })
	public String status() {

		JobDetail jobDetail = buildJobDetail();
		Trigger trigger = buildJobTrigger(jobDetail);
		try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

		return "Running";
	}

	private JobDetail buildJobDetail() {
		JobDataMap jobDataMap = new JobDataMap();

		return JobBuilder.newJob(TestJob.class)
				.withIdentity(UUID.randomUUID().toString(), "sync-list-user-jobs")
				.withDescription("Send Sync List User Job").usingJobData(jobDataMap).storeDurably().build();
	}

	private Trigger buildJobTrigger(JobDetail jobDetail) {
		return TriggerBuilder.newTrigger().forJob(jobDetail)
				.withIdentity(jobDetail.getKey().getName(), "sync-list-user-triggers")
				.withDescription("Send Sync List User Trigger").startAt(new Date())
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow()).build();
	}

}
