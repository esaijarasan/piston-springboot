package com.piston.ukiproject.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.piston.ukiproject.model.Feedback;

import com.piston.ukiproject.service.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
	@Autowired
	FeedbackService feedbackservice;
	
	@GetMapping
	public ResponseEntity <List<Feedback>> getAllFeedback(){
		return feedbackservice.getAllFeedback();
		
	}
	@PostMapping
	public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedbacks ) {
		return feedbackservice.createHistory(feedbacks);
		
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteFeedbackById(@PathVariable String id) {
		return feedbackservice.deleteFeedbackById(id);
	}
	
	
	 @GetMapping("/page")
	    public ResponseEntity<Map<String, Object>> getAllFeedbackInPage(
	            @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
	            @RequestParam(name = "pageSize", defaultValue = "2") int pageSize,
	            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
	        return feedbackservice.getAllFeedbackInPage(pageNo, pageSize, sortBy);
	    }
	

}
