package com.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ResourceNotFoundException;
import com.model.Contest;
import com.model.People;
import com.repository.ContestRepository;
import com.repository.PeopleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AppController {
	@Autowired
	private ContestRepository contestRepository;
	
	@Autowired
	private PeopleRepository peopleRepository;

	@GetMapping("/getdata")
	public List<Contest> getAllData() {
		return contestRepository.findAll();
	}
	
	@GetMapping("/getpeople")
	public List<People> getPeopleData() {
		System.out.println("In Get People");
		return peopleRepository.findAll();
	}
	
	/*@GetMapping("/getperson")
	public List<People> getPersonData() {
		return peopleRepository.findAll();
	}*/
	
	@PostMapping("/setdata")
	public List<Contest> createData(@Valid @RequestBody List<Contest> data) {
		
		for(Contest c:data) {
			System.out.println(
					c.getFirstName() + "\t" + c.getLastName() + "\t" + c.getAddress() + "\t" + c.getCity() + "\t"	+ 
							c.getState() + "\t" + c.getZip() + "\t" + c.getContact() + "\t" + c.getEmailId());
		}
		
		return contestRepository.saveAll(data);
	}
	
	@PostMapping("/setpeople")
	public List<People> createPeople(@Valid @RequestBody List<People> data) {
		
		for(People c:data) {
			System.out.println(
					c.getName() + "\t" + c.getEmail() + "\t" + c.getCountry() + "\t" + c.getDob() + "\t" + c.getAvatar());
		}
		
		return peopleRepository.saveAll(data);
	}

	/*@GetMapping("/singledata/{id}")
	public ResponseEntity<Contest> getdataById(@PathVariable(value = "id") Long dataId)
			throws ResourceNotFoundException {
		Contest data = contestRepository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("data not found for this id :: " + dataId));
		return ResponseEntity.ok().body(data);
	}
	
	@PutMapping("/datas/{id}")
	public ResponseEntity<Contest> updateData(@PathVariable(value = "id") Long dataId,
			@Valid @RequestBody Contest dataDetails) throws ResourceNotFoundException {
		Contest data = contestRepository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("data not found for this id :: " + dataId));

		data.setEmailId(dataDetails.getEmailId());
		data.setLastName(dataDetails.getLastName());
		data.setFirstName(dataDetails.getFirstName());
		final Contest updateddata = contestRepository.save(data);
		return ResponseEntity.ok(updateddata);
	}

	@DeleteMapping("/datas/{id}")
	public Map<String, Boolean> deleteData(@PathVariable(value = "id") Long dataId)
			throws ResourceNotFoundException {
		Contest data = contestRepository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("data not found for this id :: " + dataId));

		dataRepository.delete(data);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}*/
}
