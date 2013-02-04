package net.dericbourg.util.option;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 * @author adericbourg
 * 
 * @param <T>
 */
class OptionSome<T> implements Option<T> {

	private final T value;

	OptionSome(T value) {
		if (value == null) {
			throw new UndefinedOptionException();
		}
		this.value = value;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isDefined() {
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public T get() {
		return value;
	}

	/** {@inheritDoc} */
	@Override
	public <F extends T> T getOrElse(F fallBackValue) {
		return value;
	}

	/** {@inheritDoc} */
	@Override
	public <E extends Exception> T getValueOrThrowException(Class<E> e,
			String message) throws E {
		if (isDefined()) {
			return value;
		}
		return throwException(e, message);
	}

	private <E extends Exception> T throwException(Class<E> exceptionClass,
			String message) throws E {
		final E exception;
		try {
			final Constructor<E> constructor = exceptionClass
					.getConstructor(String.class);
			exception = constructor.newInstance(message);
			throw exception;
		} catch (InstantiationException e) {
			throw new UnableToThrowSpecifiedExceptionException(e);
		} catch (IllegalAccessException e) {
			throw new UnableToThrowSpecifiedExceptionException(e);
		} catch (NoSuchMethodException e1) {
			throw new UnableToThrowSpecifiedExceptionException("Class "
					+ exceptionClass.getName()
					+ " does not have a constructor taking a String", e1);
		} catch (InvocationTargetException e) {
			throw new UnableToThrowSpecifiedExceptionException(e);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		OptionSome<T> other = (OptionSome) obj;
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}
}
