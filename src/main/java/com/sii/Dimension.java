package com.sii;

public class Dimension {
    private int height;
    private int width;
    private int tankCapacity;

    public Dimension() {
    }

    public Dimension(int height, int width, int tankCapacity) {
        this.height = height;
        this.width = width;
        this.tankCapacity = tankCapacity;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    @Override
    public String toString() {
        return height + " " + width + " " + tankCapacity;
    }
}