package mnm.hibernate;
// default package
// Generated Apr 11, 2010 12:10:19 AM by Hibernate Tools 3.2.2.GA

/**
 * Coursegroup generated by hbm2java
 */
public class Coursegroup implements java.io.Serializable {

	private Integer id;
	private String name;
	private int idSubgroup;

	public Coursegroup() {
	}

	public Coursegroup(String name, int idSubgroup) {
		this.name = name;
		this.idSubgroup = idSubgroup;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdSubgroup() {
		return this.idSubgroup;
	}

	public void setIdSubgroup(int idSubgroup) {
		this.idSubgroup = idSubgroup;
	}

}
