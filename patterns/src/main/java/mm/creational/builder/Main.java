package mm.creational.builder;

public class Main {

	public static void main(String[] args) {

		Weapon weapon = new Weapon.Builder()
//		Weapon weapon = new Weapon().new Builder()
				.withName("weapon1")
//				.withType("type1")
				.withDamage(0).build();

		System.out.println("Weapon: " + weapon);

		weapon = new Weapon.Builder()
//		weapon = new Weapon().new Builder()
				.withName("weapon1")
				.withType("type1")
				.withDamage(0).build();
		System.out.println("Weapon: " + weapon);
	}
}
