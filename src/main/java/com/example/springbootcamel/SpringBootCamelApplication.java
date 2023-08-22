package com.example.springbootcamel;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Log4j2
@SpringBootApplication
public class SpringBootCamelApplication {

    public static void main(String[] args) throws Exception {
//		SpringApplication.run(SpringBootCamelApplication.class, args);
        Environment env = SpringApplication.run(SpringBootCamelApplication.class, args).getEnvironment();
        int port = StringUtils.isBlank(env.getProperty("server.port")) ?
                80 : Integer.parseInt(env.getProperty("server.port"));
//			String contextPath = env.getProperty("server.servlet.context-path");
        String contextPath = env.getProperty("camel.component.servlet.mapping.contextPath");
        contextPath = StringUtils.isBlank(contextPath) ? "/" : contextPath.replace("*", "");
        log.info(String.format(
                "\n----------------------------------------------------------\n\t"
                        + "Application %s is running! Access URLs:\n\t"
                        + "Local: \t\thttp://127.0.0.1:%s%s\n\t"
                        + "\n----------------------------------------------------------\n",
                env.getProperty("spring.application.name"),
                port,
                contextPath));
    }

}
