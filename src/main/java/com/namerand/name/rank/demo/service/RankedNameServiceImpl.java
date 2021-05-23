package com.namerand.name.rank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankedNameServiceImpl implements RankedNameService{

	@Autowired
	private RankCalculationService rankCalculationService;

	public void RankCalculationService(RankCalculationService rankCalculationService) {
		this.rankCalculationService = rankCalculationService;
	} 
	
//	@Autowired
//	 private RankedNameRepository rankedNameRepository;
//	 
//	 public void setRankedNameRepository(RankedNameRepository rankedNameRepository) {
//		  this.rankedNameRepository = rankedNameRepository;
//     }
//		  
	
	
	
	
//	@Override
//	public Integer rankFullNames(List<EntityName> namesToRank) {
//		// TODO Auto-generated method stub
//		return 0;
//	}


	@Override
	public Integer rankFirstNames(List<String> firstNames) {
		return rankCalculationService.totalRankBasic(firstNames);
	}
	
	

}
