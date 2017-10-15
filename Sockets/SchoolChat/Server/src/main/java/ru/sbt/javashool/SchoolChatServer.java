package ru.sbt.javashool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SchoolChatServer {

    public static ConcurrentHashMap<String, List<Message>> chatMessages = new ConcurrentHashMap<>();
    public static CopyOnWriteArraySet<String> users = new CopyOnWriteArraySet<>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(ConnectionInfo.PORT);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Пользователь подключился");

            executorService.submit(new Connection(clientSocket));
        }

    }
}
