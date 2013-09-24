package com.binarytenshi.fundamentals.config;

import java.io.File;

import com.binarytenshi.fundamentals.lib.BlockInfo;
import com.binarytenshi.fundamentals.lib.ItemInfo;
import com.binarytenshi.fundamentals.lib.Reference;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

    public static void init(File file) {
        Configuration config = new Configuration(file);
        config.load();

        /* Load Items */
        int id = ItemInfo.BASE_ID;
        ItemInfo.VIAL_ID = getItemId(config, ItemInfo.VIAL_UNLOCALIZED_NAME, id++);

        /* Load Blocks */
        id = BlockInfo.BASE_ID;
        BlockInfo.DECOMPOSER_ID = getBlockId(config, BlockInfo.DECOMPOSER_UNLOCALIZED_NAME, id++);

        config.save();
    }

    private static int getBlockId(Configuration config, String key, int id) {
        return config.getBlock(key, id).getInt(id);
    }

    private static int getItemId(Configuration config, String key, int defaultId) {
        return config.getItem(Configuration.CATEGORY_ITEM, key, defaultId).getInt(defaultId) - Reference.ITEM_ID_SHIFT;
    }
}
