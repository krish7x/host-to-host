package com.example.gefu.repository;

import com.example.gefu.domain.File;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository <File, Long>{ 
	
	@Query("from File where isValid ='Y'")
	List<File> getValidRecords();
}


