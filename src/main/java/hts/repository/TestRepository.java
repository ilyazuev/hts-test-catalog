package hts.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import hts.domain.Test;
import hts.domain.TestProjection;

@RepositoryRestResource(collectionResourceRel = "test", path = "test",excerptProjection=TestProjection.class)
public interface TestRepository extends PagingAndSortingRepository<Test, Long> { // TestDao+TestController
	
	List<Test> findByName(@Param("name") String name);

	@Override
	@RestResource(exported = false)
	void delete(Long id);

	@Override
	@RestResource(exported = false)
	void delete(Test entity);

}
