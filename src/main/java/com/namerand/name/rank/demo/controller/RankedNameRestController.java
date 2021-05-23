package com.namerand.name.rank.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.namerand.name.rank.demo.entity.EntityName;
import com.namerand.name.rank.demo.service.RankedNameService;

/**
 * @author JavaSolutionsGuide
 *
 */
@RestController
public class RankedNameRestController {

	@Autowired
	private RankedNameService rankedNameService;

	public void setRankedNameService(RankedNameService rankedNameService) {
		this.rankedNameService = rankedNameService;
	}
	
//	@PostMapping("/api/rankefullnames")
//	public Integer rankFullNameList(@RequestBody List<EntityName> namesToRank) {
//		Integer rankedTotal = rankedNameService.rankFullNames(namesToRank);
//		System.out.println("names Ranked");
//		return rankedTotal;
//	}
	
	@PostMapping("/api/rankefirstnames")
	public Integer rankFirstNames(@RequestBody List<String> firstNames) {
		Integer rankedTotal = rankedNameService.rankFirstNames(firstNames);
		return rankedTotal;
	}
	


}