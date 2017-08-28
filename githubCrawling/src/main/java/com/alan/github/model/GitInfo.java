package com.alan.github.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alan.github.jutils.JsonUtils;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@Document(collection ="apache_git")
@TargetUrl("https://github.com/apache/\\w+")
@HelpUrl("https://github.com/apache\\?page=\\d+")
public class GitInfo {
	@Id
	private String id;
	@ExtractBy(value = "//h1[@class='public']/strong/a/text()")
    private String name;
	
    @ExtractByUrl("https://github\\.com/(\\w+)/.*")
    private String author;
    
    @ExtractBy("//td[@class='content']/span/a/text()")
    private String firstFileName;
    
    @ExtractBy("//span[@class='Counter']/text()")
    private String totalPulls;
    
    @ExtractBy("//a[@class='social-count']/text()")
    private String totalWatchs;
    
    @ExtractBy("//span[@class ='col-11 text-gray-dark mr-2']/text()")
    private String description;
    
    @ExtractBy("//span[@class ='num text-emphasized']/text()")
    private String totalCommits;

    @ExtractBy("//relative-time/text()")
    private String lastCommitTime;
    
    @ExtractBy("//article[@class='markdown-body entry-content']/h1/text()")
    private String readmeTitle;

	public String toJson() {
		return JsonUtils.toJson(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFirstFileName() {
		return firstFileName;
	}

	public void setFirstFileName(String firstFileName) {
		this.firstFileName = firstFileName;
	}

	public String getTotalPulls() {
		return totalPulls;
	}

	public void setTotalPulls(String totalPulls) {
		this.totalPulls = totalPulls;
	}

	public String getTotalWatchs() {
		return totalWatchs;
	}

	public void setTotalWatchs(String totalWatchs) {
		this.totalWatchs = totalWatchs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotalCommits() {
		return totalCommits;
	}

	public void setTotalCommits(String totalCommits) {
		this.totalCommits = totalCommits;
	}

	public String getLastCommitTime() {
		return lastCommitTime;
	}

	public void setLastCommitTime(String lastCommitTime) {
		this.lastCommitTime = lastCommitTime;
	}

	public String getReadmeTitle() {
		return readmeTitle;
	}

	public void setReadmeTitle(String readmeTitle) {
		this.readmeTitle = readmeTitle;
	}

	@Override
	public String toString() {
		return "GitInfo [id=" + id + ", name=" + name + ", author=" + author + ", firstFileName=" + firstFileName
				+ ", totalPulls=" + totalPulls + ", totalWatchs=" + totalWatchs + ", description=" + description
				+ ", totalCommits=" + totalCommits + ", lastCommitTime=" + lastCommitTime + ", readmeTitle="
				+ readmeTitle + ", toJson()=" + toJson() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getAuthor()=" + getAuthor() + ", getFirstFileName()=" + getFirstFileName() + ", getTotalPulls()="
				+ getTotalPulls() + ", getTotalWatchs()=" + getTotalWatchs() + ", getDescription()=" + getDescription()
				+ ", getTotalCommits()=" + getTotalCommits() + ", getLastCommitTime()=" + getLastCommitTime()
				+ ", getReadmeTitle()=" + getReadmeTitle() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public GitInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public GitInfo(String name, String author) {
//		this.name = name;
//		this.author = author;
//	}

    
}
