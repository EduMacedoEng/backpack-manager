package com.example.backpack_manager;

import com.example.backpack_manager.backend.entity.Backpack;
import com.example.backpack_manager.backend.entity.Item;
import com.example.backpack_manager.backend.services.BackpackService;
import com.example.backpack_manager.backend.services.ItemService;
import com.example.backpack_manager.enums.SizeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.UUID;

@Slf4j
@SpringBootApplication
public class BackpackManagerApplication {

	private final BackpackService backpackService;
	private final ItemService itemService;

	public BackpackManagerApplication(BackpackService backpackService, ItemService itemService) {
		this.backpackService = backpackService;
		this.itemService = itemService;
	}

    public static void main(String[] args) {
		SpringApplication.run(BackpackManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {

			log.info("=== Starting BackpackManager Application ===");

			// Create backpack
			Backpack backpack = Backpack.builder().id(UUID.randomUUID()).items(new ArrayList<>()).build();
			log.info("Backpack create with ID: {}", backpack.getId());

			// Create items
			Item waterBottle = Item.builder().id(UUID.randomUUID()).name("Water Bottle").size(SizeType.MEDIUM).weight(0.5).build();
			Item phone = Item.builder().id(UUID.randomUUID()).name("Phone").size(SizeType.SMALL).weight(1.2).build();
			Item laptop = Item.builder().id(UUID.randomUUID()).name("Laptop").size(SizeType.LARGE).weight(1.3).build();

			// Adding items to backpack
			backpackService.addItem(backpack, waterBottle);
			backpackService.addItem(backpack, phone);
			backpackService.addItem(backpack, laptop);

			// Get All Items
			backpackService.listItems(backpack);

			// Executions items functions
			itemService.open(waterBottle);
			itemService.turnOn(phone);

			// Show Total Height
			double totalWeight = backpackService.calculateTotalWeight(backpack);
			log.info("Total weight in backpack: {} kg", totalWeight);

			log.info("=== BackpackManager Application Completed ===");
		};
	}

}
