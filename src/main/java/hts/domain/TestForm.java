package hts.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name="TestForm.findByName",query="SELECT tf FROM TestForm tf WHERE LOWER(tf.name) = LOWER(?1)")
public class TestForm {
	
	@NotNull
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Test test;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull
	private String name;
	@NotNull
	@Column(unique=true)
	private String qtiId;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQtiId() {
		return qtiId;
	}
	public void setQtiId(String qtiId) {
		this.qtiId = qtiId;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
