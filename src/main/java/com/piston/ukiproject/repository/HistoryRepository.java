package com.piston.ukiproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.piston.ukiproject.model.History;



@Repository
public interface HistoryRepository extends MongoRepository<History, String> {

	Optional<History> findByuserId(String userId);

	List<History> findByUserId(String userId);

}
