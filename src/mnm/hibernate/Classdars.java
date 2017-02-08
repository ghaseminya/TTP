package mnm.hibernate;
// default package
// Generated Apr 11, 2010 12:10:19 AM by Hibernate Tools 3.2.2.GA

/**
 * Classdars generated by hbm2java
 */
public class Classdars implements java.io.Serializable {

	private Integer generid;
	private byte id;
	private String name;
	private String master;
	private String code;
	private Integer mascode;
	private Double vahed;
	private String generidstr;

	public Classdars() {
	}

	public Classdars(byte id, String generidstr) {
		this.id = id;
		this.generidstr = generidstr;
	}

	public Classdars(byte id, String name, String master, String code,
			Integer mascode, Double vahed, String generidstr) {
		this.id = id;
		this.name = name;
		this.master = master;
		this.code = code;
		this.mascode = mascode;
		this.vahed = vahed;
		this.generidstr = generidstr;
	}

	public Integer getGenerid() {
		return this.generid;
	}

	public void setGenerid(Integer generid) {
		this.generid = generid;
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaster() {
		return this.master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getMascode() {
		return this.mascode;
	}

	public void setMascode(Integer mascode) {
		this.mascode = mascode;
	}

	public Double getVahed() {
		return this.vahed;
	}

	public void setVahed(Double vahed) {
		this.vahed = vahed;
	}

	public String getGeneridstr() {
		return this.generidstr;
	}

	public void setGeneridstr(String generidstr) {
		this.generidstr = generidstr;
	}

}
