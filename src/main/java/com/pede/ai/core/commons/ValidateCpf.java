package com.pede.ai.core.commons;

import com.pede.ai.core.exceptions.InvalidCpfException;

public class ValidateCpf {

    private int firstCheckDigit;
    private int secondCheckDigit;
    private String cpf;

    public void isCPF(String requestCpf) {
        this.cpf = requestCpf;

        validateCPFLength();
        validateNonNumericCharacters();
        validateCheckDigits();
    }

    private void validateCPFLength() {
        if (this.cpf.length() != 11) {
            throw new InvalidCpfException("Invalid CPF size");
        }
    }

    private void validateNonNumericCharacters() {
        if (!cpf.matches("[0-9]+")) {
            throw new InvalidCpfException("Invalid CPF characters");
        }
    }

    private void validateCheckDigits() {
        calculateFirstCheckDigit();
        calculateSecondCheckDigit();
        compareCheckDigits();
    }

    private void calculateFirstCheckDigit() {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Integer.parseInt(Character.toString(this.cpf.charAt(i)));
            sum += (10 - i) * digit;
        }

        int rest = (sum * 10) % 11;
        if (rest == 10) {
            this.firstCheckDigit = 0;
        } else {
            this.firstCheckDigit = rest;
        }
    }

    private void calculateSecondCheckDigit() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int digit = Integer.parseInt(Character.toString(cpf.charAt(i)));
            sum += (11 - i) * digit;
        }

        int rest = (sum * 10) % 11;
        if (rest == 10) {
            this.secondCheckDigit = 0;
        } else {
            this.secondCheckDigit = rest;
        }
    }

    private void compareCheckDigits() {
        if (!isCheckDigitValid()) {
            throw new InvalidCpfException("Invalid CPF");
        }
    }

    private boolean isCheckDigitValid() {
        return verifyFirstCheckDigit() && verifySecondCheckDigit();
    }

    private boolean verifyFirstCheckDigit() {
        return firstCheckDigit == Integer.parseInt(Character.toString(cpf.charAt(9)));
    }

    private boolean verifySecondCheckDigit() {
        return secondCheckDigit == Integer.parseInt(Character.toString(cpf.charAt(10)));
    }

}
