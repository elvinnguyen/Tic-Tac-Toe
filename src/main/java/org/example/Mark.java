package org.example;

public enum Mark {
    X, O, Empty;

    @Override
    public String toString() {
        return switch (this) {
            case X -> "X";
            case O -> "O";
            case Empty -> " ";
        };
    }
}