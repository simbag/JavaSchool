package com.sbt.javaschool.exceptions;

import java.net.ConnectException;

public class TerminalImpl implements Terminal {
    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();

    private boolean isPinEntered = false;

    private int attemptsCount = 0;
    private long lockTime;


    @Override
    public void enterPinCode(int pinCode) throws AccountIsLockedException {
        if (pinValidator.checkPinCode(pinCode)) {
            isPinEntered = true;
            attemptsCount = 0;
        } else {
            if (attemptsCount == 3) {
                lockAccount();
            }
            attemptsCount++;
            throw new SecurityException("Введен некорректный пин-код! Пожалуйста, введите корректый пин-код.");
        }
    }

    private void lockAccount() throws AccountIsLockedException {
        if (lockTime == 0) {
            lockTime = System.currentTimeMillis();
        }
        long elapsedLockTime = 5 - (System.currentTimeMillis() - lockTime)/1000;
        if (elapsedLockTime <= 0) {
            attemptsCount = 0;
            lockTime = 0;
        } else {
            throw new AccountIsLockedException("Аккаут заблокирован! Аккаунт будет доступен через: " + elapsedLockTime + " секунд");
        }
    }

    @Override
    public int checkBankAccount() throws SecurityException, ConnectException {
        if (!isPinEntered) {
            throw new SecurityException("Пин-код не был введён! Пожалуйста, введите пин-код.");
        }
        return server.checkBankAccount();
    }

    @Override
    public void putMoney(int money) throws SecurityException, IllegalArgumentException, ConnectException {
        if (!isPinEntered) {
            throw new SecurityException("Пин-код не был введён! Пожалуйста, введите пин-код.");
        }

        checkSum(money);
        server.putMoney(money);

    }

    @Override
    public void getMoney(int money) throws SecurityException, IllegalArgumentException, ConnectException {
        if (!isPinEntered) {
            throw new SecurityException("Пин-код не был введён! Пожалуйста, введите пин-код.");
        }

        checkSum(money);
        server.getMoney(money);
    }

    private void checkSum(int sum) throws IllegalArgumentException {
        if (!(sum % 100 == 0)){
            throw new IllegalArgumentException("Данная сумма не делится на 100, пожалуйста, введите сумму кратную 100!");
        }
    }
}
