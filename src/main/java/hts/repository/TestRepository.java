package hts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import hts.domain.Test;
import hts.domain.TestProjection;

@RepositoryRestResource(collectionResourceRel = "test", path = "test", excerptProjection=TestProjection.class)
public interface TestRepository extends PagingAndSortingRepository<Test, Long> {
	
	List<Test> findByName(@Param("name") String name);

	
	@Query("Select t from Test t, TestExtra te where t.id=te.id and (t.name like %:query% or te.description like %:query% or te.quickOverview like %:query%)")
	List<Test> findByNameAndDescriptionsContaining(@Param("query") String query);
	

	@Override
	@RestResource(exported = false)
	void delete(Long id);

	@Override
	@RestResource(exported = false)
	void delete(Test entity);

}
