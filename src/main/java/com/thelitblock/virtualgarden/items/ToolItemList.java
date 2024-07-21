package com.thelitblock.virtualgarden.items;

import java.util.ArrayList;
import java.util.List;

public enum ToolItemList {
    BASIC_WATERING_CAN(new ToolItem("1", "Basic Watering Can", "A simple watering can", ToolType.WATERING, 1, false)),
    DELUXE_WATERING_CAN(new ToolItem("2", "Deluxe Watering Can", "A deluxe watering can with extended range", ToolType.WATERING, 1, false)),
    BASIC_TILLER(new ToolItem("3", "Basic Tiller", "A simple tiller", ToolType.TILLING, 1, false)),
    BASIC_SHOVEL(new ToolItem("4", "Basic Shovel", "A simple shovel", ToolType.DIGGING, 1, false)),
    BASIC_FERTILIZER(new ToolItem("5", "Basic Fertilizer", "A simple bag of fertilizer", ToolType.FERTILIZING, 1, true));

    private final ToolItem toolItem;

    ToolItemList(ToolItem toolItem) {
        this.toolItem = toolItem;
    }

    public static List<ToolItem> getDefaults() {
        List<ToolItem> defaults = new ArrayList<>();
        defaults.add(BASIC_WATERING_CAN.getToolItem());
        defaults.add(BASIC_SHOVEL.getToolItem());
        defaults.add(BASIC_TILLER.getToolItem());

        ToolItem fertilizer = BASIC_FERTILIZER.getToolItem();
        fertilizer.setQuantity(5);
        defaults.add(fertilizer);

        return defaults;
    }

    public ToolItem getToolItem() {
        return toolItem;
    }
}