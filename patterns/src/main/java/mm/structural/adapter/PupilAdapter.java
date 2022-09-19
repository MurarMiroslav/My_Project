package mm.structural.adapter;

public class PupilAdapter implements Student {

	private final Pupil pupil;

	public PupilAdapter(Pupil pupil) {
		this.pupil = pupil;
	}

	@Override
	public String getFullName() {
		return pupil.getName() + " " + pupil.getLastname();
	}

	@Override
	public String getEmail() {
		return pupil.getEmailContact();
	}

	@Override
	public boolean isAdult() {
		return Long.parseLong(pupil.getAge()) > 18;
	}
}
