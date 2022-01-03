package org.interview.app;

import org.interview.service.TwitterJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
	"org.interview.common",
	"org.interview.service"
})
public class SytacApplication implements CommandLineRunner {
	
	@Autowired
	private TwitterJob twitterJob;
	
	public static void main(String[] args) {
		SpringApplication.run(SytacApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		twitterJob.doJob();
	}

}
