package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/check-in")
public class CheckController {

	@Autowired
	private CheckRepo checkrepo;
	
	@GetMapping
	public Page<Check_in> getAll(@PathVariable Integer pageNumber,@PathVariable Integer size){
		Pageable p = PageRequest.of(pageNumber,size);
		return checkrepo.findAll(p);
	}
	
	@GetMapping("/sort")
	public List<Check_in> sort(@RequestParam String sortBy){
		Sort s = Sort.by(sortBy);
		return checkrepo.findAll(s);
	}
	
	
	@PostMapping
	public Check_in create(@RequestBody Check_in check) {
		return checkrepo.save(check);
	}
	
	@GetMapping("/{id}")
	public Check_in findById(@PathVariable Long id) throws Exception {
		Check_in ch = checkrepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		return ch;
	}
	
	@PutMapping("/{id}")
	public Check_in Updatecreate(@RequestBody Check_in check,@PathVariable Long id) throws Exception {
		Check_in ch = checkrepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		ch.setId(check.getId());
		ch.setH_name(check.getH_name());
		ch.setGuests(check.getGuests());
		return checkrepo.save(ch);
	}
	
	@DeleteMapping("/{id}")
	public void del(@PathVariable Long id) {
		checkrepo.deleteById(id);
	}
	
}
