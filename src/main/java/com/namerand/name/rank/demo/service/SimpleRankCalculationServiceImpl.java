package com.namerand.name.rank.demo.service;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.namerand.name.rank.demo.entity.EntityName;

@Service
public class SimpleRankCalculationServiceImpl implements RankCalculationService {


    public	final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	@Override
	public Integer totalRank(List<EntityName>  rankedNames) {

		rankedNames.sort((EntityName s1, EntityName s2)->s1.getFirstName().compareTo(s2.getFirstName())); 
	
		int totalRank = 0;
		int currentPosition = 1;
		for (EntityName name: rankedNames) {
			totalRank += calculateSimpleRank(name.getFirstName()) * currentPosition;
			currentPosition ++;
		}
		return totalRank;
	}



	private int calculateSimpleRank(String stringToRank) {
		int score = 0;
		if (stringToRank != null && !stringToRank.isEmpty())
		for(int i = 0; i < stringToRank.length(); i++) {
			String input = stringToRank.toLowerCase();
	        score += alphabet.indexOf(input.charAt(i)) + 1;
		}
	 	return score;
	}
	

}
