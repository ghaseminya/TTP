package mnm.hibernate;
// default package
// Generated Apr 11, 2010 12:10:19 AM by Hibernate Tools 3.2.2.GA

/**
 * Masters generated by hbm2java
 */
public class Masters implements java.io.Serializable {

	private Byte id;
	private String name;
	private String limitation;
	private String teach;
	private Byte schollid;
	private String persenelid;
	private String comment;
	private String teachid;
	private int sum;
	private int act;

	public Masters() {
	}

	public Masters(int sum, int act) {
		this.sum = sum;
		this.act = act;
	}

	public Masters(String name, String limitation, String teach, Byte schollid,
			String persenelid, String comment, String teachid, int sum, int act) {
		this.name = name;
		this.limitation = limitation;
		this.teach = teach;
		this.schollid = schollid;
		this.persenelid = persenelid;
		this.comment = comment;
		this.teachid = teachid;
		this.sum = sum;
		this.act = act;
	}

	public Byte getId() {
		return this.id;
	}

	public void setId(Byte id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLimitation() {
		return this.limitation;
	}

	public void setLimitation(String limitation) {
		this.limitation = limitation;
	}

	public String getTeach() {
		return this.teach;
	}

	public void setTeach(String teach) {
		this.teach = teach;
	}

	public Byte getSchollid() {
		return this.schollid;
	}

	public void setSchollid(Byte schollid) {
		this.schollid = schollid;
	}

	public String getPersenelid() {
		return this.persenelid;
	}

	public void setPersenelid(String persenelid) {
		this.persenelid = persenelid;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTeachid() {
		return this.teachid;
	}

	public void setTeachid(String teachid) {
		this.teachid = teachid;
	}

	public int getSum() {
		return this.sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getAct() {
		return this.act;
	}

	public void setAct(int act) {
		this.act = act;
	}

}
