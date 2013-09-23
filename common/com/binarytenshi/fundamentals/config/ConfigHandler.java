package com.binarytenshi.fundamentals.config;

import java.io.File;

import com.binarytenshi.fundamentals.lib.ItemInfo;
import com.binarytenshi.fundamentals.lib.Reference;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

    public static void init(File file) {
        Configuration config = new Configuration(file);
        config.load();

        int id = ItemInfo.BASE_ID;
        ItemInfo.VIAL_ID = getItemId(config, ItemInfo.VIAL_UNLOCALIZED_NAME, id++);

        config.save();
    }

    private static int getItemId(Configuration config, String key, int defaultId) {
        return config.getItem(Configuration.CATEGORY_ITEM, key, defaultId).getInt(defaultId) - Reference.ITEM_ID_SHIFT;
    }
}
