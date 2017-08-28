package com.alan.github.tools;


import java.util.ArrayList;

import org.springframework.scheduling.annotation.Scheduled;

import com.alan.github.model.GitInfo;
import com.alan.github.pipelines.GitInfoPipeline;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;

public class Crawling {
	private static String COLLECTION_NAME="apache_git";
	//public ArrayList<GitInfo> arrGit = new ArrayList<>();
	public void startAndPrintInConsole(){
		OOSpider.create(Site.me().setRetryTimes(3).setSleepTime(1000)
                , new ConsolePageModelPipeline(), GitInfo.class)
                .addUrl("https://github.com/apache").thread(5).run();
	}
	
	@Scheduled(cron="0 0 0/2 * * ?") // excute every 2 hours from 00:00
	public void startAndStoreInMongoDb() {
		new DropCollection().drop(COLLECTION_NAME);
		System.out.println("Crawling Spider start to work!");
		Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
        OOSpider ooSpider = OOSpider.create(site,new GitInfoPipeline(), GitInfo.class);
		ooSpider.addUrl("https://github.com/apache").thread(5);
		ooSpider.start();
		ooSpider.stop();
	}
	
}
