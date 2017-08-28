package com.alan.github;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableScheduling
public class App {
	private void disableHLog() {
		Set<String> loggers = new HashSet<>(Arrays.asList("org.apache.http", "groovyx.net.http","us.codecraft.webmagic","u.c.w.downloader.HttpClientDownloader"));
	    
	    for(String log:loggers) { 
	    Logger logger = (Logger)LoggerFactory.getLogger(log);
	    logger.setLevel(Level.INFO);
	    logger.setAdditive(false);
	    }

	}
	public static void main(String[] args) {
		new App().disableHLog();
		//new Crawling().startAndPrintInConsole();
		//new Crawling().startAndStoreInMongoDb();
		SpringApplication.run(App.class, args);
	}
}
