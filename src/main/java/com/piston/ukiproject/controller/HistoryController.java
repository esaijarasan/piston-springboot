package com.piston.ukiproject.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piston.ukiproject.model.History;
import com.piston.ukiproject.service.HistoryService;





@CrossOrigin(origins= {"http://localhost:3001"})
@RestController
@RequestMapping("/history")
public class HistoryController {
	@Autowired
	HistoryService historyService ;
	
	@GetMapping
	public ResponseEntity <List<History>> getAllHistory(){
		return historyService.getAllHistory();
		
	}
	@PostMapping
	public ResponseEntity<History> createHistory(@RequestBody History history ) {
		return historyService.createHistory(history);
	
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity <List<History>> getHistoryByUserId(@PathVariable String userId) {
		return historyService.getHistoryByUserId(userId);
	
	
	}
	
	@DeleteMapping
	public ResponseEntity <HttpStatus>  deleteAllHistory()  {
		return historyService.deleteAllHistory();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteHistoryById(@PathVariable String id) {
		return historyService.deleteHistoryById(id);
	}
	
	 @GetMapping("/page")
	    public ResponseEntity<Map<String, Object>> getAllHistoryInPage(
	            @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
	            @RequestParam(name = "pageSize", defaultValue = "2") int pageSize,
	            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
	        return historyService.getAllHistoryInPage(pageNo, pageSize, sortBy);
	    }

	
	
}
