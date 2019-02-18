package com.example.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBatchProcessing
public class SampleBatchApp {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	protected Tasklet tasklet() {

		return new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext context) {
				return RepeatStatus.FINISHED;
			}
		};

	}

	@Bean
	public Job job() throws Exception {
		return this.jobBuilderFactory.get("job").start(orderStep1()).build();
	}

	@Bean
	protected Step orderStep1() throws Exception {
		return this.stepBuilderFactory.get("step1").tasklet(tasklet()).build();
	}

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(SampleBatchApp.class, args)));
	}

}
