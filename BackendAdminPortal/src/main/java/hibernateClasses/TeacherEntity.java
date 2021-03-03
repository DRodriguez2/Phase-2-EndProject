package hibernateClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teachers")
public class TeacherEntity {
	
	@Id
	private int teacherID;
	private String firstName;
	private String lastName;
	
	public TeacherEntity(int _teacherID, String _firstName, String _lastName) {
		this.teacherID = _teacherID;
		this.firstName = _firstName;
		this.lastName = _lastName;
	}
	
	public TeacherEntity() {
		
	}
	
	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
