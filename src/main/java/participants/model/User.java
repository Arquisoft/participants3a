package participants.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Representa a un usuario en la base de datos
 * 
 * @author UO246008
 *
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	private String email;

	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private Date birthday;
	
	@NotNull
	private String address;
	
	@NotNull
	private String nationality;
	
	@NotNull
	private String identDocument;
	
	User() {}
	
	public User(String email, String firstName, String lastName, Date birthday,
			String address, String nationality, String identDocument) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.address = address;
		this.nationality = nationality;
		this.identDocument = identDocument;
	}
	
	public long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public String getIdentDocument() {
		return identDocument;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public void setIdentDocument(String identDocument) {
		this.identDocument = identDocument;
	}
}
