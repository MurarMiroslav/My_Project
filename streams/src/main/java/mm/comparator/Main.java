package mm.comparator;

import java.util.Comparator;
import mm.pojo.Person;

public class Main {

	public static void main(String[] args) {

		Comparator<Person> comparatorPerson =
//				Comparator.comparingInt(person -> Integer.parseInt(person.getAge()));
//				(person1, person2) -> Integer.compare(Integer.parseInt(person1.getAge()), Integer.parseInt(person2.getAge()));
				(person1, person2) -> {
					if (person1.getSurname().equals(person2.getSurname())) {
						return 0;
					} else if (Integer.parseInt(person1.getAge()) > Integer.parseInt(person2.getAge())) {
						return 1;
					} else {
						return -1;
					}
				};

		Person miroPerson = new Person("Miro", "Murar", "33");
		Person misoPerson = new Person("Michal", "Kurbel", "32");
		int x = comparatorPerson.compare(miroPerson, misoPerson);

		System.out.println("x: " + x);
	}
}
