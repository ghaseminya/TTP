package mnm.hibernate;
// default package
// Generated Apr 11, 2010 12:10:19 AM by Hibernate Tools 3.2.2.GA

/**
 * Schollhour generated by hbm2java
 */
public class Schollhour implements java.io.Serializable {

	private Integer id;
	private int scholid;
	private String name;
	private int count;

	public Schollhour() {
	}

	public Schollhour(int scholid, String name, int count) {
		this.scholid = scholid;
		this.name = name;
		this.count = count;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getScholid() {
		return this.scholid;
	}

	public void setScholid(int scholid) {
		this.scholid = scholid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
