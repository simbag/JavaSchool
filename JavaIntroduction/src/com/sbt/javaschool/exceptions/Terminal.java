package com.sbt.javaschool.exceptions;

import java.net.ConnectException;

public interface Terminal {
    void enterPinCode(int pinCode) throws AccountIsLockedException;
    int checkBankAccount() throws SecurityException, ConnectException;
    void putMoney(int money) throws SecurityException, IllegalArgumentException, ConnectException;
    void getMoney(int money) throws SecurityException, IllegalArgumentException, ConnectException;
}
