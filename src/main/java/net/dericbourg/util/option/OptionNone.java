package net.dericbourg.util.option;

/**
 * {@link Option} implementation when option is not defined.
 * 
 * @author adericbourg
 * 
 */
enum OptionNone implements Option<Object> {
	VALUE;

	/** {@inheritDoc} */
	@Override
	public Object get() {
		throw new UndefinedOptionException();
	}

	/** {@inheritDoc} */
	@Override
	public boolean isDefined() {
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public <E extends Exception> Object getValueOrThrowException(Class<E> e,
			String message) throws E {
		throw new UndefinedOptionException();
	}

	/** {@inheritDoc} */
	@Override
	public <F extends Object> Object getOrElse(F fallBackValue) {
		return fallBackValue;
	}
}
