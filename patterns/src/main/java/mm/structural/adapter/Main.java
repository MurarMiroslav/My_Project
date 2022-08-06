package mm.structural.adapter;

public class Main {

	public static void main(String[] args) {

		Pupil pupil = new Pupil("Miroslav", "Murar", "mm@gmail.com", "32");
		Student student = new PupilAdapter(pupil);

		System.out.println(student.getFullName());
		System.out.println(student.getEmail());
		System.out.println(student.isAdult());
	}
}
