package SnakesAndLadder;

public class Player {
    int currentPosition;
    String name;

    public Player(int currentPosition, String name) {
        this.currentPosition = currentPosition;
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
