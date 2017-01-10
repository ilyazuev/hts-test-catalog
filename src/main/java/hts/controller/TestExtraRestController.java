package hts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hts.domain.TestExtra;
import hts.repository.TestExtraRepository;

@RestController
@RequestMapping("/rest/testextra")
public class TestExtraRestController {

	@Autowired
	private TestExtraRepository testExtraRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	@Cacheable("testExtra")
	public TestExtra getTestExtra(@PathVariable Long id) {
		return testExtraRepository.findOne(id);
	}

}