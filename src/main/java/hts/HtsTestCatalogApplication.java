package hts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@Import({ WebMvcConfig.class, RepositoryRestMvcConf.class })
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableCaching
public class HtsTestCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtsTestCatalogApplication.class, args);
	}
}
