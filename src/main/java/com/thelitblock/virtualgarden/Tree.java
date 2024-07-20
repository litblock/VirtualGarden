package com.thelitblock.virtualgarden;

import com.thelitblock.virtualgarden.util.AlertManager;

public class Tree extends Plant {
    private int treeHeight; // Height in meters
    private TreeType treeType;

    public Tree(TreeType treeType, int treeHeight, AlertManager alertManager) {
        super(PlantType.TREE, 1, alertManager);
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