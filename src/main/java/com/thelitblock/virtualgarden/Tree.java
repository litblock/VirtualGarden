package com.thelitblock.virtualgarden;

public class Tree extends Plant {
    private int height; // Height in feet

    public Tree(String type, int height) {
        super(type);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
