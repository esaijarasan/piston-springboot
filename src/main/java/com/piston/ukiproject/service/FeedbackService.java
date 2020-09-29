package com.piston.ukiproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.piston.ukiproject.model.Feedback;

import com.piston.ukiproject.repository.FeedbackRepository;
@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepository;

//	public void deleteFeedback(String id) {
//		feedbackRepository.deleteById(id);
//		
//	}

	public ResponseEntity<List<Feedback>> getAllFeedback() {
		try {
			List<Feedback> feedbacks=new ArrayList<Feedback>();
			feedbackRepository.findAll().forEach(feedbacks::add);
			if (feedbacks.isEmpty()) {
				 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(feedbacks,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Feedback> createHistory(Feedback feedbacks) {
		try {
			feedbacks.setDate(new Date());
			Feedback feedbacksNew=feedbackRepository.save(feedbacks);
	
			return new ResponseEntity<>(feedbacksNew, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}



	public ResponseEntity<HttpStatus> deleteFeedbackById(String id) {
		try {
			Optional<Feedback> feed=feedbackRepository.findById(id);
			
			if (feed.isPresent()) {
				feedbackRepository.delete(feed.get());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	public ResponseEntity<Map<String, Object>> getAllFeedbackInPage(int pageNo, int pageSize, String sortBy) {
		 try {
	            Map<String, Object> response = new HashMap<>();
	            Sort sort = Sort.by(sortBy);
	            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
	            Page<Feedback> page = feedbackRepository.findAll(pageable);
	            response.put("data", page.getContent());
	            response.put("Total no of pages", page.getTotalPages());
	            response.put("Total no of elements", page.getTotalElements());
	            response.put("Current page no", page.getNumber());
	            
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	}
}
	
	
	
	
	
	
	


