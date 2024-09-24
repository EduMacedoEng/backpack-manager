package com.example.backpack_manager.backend.services;

import com.example.backpack_manager.backend.entity.Backpack;
import com.example.backpack_manager.backend.entity.Item;
import com.example.backpack_manager.exceptions.WeightLimitExceededException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
public class BackpackService {

    public double calculateTotalWeight(Backpack backpack) {
        return backpack.getItems().stream()
                .mapToDouble(Item::getWeight)
                .sum();
    }

    public void addItem(Backpack backpack, Item item) {
        double totalWeightAfterAddition = calculateTotalWeight(backpack) + item.getWeight();
        if (totalWeightAfterAddition > backpack.getMaxWeight()) {
            log.error("Cannot add item {}. Total weight would exceed the max limit of {}kg.", item.getName(), backpack.getMaxWeight());
            throw new WeightLimitExceededException("Weight limit exceeded!");
        }
        backpack.getItems().add(item);
        log.info("Item {} added to the backpack.", item.getName());
    }

    public void listItems(Backpack backpack) {
        String itemList = backpack.getItems().stream()
                .map(Item::getName)
                .collect(Collectors.joining(", "));

        log.info("Listing items in the backpack: {}", itemList);
    }
}
