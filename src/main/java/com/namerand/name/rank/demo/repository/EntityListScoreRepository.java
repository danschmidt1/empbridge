package com.namerand.name.rank.demo.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.namerand.name.rank.demo.entity.EntityListScore;
 

@Repository
public interface EntityListScoreRepository extends JpaRepository<EntityListScore, Long>{

	@Query("select a from EntityListScore a where a.created >= :creationDate")
    List<EntityListScore> findAllWithCreationDateTimeAfter( @Param("creationDate") Date creationDate);//
	
}