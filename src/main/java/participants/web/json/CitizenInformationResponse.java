package participants.web.json;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import participants.model.Ciudadano;

/**
 * Representa la información que irá en el JSON cuando se 
 * envíen sus datos al usuario
 * 
 * @author UO247242
 * 
 */
public class CitizenInformationResponse {
	
	private Long id;	
	
	private String firstName;
	private String lastName;
	private int  age;
	private String email;
	
	public CitizenInformationResponse(Ciudadano ciudadano) {
		
		this.id = ciudadano.getId();
		this.firstName = ciudadano.getNombre();
		this.lastName = ciudadano.getApellidos();
		this.age = getAge((Date) ciudadano.getFechaNacimiento());
		this.email = ciudadano.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}
	
	public int getAge(Date birth) {   	

		LocalDate birthday = birth.toLocalDate();
		LocalDate now = LocalDate.now();

		int age = Period.between(birthday, now).getYears();

		return age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CitizenInformationResponse other = (CitizenInformationResponse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}		
}
