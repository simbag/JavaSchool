package ru.sbt.test.refactoring;

import java.awt.*;

public class Tractor {

    Point position = new Point(0, 0);

    private final static int FIELD_WIDTH = 5;
    private final static int FIELD_HEIGTH = 5;

    Orientation orientation = Orientation.NORTH;

    public void move(String command) {
        if (command == "F") {
            moveForwards();
        } else if (command == "T") {
            turnClockwise();
        }
    }

    public void moveForwards() {

        switch (orientation) {
            case NORTH:
                position.y++;
                break;
            case EAST:
                position.x++;
                break;
            case WEST:
                position.y--;
                break;
            case SOUTH:
                position.x--;
                break;
            default:
                System.out.println("Указано неверное направление!");
                break;
        }

        if (position.x > FIELD_WIDTH || position.y > FIELD_HEIGTH || position.x < 0 || position.y < 0) {
            throw new TractorInDitchException();
        }
    }

    public void turnClockwise() {
        int nextValue = orientation.ordinal() + 1;
        nextValue = nextValue < Orientation.values().length ? nextValue : 0;
        orientation = Orientation.values()[nextValue];
    }

    public int getPositionX() {
        return position.x;
    }

    public int getPositionY() {
        return position.y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}