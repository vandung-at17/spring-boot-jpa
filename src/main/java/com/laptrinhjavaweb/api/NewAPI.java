package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.laptrinhjavaweb.api.output.NewOutput;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.dto.NewModel;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.INewRepository;
import com.laptrinhjavaweb.service.INewService;

@RestController

public class NewAPI {

	@Autowired
	private INewService newService;

	@Autowired
	private INewRepository newRepository;

	// @RequestMapping(value = "/new", method= RequestMethod.POST)
	@GetMapping(value = "/new")
	public NewOutput showNew(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		NewOutput result = new NewOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(newService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
		} else {
			result.setListResult(newService.findAll());
		}
		return result;
	}

//	@PutMapping(value = " new/{id}")
//	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
//		model.setId(id);
//		return newService.save(model);
//	}

	@PutMapping(value = "/new")
	public List<NewEntity> updateNew() {
		return newRepository.findByIDLimit(2);
	}

	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}

	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}
}