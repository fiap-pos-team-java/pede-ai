package com.pede.ai.core.commons;

import com.pede.ai.core.exceptions.NotValidException;

public class Cpf {

    private int firstCheckDigit;
    private int secondCheckDigit;
    private String cpfNumber;

    public Cpf(String cpf) {
        this.cpfNumber = cpf;
        isCpfValid(cpf);
    }

    public String getCpfNumber() {
        return cpfNumber;
    }

    private void isCpfValid(String requestCpf) {
        this.cpfNumber = requestCpf;

        validateCpfLength();
        validateNonNumericCharacters();
        validateCheckDigits();
    }

    private void validateCpfLength() {
        if (this.cpfNumber.length() != 11) {
            throw new NotValidException("Invalid CPF size");
        }
    }

    private void validateNonNumericCharacters() {
        if (!cpfNumber.matches("[0-9]+")) {
            throw new NotValidException("Invalid CPF characters");
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
            int digit = Integer.parseInt(Character.toString(this.cpfNumber.charAt(i)));
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
            int digit = Integer.parseInt(Character.toString(cpfNumber.charAt(i)));
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
            throw new NotValidException("Invalid CPF");
        }
    }

    private boolean isCheckDigitValid() {
        return verifyFirstCheckDigit() && verifySecondCheckDigit();
    }

    private boolean verifyFirstCheckDigit() {
        return firstCheckDigit == Integer.parseInt(Character.toString(cpfNumber.charAt(9)));
    }

    private boolean verifySecondCheckDigit() {
        return secondCheckDigit == Integer.parseInt(Character.toString(cpfNumber.charAt(10)));
    }

}
