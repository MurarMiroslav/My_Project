package mm.structural.adapter;

import lombok.Getter;

@Getter
public class Pupil {

	private final String name;
	private final String lastname;
	private final String emailContact;
	private final String age;

	public Pupil(String name, String lastname, String emailContact, String age) {
		this.name = name;
		this.lastname = lastname;
		this.emailContact = emailContact;
		this.age = age;
	}
}
