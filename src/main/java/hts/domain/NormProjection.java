package hts.domain;

import org.springframework.beans.factory.annotation.Value;

@Deprecated
public interface NormProjection {

	public abstract String getId();

	public abstract String getName();

	public abstract String getSampleSize();

	@Value("#{target.minAge != null ? target.minAge : ''}-#{target.maxAge != null ? target.maxAge : ''}")
	public abstract String getAgeRestrictions();

	public abstract String getDataSource();

	
}
