package hts.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table( uniqueConstraints=@UniqueConstraint(columnNames={"DEFAULT_NORM_ID"}) )
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String name;
	@NotNull
	private String version;
	@Column(length = 5, nullable = false)
	private String language = "en-EN";

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "test", optional=false)
	@PrimaryKeyJoinColumn
	private TestExtra testExtra;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "test")
	private List<TestForm> testForms;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "test")
	private List<Norm> norms;

	@ManyToOne //(fetch = FetchType.LAZY)  	
	private Norm defaultNorm;

	
	@Transient
    public String getFullName() {
		return String.format("%s.%s.%s", name, version, language);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TestForm> getTestForms() {
		return testForms;
	}

	public void setTestForms(List<TestForm> testForms) {
		this.testForms = testForms;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Norm getDefaultNorm() {
		return defaultNorm;
	}

	public void setDefaultNorm(Norm defaultNorm) {
		this.defaultNorm = defaultNorm;
	}

	public List<Norm> getNorms() {
		return norms;
	}

	public void setNorms(List<Norm> norms) {
		this.norms = norms;
	}
}
