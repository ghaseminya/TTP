package mnm.info;

public class room {
	private int id;
	private int seat;
	private String name;
	private String building;
	private String section;
	private String flor;
	private String lab;
	private String lab2;
	private String lab3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getFlor() {
		return flor;
	}
	public void setFlor(String flor) {
		this.flor = flor;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public String getLab2() {
		return lab2;
	}
	public void setLab2(String lab2) {
		this.lab2 = lab2;
	}
	public String getLab3() {
		return lab3;
	}
	public void setLab3(String lab3) {
		this.lab3 = lab3;
	}
	
	public room() {
		
	}
	public room(int id, int seat, String name, String building, String section,
			String flor, String lab, String lab2, String lab3) {
		this.id = id;
		this.seat = seat;
		this.name = name;
		this.building = building;
		this.section = section;
		this.flor = flor;
		this.lab = lab;
		this.lab2 = lab2;
		this.lab3 = lab3;
	}
}
