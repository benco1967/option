package net.dericbourg.util.option;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertSame;

import org.junit.Test;

public class OptionTest {
    @Test
    public void simpleUseCasesSome() {
        String value = "simpleUseCases";
        String valueOther = "simpleUseCases Other";
        //Some
        Option<String> Option = Optional.some(value);
        assertEquals(value, Option.get());
        assertEquals(value, Option.getOrElse(valueOther));
        assertNotSame(valueOther, Option.get());
        assertNotSame(valueOther, Option.getOrElse(valueOther));
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
        Option<String> Option = Optional.some(null);
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
        //Some - self-consistency
        assertSame(option, option); //identity check
        assertEquals(option, optionSame); //content check
        assertEquals(optionSame, option); //symmetry check
        assertNotSame(option, optionDifferent); //identity and content check
        assertNotSame(optionDifferent, option); //symmetry check
        //None - self-consistency
        assertSame(optionNone, optionNoneSame); //identity check
        assertSame(optionNoneSame, optionNone); //symmetry check
        //Some-vs-None consistency
        assertNotSame(option, optionNone); //identity check
        assertNotSame(optionNone, option); //symmetry check
    }
}
