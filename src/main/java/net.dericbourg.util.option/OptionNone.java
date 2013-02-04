package net.dericbourg.util.option;

enum OptionNone implements Option<Object> {
    VALUE;
    public Object get() {
        throw new UndefinedOptionException();
    }

    public boolean isDefined() {
        return false;
    }

    public <E extends Exception> Object getValueOrThrowException(Class<E> e, String message) throws E {
        throw new UndefinedOptionException();
    }

    public <F extends Object> Object getOrElse(F fallBackValue) {
        return fallBackValue;
    }
}
