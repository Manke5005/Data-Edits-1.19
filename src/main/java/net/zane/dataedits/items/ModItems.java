package net.zane.dataedits.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;
import net.zane.dataedits.DataEdits;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

    public class ModItems {

        public static final Item YEET_STICK = registerItem("yeet_stick",
                new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).group(ItemGroup.MISC)));

        private static Item registerItem(String name, Item item) {
            return Registry.register(Registry.ITEM, new Identifier(DataEdits.MOD_ID, name), item);
        }
        public static void registerModItems() {
            DataEdits.LOGGER.debug("Registering Mod Items for " + DataEdits.MOD_ID);

        }
    }
