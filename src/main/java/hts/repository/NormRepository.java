package hts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import hts.domain.Norm;

@RepositoryRestResource(collectionResourceRel="norm",path="norm") 
public interface NormRepository extends CrudRepository<Norm, Long> {
	
	@Query(value = "select n from Norm n where n.test.id = :testid")
	List<Norm> findByTestId(@Param("testid")Long testId);
	
	@Override
	@RestResource(exported = false)
	void delete(Long id);
	
}
