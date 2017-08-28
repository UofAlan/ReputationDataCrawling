package com.alan.github.repostories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alan.github.model.GitInfo;
@Component
public interface CustomRepository {
	
//	void deleteByName(String Name);
	List<GitInfo> getByNameorTheFirstFileName(String name, String firstFileName);
	
}
