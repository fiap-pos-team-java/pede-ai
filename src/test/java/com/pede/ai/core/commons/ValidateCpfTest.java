package com.pede.ai.core.commons;

import com.pede.ai.core.exceptions.InvalidCpfException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ValidateCpfTest {

    @InjectMocks
    private ValidateCpf validateCpf;

    @Test
    public void invalidCpfTooShortTest() {
        assertThrows(InvalidCpfException.class, () -> validateCpf.isCPF("123456789"));
    }

    @Test
    public void invalidCpfTooLongTest() {
        assertThrows(InvalidCpfException.class, () -> validateCpf.isCPF("123456789012"));
    }

    @Test
    public void invalidCpfInvalidFormatTest() {
        assertThrows(InvalidCpfException.class, () -> validateCpf.isCPF("1234A567890"));
    }

    @Test
    public void invalidFirstCheckDigitsTest() {
        assertThrows(InvalidCpfException.class, () -> validateCpf.isCPF("46134543871"));
    }

    @Test
    public void invalidSecondCheckDigitsTest() {
        assertThrows(InvalidCpfException.class, () -> validateCpf.isCPF("38080997803"));
    }

}
