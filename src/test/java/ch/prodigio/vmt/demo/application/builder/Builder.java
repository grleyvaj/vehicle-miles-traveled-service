package ch.prodigio.vmt.demo.application.builder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Builder<T> {
	public abstract T build(int index);

	public T build() {
		return this.build(1);
	}

	public List<T> buildList(int items) {
		return Arrays.stream(IntStream.range(0, items).toArray())
			.mapToObj(this::build)
			.collect(Collectors.toList());
	}
}