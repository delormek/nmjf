package objects;

// Generated Jul 17, 2015 12:09:18 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Note generated by hbm2java
 */
public class Note implements java.io.Serializable {

	private Integer idNote;
	private String content;
	private Date date;
	private Set sharedNotes = new HashSet(0);

	public Note() {
	}

	public Note(String content, Date date) {
		this.content = content;
		this.date = date;
	}

	public Note(String content, Date date, Set sharedNotes) {
		this.content = content;
		this.date = date;
		this.sharedNotes = sharedNotes;
	}

	public Integer getIdNote() {
		return this.idNote;
	}

	public void setIdNote(Integer idNote) {
		this.idNote = idNote;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set getSharedNotes() {
		return this.sharedNotes;
	}

	public void setSharedNotes(Set sharedNotes) {
		this.sharedNotes = sharedNotes;
	}

}
