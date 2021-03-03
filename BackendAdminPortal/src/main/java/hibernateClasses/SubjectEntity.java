package hibernateClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subjects")
public class SubjectEntity {

	@Id
	private String subject;
	
	public SubjectEntity (String _subject) {
		this.subject = _subject;
	}
	public SubjectEntity() {
		
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
