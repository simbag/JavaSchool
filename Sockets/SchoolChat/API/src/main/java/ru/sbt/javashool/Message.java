package ru.sbt.javashool;

import java.io.Serializable;

public class Message implements Serializable {
    private Commands command;
    private String login;
    private String dest;
    private String message;

    public Message(String login, Commands command) {
        this.command = command;
        this.login = login;
    }

    public Message(String login, Commands command, String dest, String message) {
        this.command = command;
        this.login = login;
        this.dest = dest;
        this.message = message;
    }

    public Commands getCommand() {
        return command;
    }

    public void setCommand(Commands command) {
        this.command = command;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
