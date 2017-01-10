package hts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import hts.domain.TestExtra;

@RepositoryRestResource(collectionResourceRel = "testextra", path = "testextra")
public interface TestExtraRepository extends CrudRepository<TestExtra, Long> {

	@Override
	TestExtra findOne(Long id);

	@Override
	@RestResource(exported = false)
	void delete(Long id);

}
