package objects;

// Generated Jul 8, 2015 3:09:09 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	public static final String USER_LBL_IN_SESSION = "userInfo";
	private Integer idUser;
	private String FName;
	private String LName;
	private String mailAddress;
	private String password;
	private Date birthDate;
	private Set<SharedNote> sharedNotesForIdUserRec = new HashSet<SharedNote>(0);
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<SharedNote> sharedNotesForIdUserCre = new HashSet<SharedNote>(0);
	private Set<Refrigerator> refrigerators = new HashSet<Refrigerator>(0);

	public User() {
	}

	public User(String FName, String LName, String mailAddress, String password) {
		this.FName = FName;
		this.LName = LName;
		this.mailAddress = mailAddress;
		this.password = password;
	}

	public User(String FName, String LName, String mailAddress,
			String password, Date birthDate,Set<SharedNote> sharedNotesForIdUserRec,
			Set<Order> orders, Set<SharedNote> sharedNotesForIdUserCre, Set<Refrigerator> refrigerators) {
		this.FName = FName;
		this.LName = LName;
		this.mailAddress = mailAddress;
		this.password = password;
		this.birthDate = birthDate;
		this.sharedNotesForIdUserRec =  sharedNotesForIdUserRec;
		this.orders = orders;
		this.sharedNotesForIdUserCre =  sharedNotesForIdUserCre;
		this.refrigerators =  refrigerators;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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

	public Set<SharedNote> getSharedNotesForIdUserRec() {
		return this.sharedNotesForIdUserRec;
	}

	public void setSharedNotesForIdUserRec(Set<SharedNote> sharedNotesForIdUserRec) {
		this.sharedNotesForIdUserRec = sharedNotesForIdUserRec;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<SharedNote> getSharedNotesForIdUserCre() {
		return this.sharedNotesForIdUserCre;
	}

	public void setSharedNotesForIdUserCre(Set<SharedNote> sharedNotesForIdUserCre) {
		this.sharedNotesForIdUserCre = sharedNotesForIdUserCre;
	}

	public Set<Refrigerator> getRefrigerators() {
		return this.refrigerators;
	}

	public void setRefrigerators(Set<Refrigerator> refrigerators) {
		this.refrigerators = refrigerators;
	}

}
