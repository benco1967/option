package net.dericbourg.util.option;

public final class Optional {
    private Optional() {
        throw new AssertionError();
    }

    public static <T> Option<T> some(T value) {
        return new OptionSome<T>(value);
    }

    @SuppressWarnings("unchecked")
    public static <T> Option<T> none() {
        return (Option<T>) OptionNone.VALUE;
    }
}
