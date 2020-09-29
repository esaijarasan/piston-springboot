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

import com.piston.ukiproject.model.History;
import com.piston.ukiproject.repository.HistoryRepository;


@Service
public class HistoryService {
	
	@Autowired
	HistoryRepository historyRepository;

	

	


	public ResponseEntity <List<History>> getAllHistory() {
		try {
			List<History> histories=new ArrayList<History>();
			historyRepository.findAll().forEach(histories::add);
			if (histories.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
			return new ResponseEntity<>(histories,HttpStatus.OK);
	
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	public ResponseEntity<History> createHistory(History histories) {
		try {
			histories.setDate(new Date());
			History histroryNew=historyRepository.save(histories);
	
			return new ResponseEntity<>(histroryNew, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	public ResponseEntity<List<History>> getHistoryByUserId(String userId) {
		try {
			List<History> histories = historyRepository.findByUserId(userId);
			
			if (histories.isEmpty()) {
	              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
			return new ResponseEntity<>(histories, HttpStatus.OK);

			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}




	public ResponseEntity<HttpStatus> deleteHistoryById(String id) {
		try {
			Optional<History> his=historyRepository.findById(id);
			
			if (his.isPresent()) {
				historyRepository.delete(his.get());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}




	public ResponseEntity<HttpStatus> deleteAllHistory() {
		try {
			List<History> hist=historyRepository.findAll();
			
			if (hist.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				historyRepository.deleteAll(hist);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

}




	public ResponseEntity<Map<String, Object>> getAllHistoryInPage(int pageNo, int pageSize, String sortBy) {
		 try {
	            Map<String, Object> response = new HashMap<>();
	            Sort sort = Sort.by(sortBy);
	            Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
	            Page<History> page = historyRepository.findAll(pageable);
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




	




	
		
