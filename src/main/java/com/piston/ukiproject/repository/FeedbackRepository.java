package com.piston.ukiproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.piston.ukiproject.model.Feedback;

@Repository
public interface FeedbackRepository  extends MongoRepository<Feedback, String> {

}
