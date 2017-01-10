package hts.controller;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hts.domain.Test;
import hts.repository.TestRepository;

@RestController
@RequestMapping("/rest/test")
public class TestRestController {

	@Autowired
	private TestRepository testRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Test getTest(@PathVariable Long id) {
		return testRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Test> getTest() {
		return StreamSupport
				.stream(Spliterators.spliteratorUnknownSize(testRepository.findAll().iterator(), Spliterator.ORDERED),
						false)
				.collect(Collectors.toList());
	}

}