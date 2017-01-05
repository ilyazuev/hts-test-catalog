package hts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import hts.domain.TestForm;


@RepositoryRestResource(collectionResourceRel="testform",path="testform")
public interface TestFormRepository extends PagingAndSortingRepository<TestForm, Long> { // TestFormDao + TestFormController
	
	List<TestForm> findByName(@Param("name")String name);	
	
	@Query("SELECT tf FROM TestForm tf WHERE tf.test.id=:testid")
	List<TestForm> findByTestId(@Param("testid")Long testId);
	
	@Override
	@RestResource(exported = false)
	void delete(Long id);

	@Override
	@RestResource(exported = false)
	void delete(TestForm entity);	
}
