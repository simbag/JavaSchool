package com.sbt.javaschool.exceptions;

import java.net.ConnectException;
import java.util.Scanner;

class UserInterface {

    private TerminalImpl terminal = new TerminalImpl();

    void work() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1 - Ввести пин-код");
            System.out.println("2 - Проверить состояние счёта");
            System.out.println("3 - Положить деньги");
            System.out.println("4 - Снять деньги");
            System.out.println("5 - Завершить работу с терминалом");
            System.out.print("> ");

            int operation = scanner.nextInt();

            try {
                if (operation == 1) {
                    terminal.enterPinCode(scanner.nextInt());
                }
                if (operation == 2) {
                    System.out.println("Состояние Вашего счёта: " + terminal.checkBankAccount() + " рублей");
                }
                if (operation == 3) {
                    terminal.putMoney(scanner.nextInt());
                }
                if (operation == 4) {
                    terminal.getMoney(scanner.nextInt());
                }
                if (operation == 5) {
                    break;
                }
            } catch (SecurityException | AccountIsLockedException | ConnectException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

