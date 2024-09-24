package com.example.backpack_manager.services;

import com.example.backpack_manager.backend.entity.Backpack;
import com.example.backpack_manager.backend.entity.Item;
import com.example.backpack_manager.backend.services.BackpackService;
import com.example.backpack_manager.enums.SizeType;
import com.example.backpack_manager.exceptions.WeightLimitExceededException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BackpackServiceTest {

    @InjectMocks
    private BackpackService backpackService;

    private Backpack backpack;
    private Item waterBottle;
    private Item phone;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        backpack = Backpack.builder()
                .id(UUID.randomUUID())
                .maxWeight(3.0)
                .items(new ArrayList<>())
                .build();

        waterBottle = Item.builder()
                .id(UUID.randomUUID())
                .name("Water Bottle")
                .size(SizeType.MEDIUM)
                .weight(0.5)
                .build();

        phone = Item.builder()
                .id(UUID.randomUUID())
                .name("Phone")
                .size(SizeType.SMALL)
                .weight(0.2)
                .build();
    }

    @Test
    void testAddItemSuccess() {
        backpackService.addItem(backpack, waterBottle);
        backpackService.addItem(backpack, phone);

        assertEquals(2, backpack.getItems().size());
        assertTrue(backpack.getItems().contains(waterBottle));
        assertTrue(backpack.getItems().contains(phone));
    }

    @Test
    void testAddItemExceedingWeight() {
        Item heavyLaptop = Item.builder()
                .id(UUID.randomUUID())
                .name("Heavy Laptop")
                .size(SizeType.LARGE)
                .weight(3.5)
                .build();

        backpackService.addItem(backpack, waterBottle);

        Exception exception = assertThrows(WeightLimitExceededException.class, () -> {
            backpackService.addItem(backpack, heavyLaptop);
        });

        assertEquals("Weight limit exceeded!", exception.getMessage());
    }

    @Test
    void testListItems() {
        backpackService.addItem(backpack, waterBottle);
        backpackService.addItem(backpack, phone);

        assertDoesNotThrow(() -> backpackService.listItems(backpack));
    }
}
