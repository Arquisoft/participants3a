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
	
	@NotNull
	private String password;
	
	User() {}
	
	public User(String email, String firstName, String lastName, Date birthday,
			String address, String nationality, String identDocument, String password) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.address = address;
		this.nationality = nationality;
		this.identDocument = identDocument;
		this.password = password;
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
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}
