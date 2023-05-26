package net.emirikol.transferpet;

import net.emirikol.transferpet.item.CreativeContract;
import net.emirikol.transferpet.item.PetContract;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class PetTransfer implements ModInitializer {
	public static PetContract PET_CONTRACT;
	public static CreativeContract CREATIVE_CONTRACT;

	public static void addItemstoItemGroups(){
		addToItemGroup(ItemGroups.TOOLS, PET_CONTRACT );
		addToItemGroup(ItemGroups.TOOLS, CREATIVE_CONTRACT );
	}

	public static void addToItemGroup (ItemGroup group, Item item){
		ItemGroupEvents.modifyEntriesEvent(group).register(entries ->
				entries.add(item));
	}

	@Override
	public void onInitialize() {
		//Instantiate contract.
		FabricItemSettings petContractSettings = new FabricItemSettings();
		PET_CONTRACT = new PetContract(petContractSettings);
		CREATIVE_CONTRACT = new CreativeContract(petContractSettings);
		//Register contract.
		Registry.register(Registries.ITEM, "transferpet:contract", PET_CONTRACT);
		Registry.register(Registries.ITEM, "transferpet:contract_creative", CREATIVE_CONTRACT);
		//Self-explanatory
		addItemstoItemGroups();
	}
}
