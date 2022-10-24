package org.rover.domain.referential;

public class Plateau {

    private final int length;

    private final int width;

    public Plateau(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
