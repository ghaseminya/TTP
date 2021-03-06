package mnm.hibernate;
// default package
// Generated Apr 11, 2010 12:10:19 AM by Hibernate Tools 3.2.2.GA

/**
 * CourseId generated by hbm2java
 */
public class CourseId implements java.io.Serializable {

	private int id;
	private String name;

	public CourseId() {
	}

	public CourseId(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CourseId))
			return false;
		CourseId castOther = (CourseId) other;

		return (this.getId() == castOther.getId())
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		return result;
	}

}
