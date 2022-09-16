package hu.ponte.hr;

import hu.ponte.hr.controller.upload.UploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.File;

@EnableAsync
@SpringBootApplication(scanBasePackages = "hu.ponte.hr", exclude = {
	MultipartAutoConfiguration.class
})

public class SeniorTestApplication
{
	public static void main(String[] args)
	{
		new File(UploadController.uploadDirectory).mkdir();
		SpringApplication.run(SeniorTestApplication.class, args);
	}

}

