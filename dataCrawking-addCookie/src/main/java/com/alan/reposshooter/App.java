package com.alan.reposshooter;

import java.util.List;

import org.apache.http.cookie.Cookie;

import com.alan.asd.model.Userabc;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;


public class App {
	
	public static final String LINKEDIN_USER_NETWORK_PAGE = "https://www.linkedin.com/mynetwork/invite-connect/connections/";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
	private OOSpider ooSpider = null;
	//2 ways to add cookies
	//1.from HttpClient
	public App(List<Cookie> cookies){
		for(Cookie cookie : cookies) {
			site.addCookie(cookie.getDomain(), cookie.getName(), cookie.getValue());
		}
		this.ooSpider = OOSpider.create(site, new ConsolePageModelPipeline(),Userabc.class);
	}
	//2.add directly
	public App(){
		site.setCharset("utf-8")
		.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36")
		.addHeader("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		.addHeader("accept-encoding","gzip, deflate, br")
		.addHeader("accept-language:en-US","en;q=0.8")
		.addHeader("connection", "keep-alive")
		.addHeader("referer","https://www.linkedin.com/")
		.addCookie(".linkedin.com","lidc", "b=TB91:g=750:u=38:i=1503815541:t=1503895683:s=AQE5xZLW6mVmRdHBY9qNO-YOiyAnKtgk")
		.addCookie(".linkedin.com","lang", "v=2&lang=en-us")
		.addCookie(".linkedin.com","_lipt", "CwEAAAFeIo5-jXjgrpSKF4JfxzNbjC6328JPUgtSHQIKtSDyk4Bockuw84uMkCwbKS0TzUOM_w8Al4s9YjFFF-0T43TPtfG_wv-JNVXsPeO8mVxaYwEcTGiyOdyaRZOCIK7qi02EvZUCtjsaTpAos60U4XrFnu1FO-cY1LrzpqDNUmfrqWJPjSoZpOmjeKtTh-nHcdgpruvjf237E78dqMydLLd1A0Uu7Kr7CmNIurXFd9-Z4hwevLRd3SQMEbSRxAwCclgC4tTzEZ5KoFmpI4veKBFGOqF5MCx3hO9iNRdHrJC44hfRx-Bw7p__PYNWF8sc6yYd0deF-C5aJpronFUYp3vXiwt023qm6T9eRqVvtH1BRfLwCZOJmYrGbKzq4plzNKM7DnHKHNV_cjJQtc9aD3JQz8n2GI-cHx2PYubUyIjVWWvntKWC-EUtn4REgL4jmIaWzDUVz3nkEBW7I3Wf6u2TkuAVu9vq_0mW_dTVDCzgASk")
		.addCookie(".linkedin.com","_ga", "GA1.2.2091383287.1503630105")
		.addCookie(".www.linkedin.com","li_at", "AQEDAReIjksE2n3-AAABXiKOYVQAAAFeRprlVFYAV8gUt-kMEnL2ktiHZG-AOblSny98srz2r2i18IGs9PqmSRstFVL2ZLdYOcHfPyKnBYLQPJeq5SApwmbQiNtsxO938zQrrcjJZxpOFXa4wCMAuIsN")
		.addCookie(".www.linkedin.com","JSESSIONID", "ajax:4085733349730512988")
		.addCookie(".linkedin.com","liap", "true")
		.addCookie(".www.linkedin.com","sl","v=1&f68pf")
		.addCookie("www.linkedin.com","visit", "v=1&M")
		.addCookie(".www.linkedin.com","bscookie", "v=1&201708250301246c8eaadc-a08f-4e13-8f24-569529ab1ce0AQEk9zZ-nB0gizfSrOSucwXV2Wfc3TBY")
		.addCookie(".linkedin.com","bcookie", "v=2&d2115cf0-88a6-415a-8a0b-27e56fef9e39");
		
		
		this.ooSpider = OOSpider.create(site, new ConsolePageModelPipeline(),Userabc.class);
	}
	public void startCrawler() {
		this.ooSpider.addUrl(LINKEDIN_USER_NETWORK_PAGE).thread(5).run();
	}
	public static void main(String[] args) {
		Login login = new Login();
		
		//new App(login.getLoginCookies()).startCrawler();
		new App().startCrawler();
		//SpringApplication.run(App.class, args);
		
	}
}
