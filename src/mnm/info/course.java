package mnm.info;

public class course {
	private String name;
	private int vahed;
	private int id;
	private String code;
	private String reshte;
	
	
	private String oldavg;
	private String easily;

	public course(String name, int vahed, int id) {
		
		this.name = name;
		this.vahed = vahed;
		this.id = id;
		
	}
public course() {
		
		
	}
	public course(String name, int vahed, int id, String code, String reshte,
			String oldavg, String easily) {
		super();
		this.name = name;
		this.vahed = vahed;
		this.id = id;
		this.code = code;
		this.reshte = reshte;
		this.oldavg = oldavg;
		this.easily = easily;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVahed() {
		return vahed;
	}
	public void setVahed(int vahed) {
		this.vahed = vahed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getReshte() {
		return reshte;
	}
	public void setReshte(String reshte) {
		this.reshte = reshte;
	}
	public String getOldavg() {
		return oldavg;
	}
	public void setOldavg(String oldavg) {
		this.oldavg = oldavg;
	}
	public String getEasily() {
		return easily;
	}
	public void setEasily(String easily) {
		this.easily = easily;
	}
	
	
	
	
	

}
