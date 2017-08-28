package com.alan.github.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.alan.github.model.GitInfo;
import com.alan.github.repostories.GitInfoRepository;
import com.alan.github.tools.Crawling;

@RestController
class crawlingController{
	
	@Autowired
	private GitInfoRepository gRepository;
	
	@RequestMapping("/crawling")
	public String crawling() {
		new Crawling().startAndStoreInMongoDb();
		return "greeting";
	}
	//get all data
	@RequestMapping("/infos")
	public List<GitInfo> getGitInfo(){
		List<GitInfo> list = gRepository.findAll();
		return list;
	}
	@RequestMapping("/info/name={name}")
	public GitInfo getInfoByName( @PathVariable String name) {
		GitInfo info = gRepository.findByName(name);
		return info;
//		caj3368
	}

	
	//Boolean AND
	@RequestMapping("/info/author={author}&&firstFileName={firstFileName}")
	public List<GitInfo> getInfosByAuthorAndFirstFileName(@PathVariable("author")String author,@PathVariable("firstFileName")String firstFileName){
		List<GitInfo> list = gRepository.findByAuthorAndFirstFileName(author, firstFileName);
		
		return list;
	}
	@RequestMapping("info/readme=null")
	public List<GitInfo> getReadmeNULL(){
		List<GitInfo> list = gRepository.findByReadmeTitleNull();
		return list;
	}
	
	//Boolean AND 
	@RequestMapping("info/ffName={firstFileName}&&readme==null")
	public List<GitInfo> getFirstFileNameAndReadmeNULL(@PathVariable("firstFileName")String firstFileName){
		List<GitInfo> list = gRepository.findByFirstFileNameAndReadmeTitleNull(firstFileName);
		return list;
	}
	
	//Boolean AND NOT
	@RequestMapping("info/ffName={ffname}&&readme!=null")
	public List<GitInfo> getFirstFileNameAndReadmeNOTNULL(@PathVariable("ffname")String ffname){
		List<GitInfo> list = gRepository.findByFirstFileNameAndReadmeTitleNotNull(ffname);
		return list;
	}
//	@RequestMapping("info/name={name}ORffname={firstFileName}")
//	public List<GitInfo> getByNameORFirstFileName(@PathVariable("name")String name, @PathVariable("firstFileName")String firstFileName){
//		List<GitInfo> list = gRepository.getByNameorTheFirstFileName(name, firstFileName);
//		return list;
//		
//	}
	//POST
	@PostMapping("/info/add={name}/{author}")
	public void save(@PathVariable("name") String name, @PathVariable("author") String author) {
		GitInfo info1 = new GitInfo();
		info1.setAuthor(author);
		info1.setName(name);
		
		gRepository.save(info1);
	}
	//PATCH
	@PatchMapping("/info/patch={name}/{author}")
	public void modify(@PathVariable("name") String name, @PathVariable("author") String author) {
		GitInfo info = getInfoByName(name);
		if(info!=null) {
			info.setAuthor(author);//update author
			gRepository.save(info);
		}
	}
	//PUT
	@PutMapping("/info/put={name}/{author}")
	public void update(@PathVariable("name") String name, @PathVariable("author") String author) {
		GitInfo info = getInfoByName(name);
		if(info!=null) {
			info.setAuthor(author);//update author
			info.setFirstFileName(null);
			info.setDescription(null);
			info.setLastCommitTime(null);
			info.setReadmeTitle(null);
			info.setTotalCommits(null);
			info.setTotalPulls(null);
			info.setTotalWatchs(null);
			gRepository.save(info);
		}
	}
	//DELETE
	@DeleteMapping("info/delete={name}")
	public void delete(@PathVariable("name") String name) {
		GitInfo info = getInfoByName(name);
		gRepository.delete(info);
	}
	
}