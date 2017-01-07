package hts.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "withFullName", types = { Test.class })
public interface TestProjection {

    public abstract String getId();

    @Value("#{target.name}.#{target.version}.#{target.language}")
    public abstract String getFullName();

    public abstract String getName();

    public abstract String getLanguage();
	
	
}
