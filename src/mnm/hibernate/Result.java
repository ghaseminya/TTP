package mnm.hibernate;
// default package
// Generated Apr 11, 2010 12:10:19 AM by Hibernate Tools 3.2.2.GA

/**
 * Result generated by hbm2java
 */
public class Result implements java.io.Serializable {

	private Integer id;
	private int darsid;
	private int darstime;
	private int schollid;

	public Result() {
	}

	public Result(int darsid, int darstime, int schollid) {
		this.darsid = darsid;
		this.darstime = darstime;
		this.schollid = schollid;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDarsid() {
		return this.darsid;
	}

	public void setDarsid(int darsid) {
		this.darsid = darsid;
	}

	public int getDarstime() {
		return this.darstime;
	}

	public void setDarstime(int darstime) {
		this.darstime = darstime;
	}

	public int getSchollid() {
		return this.schollid;
	}

	public void setSchollid(int schollid) {
		this.schollid = schollid;
	}

}
