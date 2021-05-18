package com.thanhsang.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thanhsang.dto.NewDTO;
import com.thanhsang.service.INewService;

@CrossOrigin
@RestController
public class NewAPI {

	@Autowired
	private INewService newService;
	
	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO dto) {
		return newService.save(dto);
	}
	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO dto,@PathVariable("id") long id) {
		dto.setId(id);
		return newService.save(dto);
	}
	@DeleteMapping(value = "/new/{id}")
	public NewDTO deleteNew(@PathVariable("id") long id) {
		return newService.delete(id);
	}
}
