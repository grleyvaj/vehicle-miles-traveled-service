package ch.prodigio.vmt.demo.application.contract;

public interface Mapper<T, V> {

	V map(T input);
}
