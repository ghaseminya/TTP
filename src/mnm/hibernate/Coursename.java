package mnm.hibernate;
// default package
// Generated Apr 11, 2010 12:10:19 AM by Hibernate Tools 3.2.2.GA

/**
 * Coursename generated by hbm2java
 */
public class Coursename implements java.io.Serializable {

	private Integer id;
	private String name;
	private int idGroup;

	public Coursename() {
	}

	public Coursename(String name, int idGroup) {
		this.name = name;
		this.idGroup = idGroup;
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

	public int getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

}
