package com.namerand.name.rank.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.namerand.name.rank.demo.entity.EntityListScore;
import com.namerand.name.rank.demo.service.RankedNameService;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private RankedNameService rankedNameService;

	public void setRankedNameService(RankedNameService rankedNameService) {
		this.rankedNameService = rankedNameService;
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	void testRankFirstNames() {
		List<String>  names = Arrays.asList("MARY","PATRICIA","LINDA","BARBARA","VINCENZO","SHON","LYNWOOD","JERE","HAI");
		int score = rankedNameService.rankFirstNames(names);
		assertEquals(3194, score);
	}

	@Test
	void testRankFirstNamesCrazyCase() {
		List<String>  names = Arrays.asList("mARY","PATRICIA","linda","BARBARA","VINCENZO","shoN","LYNWOOD","JeRE","HaI");
		int score = rankedNameService.rankFirstNames(names);
		assertEquals(3194, score);
	}
	
	@Test
	void testTwentyFourHours() {
		List<String>  names = Arrays.asList("mARY","PATRICIA","linda","BARBARA","VINCENZO","shoN","LYNWOOD","JeRE","HaI");
		rankedNameService.rankFirstNames(names);
		List<EntityListScore> els = rankedNameService.getLastTwentyFour();
		assertEquals(1, els.size());
		assertEquals(3194, els.get(0).getScore());
	}
	
	
}
