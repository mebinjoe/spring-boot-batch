package com.example.demo.batch;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleBatchAppTests {

	@Rule
	public final OutputCapture output = new OutputCapture();

	@Test
	public void testDefaultSettings() {
		assertThat(SpringApplication
				.exit(SpringApplication.run(SampleBatchApp.class))).isEqualTo(0);
		assertThat(this.output.toString())
				.contains("completed with the following parameters");
	}

}
