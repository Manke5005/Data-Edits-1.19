package net.zane.dataedits;

import net.fabricmc.api.ModInitializer;
import net.zane.dataedits.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataEdits implements ModInitializer {
	public static final String MOD_ID = "dataedits";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

	}
}
