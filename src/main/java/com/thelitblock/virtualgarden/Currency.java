package com.thelitblock.virtualgarden;

public class Currency {
    private int coins;

    public Currency(int initialCoins) {
        this.coins = initialCoins;
    }

    public void add(int amount) {
        coins += amount;
    }

    public boolean subtract(int amount) {
        if (amount > coins) {
            return false; // Not enough currency
        }
        coins -= amount;
        return true;
    }

    public int getBalance() {
        return coins;
    }
}