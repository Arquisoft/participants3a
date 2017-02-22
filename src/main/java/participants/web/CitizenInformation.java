package participants.web;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class CitizenInformation {
	
	private Long id;	
	
	private String firstName;
	private String lastName;
	private int  age;
	private String email;
	
	public CitizenInformation(Long id, String firstName, String lastName,
			Date birthday, String email) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = getAge(birthday);
		this.email = email;
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
}
