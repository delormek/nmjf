package objects;

// Generated Jul 17, 2015 7:51:51 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer idUser;
	private Group group;
	private String FName;
	private String LName;
	private String mailAddress;
	private String password;
	private Date birthDate;
	private Set sharedNotes = new HashSet(0);
	private Set orders = new HashSet(0);

	public User() {
	}

	public User(Group group, String FName, String LName, String mailAddress,
			String password) {
		this.group = group;
		this.FName = FName;
		this.LName = LName;
		this.mailAddress = mailAddress;
		this.password = password;
	}

	public User(Group group, String FName, String LName, String mailAddress,
			String password, Date birthDate, Set sharedNotes, Set orders) {
		this.group = group;
		this.FName = FName;
		this.LName = LName;
		this.mailAddress = mailAddress;
		this.password = password;
		this.birthDate = birthDate;
		this.sharedNotes = sharedNotes;
		this.orders = orders;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	public String getLName() {
		return this.LName;
	}

	public void setLName(String LName) {
		this.LName = LName;
	}

	public String getMailAddress() {
		return this.mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set getSharedNotes() {
		return this.sharedNotes;
	}

	public void setSharedNotes(Set sharedNotes) {
		this.sharedNotes = sharedNotes;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}
