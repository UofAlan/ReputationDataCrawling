package com.alan.github.repostories;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.alan.github.model.GitInfo;
@Component
public interface GitInfoRepository extends CrudRepository<GitInfo, String> {
	
	List<GitInfo> findByAuthor(String author);
	
	List<GitInfo> findAll();
	GitInfo findByName(String name);
	GitInfo findByTotalWatchs(String num);
	List<GitInfo> findByReadmeTitleNull();
	List<GitInfo> findByAuthorAndFirstFileName(String author, String firstFileName);
	List<GitInfo> findByFirstFileNameAndReadmeTitleNull(String firstFileName);
	List<GitInfo> findByFirstFileNameAndReadmeTitleNotNull(String firstFileName);
//	void save(GitInfo gitInfo);
	
	
}
