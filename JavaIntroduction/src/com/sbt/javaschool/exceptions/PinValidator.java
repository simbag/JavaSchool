package com.sbt.javaschool.exceptions;

public class PinValidator {

    final int PIN_CODE = 1234;

    public boolean checkPinCode(int pinCode){
        return pinCode == PIN_CODE;
    }

}
