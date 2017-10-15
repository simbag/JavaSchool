package ru.sbt.javashool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class SchoolChatClient {
    public static void main(String[] args) {

        try (Socket server = new Socket(ConnectionInfo.HOST, ConnectionInfo.PORT)) {
            String login = null;

            try (ObjectOutputStream os = new ObjectOutputStream(server.getOutputStream());
                 ObjectInputStream is = new ObjectInputStream(server.getInputStream())) {

                Scanner scanner = new Scanner(System.in);

                System.out.println
                        ("Доступные команды чата:\n" +
                                "login - авторизоваться\n" +
                                "sendTo <user>:<msg> - послать пользователю <user> сообщение <msg>\n" +
                                "getMessages - получить сообщения\n" +
                                "exit - выйти из чата\n");

                while (true) {

                    String input = scanner.nextLine();
                    Message message;

                    if (input.startsWith("login")) {
                        login = input.substring(6, input.length());
                        message = new Message(login, Commands.LOGIN);
                        os.writeObject(message);
                        os.flush();

                    } else if (input.startsWith("sendTo")) {
                        String user = input.substring(7, input.indexOf(':'));
                        String msg = input.substring(input.indexOf(':') + 1, input.length());
                        message = new Message(login, Commands.SEND, user, msg);
                        os.writeObject(message);
                        os.flush();

                    } else if (input.startsWith("getMessages")) {
                        message = new Message(login, Commands.GET);
                        os.writeObject(message);
                        os.flush();

                        List<Message> messages = (List<Message>) is.readObject();
                        for (Message m : messages) {
                            System.out.println(m.getLogin() + ">> " + m.getMessage());
                        }

                    } else if (input.startsWith("exit")) {
                        message = new Message(login, Commands.EXIT);
                        os.writeObject(message);
                        os.flush();
                        break;

                    } else {
                        System.out.println("Неизвестная команда!");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
