package com.thelitblock.virtualgarden;

public class Tree extends Plant {
    private int treeHeight; // Height in meters
    private TreeType treeType;

    public Tree(TreeType treeType, int treeHeight) {
        super(PlantType.TREE);
        this.treeHeight = treeHeight;
        this.treeType = treeType;
    }

    public int getTreeHeight() {
        return treeHeight;
    }

    public TreeType getTreeType() {
        return treeType;
    }

    public String getName() {
        return treeType.toString();
    }
}