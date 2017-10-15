package ru.sbt.javashool;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Connection implements Runnable {
    private Socket socket;
    private String login;

    public Connection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream())) {

            while (true) {
                Message message = (Message) is.readObject();

                if (message.getCommand() == Commands.LOGIN) {
                    login = message.getLogin();
                    if (SchoolChatServer.users.add(login)) {

                        SchoolChatServer.chatMessages.put(login, new ArrayList<Message>());

                        for (String user : SchoolChatServer.users) {
                            if (!user.equals(login)) {

                                Message systemMessage = new Message("system", Commands.SEND, user, "Пользователь " + login + " подключился");

                                if (SchoolChatServer.chatMessages.containsKey(user)) {
                                    SchoolChatServer.chatMessages.get(user).add(systemMessage);
                                }
                            }
                        }

                        System.out.println("Пользователь " + login + " авторизован");
                    }

                } else if (message.getCommand() == Commands.SEND) {
                    String dest = message.getDest();
                    if (SchoolChatServer.chatMessages.containsKey(dest)) {
                        SchoolChatServer.chatMessages.get(dest).add(message);
                    }

                } else if (message.getCommand() == Commands.GET) {
                    List<Message> messages = new ArrayList<>(SchoolChatServer.chatMessages.get(login));
                    SchoolChatServer.chatMessages.get(login).clear();
                    os.writeObject(messages);
                    os.flush();

                } else if (message.getCommand() == Commands.EXIT) {
                    System.out.println("Пользователь " + login + " отключился");
                    return;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
