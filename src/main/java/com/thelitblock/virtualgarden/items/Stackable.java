package com.thelitblock.virtualgarden.items;

public interface Stackable {
    int getQuantity();
    void setQuantity(int quantity);
    void increaseQuantity(int amount);
    void decreaseQuantity(int amount);
}