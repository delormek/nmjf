package objects;

// Generated Jul 8, 2015 3:09:09 PM by Hibernate Tools 4.3.1

/**
 * SharedNote generated by hbm2java
 */
public class SharedNote implements java.io.Serializable {

	public static final String SHARED_NOTE_REC = "shared_note_received";
	private SharedNoteId id;
	private Note note;
	private User userByIdUserRec;
	private User userByIdUserCre;
	private int notReadYet;

	public SharedNote() {
	}

	public SharedNote(SharedNoteId id, Note note, User userByIdUserRec,
			User userByIdUserCre, int notReadYet) {
		this.id = id;
		this.note = note;
		this.userByIdUserRec = userByIdUserRec;
		this.userByIdUserCre = userByIdUserCre;
		this.notReadYet = notReadYet;
	}

	public SharedNoteId getId() {
		return this.id;
	}

	public void setId(SharedNoteId id) {
		this.id = id;
	}

	public Note getNote() {
		return this.note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public User getUserByIdUserRec() {
		return this.userByIdUserRec;
	}

	public void setUserByIdUserRec(User userByIdUserRec) {
		this.userByIdUserRec = userByIdUserRec;
	}

	public User getUserByIdUserCre() {
		return this.userByIdUserCre;
	}

	public void setUserByIdUserCre(User userByIdUserCre) {
		this.userByIdUserCre = userByIdUserCre;
	}

	public int getNotReadYet() {
		return this.notReadYet;
	}

	public void setNotReadYet(int notReadYet) {
		this.notReadYet = notReadYet;
	}

}
