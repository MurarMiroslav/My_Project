package mm.creational.builder;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;

public class Weapon {

//	private String name;
//	private String type;
//	private Integer damage;
//
//	public Weapon() {
//	}

	private final String name;
	private final String type;
	private final Integer damage;

	private Weapon(String name, String type, Integer damage) {
		this.name = name;
		this.type = type;
		this.damage = damage;
	}

//	public class Builder {
	public static class Builder {

		private String name;
		private String type;
		private Integer damage;

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withType(String type) {
			this.type = type;
			return this;
		}

		public Builder withDamage(Integer damage) {
			this.damage = damage;
			return this;
		}

		public Weapon build() {
			return new Weapon(name, type, damage);
		}
	}

	@Override
	public String toString() {
		return "Weapon{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				", damage=" + damage +
				'}';
	}
}
