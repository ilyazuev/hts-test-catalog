package hts.controller;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hts.domain.Norm;
import hts.repository.NormRepository;

@RestController
public class NormRestController {

	@Autowired
	private NormRepository normRepository;

	@RequestMapping(method = RequestMethod.GET, path = "rest/test/{testId}/norms")
	@Cacheable("norms")
	public List<Norm> getTestForm(@PathVariable Long testId) {
		return StreamSupport.stream(Spliterators
				.spliteratorUnknownSize(normRepository.findByTestId(testId).iterator(), Spliterator.ORDERED), false)
				.collect(Collectors.toList());
	}

}