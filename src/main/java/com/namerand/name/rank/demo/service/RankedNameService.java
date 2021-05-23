package com.namerand.name.rank.demo.service;

import java.util.List;

import com.namerand.name.rank.demo.entity.EntityListScore;



public interface RankedNameService {

	// This would be used by the follow on team should they have the need to sort full names
	//Integer rankFullNames(List<EntityName> namesToRank);

	Integer rankFirstNames(List<String> firstNames);

	List<EntityListScore> getLastTwentyFour();

}
