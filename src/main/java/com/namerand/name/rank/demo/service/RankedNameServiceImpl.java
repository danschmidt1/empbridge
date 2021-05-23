package com.namerand.name.rank.demo.service;

import java.util.Date;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namerand.name.rank.demo.entity.EntityListScore;
import com.namerand.name.rank.demo.entity.EntityName;
import com.namerand.name.rank.demo.repository.EntityListScoreRepository;
import com.namerand.name.rank.demo.repository.EntityNameRepository;

@Service
public class RankedNameServiceImpl implements RankedNameService{

	// I have shunted the rank calculation service out to an external service. 
	// That way teams that have advanced calculations to do for more advanced methods can
	// inject a different service (or an additional service), 
	// or add a new method into the  method in the current service, based upon their needs.
	@Autowired
	private RankCalculationService rankCalculationService;

	public void RankCalculationService(RankCalculationService rankCalculationService) {
		this.rankCalculationService = rankCalculationService;
	} 
	
// Repository and rank full names method not used
	@Autowired
	 private EntityListScoreRepository entityListScoreRepository;
	 
	 public void setEntityListScoreRepository(EntityListScoreRepository entityListScoreRepository) {
		  this.entityListScoreRepository = entityListScoreRepository;
     }
	@Autowired
    private EntityNameRepository entityNameRepository;
		 
	public void setEntityNameRepository(EntityNameRepository entityNameRepository) {
			  this.entityNameRepository = entityNameRepository;
	     }
//		  
//	@Override
//	public Integer rankFullNames(List<EntityName> nameEntities) {
//		// TODO Auto-generated method stub
//		return rankCalculationService.totalRank(nameEntities);
//	}


	@Override
	public Integer rankFirstNames(List<String> firstNames) {
       // List<String>sortedList = firstNames.stream().sorted().collect(Collectors.toList());		
		List<EntityName> nameEntities = firstNames.stream()
			    .map(create(EntityName::new, EntityName::setFirstName)).collect(Collectors.toList());
	
		entityNameRepository.saveAll(nameEntities);
		EntityListScore entityListScore = new EntityListScore();
		entityListScore.setEntityList(nameEntities);
		entityListScore.setScore(rankCalculationService.totalRank(nameEntities));
		entityListScoreRepository.save(entityListScore);
		return entityListScore.getScore();
	}
	
	
	public static <T,V> Function<V,T> create(
		    Supplier<? extends T> constructor, BiConsumer<? super T, ? super V> setter) {
		    return v -> {
		        T t=constructor.get();
		        setter.accept(t, v);
		        return t;
		    };
		}


	@Override
	public List<EntityListScore> getLastTwentyFour() {
		Instant twentyFourHoursAgo = Instant.now().minus(Duration.ofHours(24));
		Date date = Date.from(twentyFourHoursAgo);
		return entityListScoreRepository.findAllWithCreationDateTimeAfter(date);
	}
}
