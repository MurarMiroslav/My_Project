package mm.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import lombok.Data;

public enum EnumAttribut {
	INPUT("INPUT"),
	OUTPUT("OUTPUT");

	private String value;

	private EnumAttribut(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return this.value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}


	@JsonCreator
	public static EnumAttribut fromValue(String value) {
		EnumAttribut[] var1 = values();
		int var2 = var1.length;

		for(int var3 = 0; var3 < var2; ++var3) {
			EnumAttribut b = var1[var3];
			if (b.value.equals(value)) {
				return b;
			}
		}

		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}
}
