package mm.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DTOEnumAttribut {
	INPUT,
	OUTPUT

//	INPUT("INPUT"),
//	OUTPUT("OUTPUT");
//
//	private String value;
//
//	private DTOEnumAttribut(String value) {
//		this.value = value;
//	}
//
//	@JsonValue
//	public String getValue() {
//		return this.value;
//	}
//
//	public String toString() {
//		return String.valueOf(this.value);
//	}
//
//
//	@JsonCreator
//	public static DTOEnumAttribut fromValue(String value) {
//		DTOEnumAttribut[] var1 = values();
//		int var2 = var1.length;
//
//		for(int var3 = 0; var3 < var2; ++var3) {
//			DTOEnumAttribut b = var1[var3];
//			if (b.value.equals(value)) {
//				return b;
//			}
//		}
//
//		throw new IllegalArgumentException("Unexpected value '" + value + "'");
//	}
}
