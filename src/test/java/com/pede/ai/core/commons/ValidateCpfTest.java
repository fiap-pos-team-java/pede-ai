package com.pede.ai.core.commons;

import com.pede.ai.core.exceptions.NotValidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ValidateCpfTest {

    @Test
    public void invalidCpfTooShortTest() {
        assertThrows(NotValidException.class, () -> new Cpf("123456789"));
    }

    @Test
    public void invalidCpfTooLongTest() {
        assertThrows(NotValidException.class, () -> new Cpf("123456789012"));
    }

    @Test
    public void invalidCpfInvalidFormatTest() {
        assertThrows(NotValidException.class, () -> new Cpf("1234A567890"));
    }

    @Test
    public void invalidFirstCheckDigitsTest() {
        assertThrows(NotValidException.class, () -> new Cpf("46134543871"));
    }

    @Test
    public void invalidSecondCheckDigitsTest() {
        assertThrows(NotValidException.class, () -> new Cpf("38080997803"));
    }

}
