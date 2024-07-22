package com.thelitblock.virtualgarden.commands;

import java.util.Optional;

public interface Command {
    String getName();
    String getDescription();
    void execute();
}