package com.sbt.javaschool.exceptions;

import java.net.ConnectException;
import java.util.Random;

public class TerminalServer {
    private int money;
    private Random r = new Random();


    public int checkBankAccount() throws ConnectException {
        connectionError();
        return this.money;
    }

    public void putMoney(int money) throws ConnectException {
        connectionError();
        this.money += money;
    }

    public void getMoney(int money) throws IllegalArgumentException,ConnectException {
        connectionError();
        if (this.money-money<0)
            throw new IllegalArgumentException("Недостаточно денег на счёте! Пожалуйста, попробуйте ввести сумму меньше.");

        this.money -= money;
    }

    public void connectionError() throws ConnectException {

        if (r.nextInt(10) == 5){
            throw new ConnectException("Сервис недоступен! Пожалуйста, попробуйте позже.");
        }

    }
}
