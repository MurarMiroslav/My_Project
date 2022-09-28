package com.example.scoopcsvdatagenerator.config;

import com.example.scoopcsvdatagenerator.columns.Column;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Random;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		property = "type")
@JsonSubTypes({
		@Type(value = IntColumnConfig.class, name = "intColumnConfig"),
		@Type(value = StringColumnConfig.class, name = "stringColumnConfig"),
		@Type(value = BooleanColumnConfig.class, name = "booleanColumnConfig")
})
@FunctionalInterface
public interface ColumnConfig<T extends Column> {

	T buildColumn(Random random);

}
