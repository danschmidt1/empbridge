package com.namerand.name.rank.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namerand.name.rank.demo.entity.EntityName;

@Repository
public interface EntityNameRepository extends JpaRepository<EntityName, Long>{

}
