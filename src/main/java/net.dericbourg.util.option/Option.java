package net.dericbourg.util.option;

public interface Option<T> {
    T get();

    <F extends T> T getOrElse(F fallBackValue);

    boolean isDefined();

    <E extends Exception> T getValueOrThrowException(Class<E> e, String message) throws E;
}
