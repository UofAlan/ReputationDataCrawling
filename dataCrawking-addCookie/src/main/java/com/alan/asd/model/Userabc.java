package com.alan.asd.model;





import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("https://www.linkedin.com/.*")
@HelpUrl("https://www.linkedin.com/in/\\w+")
public class Userabc {
	
	@ExtractBy(value = "//title/text()")
	private String name;
	@ExtractBy(value = "//span[@class='nav-item__title']/text()")
    private String name2;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", name2=" + name2 + "]";
	}
	
	
	
}
