package net.dericbourg.util.option;

/**
 * Represents optional values.
 * 
 * @author adericbourg
 * 
 * @param <T> Value type.
 */
public interface Option<T> {
	/**
	 * Return the option's value if the option is nonempty. Otherwise, throws
	 * UndefinedOptionException.
	 * 
	 * @return Option's value if defined.
	 */
	T get();

	/**
	 * Returns the option's value if the option is nonempty, otherwise return
	 * the fall-back value.
	 * 
	 * @param fallBackValue Fall-back value.
	 * @return Option's value if defined or fall-back value if not.
	 */
	<F extends T> T getOrElse(F fallBackValue);

	/**
	 * Returns <code>true</code> if the option is an instance of
	 * {@link OptionSome}, <code>false</code> otherwise.
	 * 
	 * @return
	 */
	boolean isDefined();

	/**
	 * Returns the option's value if the option is nonempty, otherwise throw the
	 * specified exception.
	 * 
	 * @param e Exception class (must have a single-String parameter
	 *            constructor).
	 * @param message Message passed to exception.
	 * @return Option's value if defined or throws exception.
	 * @throws E Thrown when option is not defined.
	 */
	<E extends Exception> T getValueOrThrowException(Class<E> e, String message)
			throws E;
}
