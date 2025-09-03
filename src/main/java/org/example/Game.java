package org.example;

public class Game {
    private final Player one;
    private final Player two;
    private final Board board;

    public Game(Player one, Player two, Board board) {
        this.one = one;
        this.two = two;
        this.board = board;
    }

}
