package com.xiuye.util;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class OpW<T> {

	public static final OpW<?> EMPTY = new OpW<>();

	private T value;

	public OpW(T t) {
		this.value = t;
	}

	public OpW() {
		this(null);
	}

	public T get() {
		return this.value;
	}
	
	public static <T> OpW<T> of(T t) {
		return new OpW<T>(t);
	}

	@SuppressWarnings("unchecked")
	public static <R> OpW<R> empty() {
		return (OpW<R>) EMPTY;
	}

	public void ifTrue(Runnable f) {
		if ((boolean) this.value)
			this.doIt(f);
	}

	public <R> OpW<R> ifTrue(Supplier<R> f) {
		if ((boolean) this.value)
			return this.doIt(f);
		return empty();
	}

	public void ifFalse(Runnable f) {
		if (!(boolean) this.value)
			this.doIt(f);
	}

	public <R> OpW<R> ifFalse(Supplier<R> f) {
		if (!(boolean) this.value)
			return this.doIt(f);
		return empty();
	}

	public <R> OpW<R> ifPresent(Function<T, R> f) {
		return this.doIt(f);
	}

	public void ifPresent(Consumer<T> f) {
		this.doIt(f);
	}

	public <R> OpW<R> ifNull(Supplier<R> f) {
		if (Objects.isNull(this.value))
			return this.doIt(f);
		return empty();
	}

	public void ifNull(Runnable r) {
		if (Objects.isNull(this.value))
			this.doIt(r);
	}

	public <R> OpW<R> ifNonNull(Function<T, R> f) {
		if (Objects.nonNull(this.value))
			return this.doIt(f);
		return empty();
	}

	public void ifNonNull(Consumer<T> c) {
		if (Objects.nonNull(this.value))
			this.doIt(c);
	}

	public <R> OpW<R> doIt(Function<T, R> f) {
		return of(f.apply(this.value));
	}

	public <R> OpW<R> doIt(Supplier<R> c) {
		return of(c.get());
	}

	public void doIt(Consumer<T> c) {
		c.accept(this.value);
	}

	public void doIt(Runnable r) {
		r.run();
	}

}
