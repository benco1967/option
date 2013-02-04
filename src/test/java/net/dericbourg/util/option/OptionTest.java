package net.dericbourg.util.option;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class OptionTest {
	@Test
	public void simpleUseCasesSome() {
		String value = "simpleUseCases";
		String valueOther = "simpleUseCases Other";
		// Some
		Option<String> option = Optional.some(value);
		assertEquals(value, option.get());
		assertEquals(value, option.getOrElse(valueOther));
		assertNotSame(valueOther, option.get());
		assertNotSame(valueOther, option.getOrElse(valueOther));
	}

	@Test
	public void simpleUseCasesNone() {
		String value = "simpleUseCases";
		String valueOther = "simpleUseCases Other";
		Option<String> optionNone = Optional.none();
		assertEquals(valueOther, optionNone.getOrElse(valueOther));
		assertNotSame(value, optionNone.getOrElse(valueOther));
	}

	@Test(expected = UndefinedOptionException.class)
	public void simpleInvalidUseCaseSomePassedNull() {
		@SuppressWarnings("unused")
		Option<String> option = Optional.some(null);
	}

	@Test(expected = UndefinedOptionException.class)
	public void simpleInvalidUseCaseNoneGet() {
		Option<String> optionNone = Optional.none();
		@SuppressWarnings("unused")
		String value = optionNone.get();
	}

	@Test
	public void simpleUseCaseEquals() {
		String value = "simpleUseCases";
		String valueSame = value;
		String valueDifferent = "simpleUseCases Other";
		Option<String> option = Optional.some(value);
		Option<String> optionSame = Optional.some(valueSame);
		Option<String> optionDifferent = Optional.some(valueDifferent);
		Option<String> optionNone = Optional.none();
		Option<String> optionNoneSame = Optional.none();
		// Some - self-consistency
		assertSame(option, option); // identity check
		assertEquals(option, optionSame); // content check
		assertEquals(optionSame, option); // symmetry check
		assertNotSame(option, optionDifferent); // identity and content check
		assertNotSame(optionDifferent, option); // symmetry check
		// None - self-consistency
		assertSame(optionNone, optionNoneSame); // identity check
		assertSame(optionNoneSame, optionNone); // symmetry check
		// Some-vs-None consistency
		assertNotSame(option, optionNone); // identity check
		assertNotSame(optionNone, option); // symmetry check
	}
}
