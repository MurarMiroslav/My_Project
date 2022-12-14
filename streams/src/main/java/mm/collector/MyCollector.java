package mm.collector;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollector<T> implements Collector<T, Builder<T>, ImmutableSet<T>> {

	@Override
	public Supplier<Builder<T>> supplier() {
		return ImmutableSet::builder;
	}

	@Override
	public BiConsumer<Builder<T>, T> accumulator() {
		return ImmutableSet.Builder::add;
	}

	@Override
	public BinaryOperator<Builder<T>> combiner() {
		return (left, right) -> left.addAll(right.build());
	}

	@Override
	public Function<Builder<T>, ImmutableSet<T>> finisher() {
		return ImmutableSet.Builder::build;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Sets.immutableEnumSet(Characteristics.UNORDERED);
	}

	public static <T> MyCollector<T> toImmutableSet() {
		return new MyCollector<>();
	}
}
