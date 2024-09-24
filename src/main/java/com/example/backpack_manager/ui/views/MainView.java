package com.example.backpack_manager.ui.views;

import com.example.backpack_manager.backend.entity.Backpack;
import com.example.backpack_manager.backend.entity.Item;
import com.example.backpack_manager.backend.services.BackpackService;
import com.example.backpack_manager.enums.SizeType;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.UUID;

@Route("")
public class MainView extends VerticalLayout {

    private final BackpackService backpackService;
    private final Backpack backpack;

    public MainView() {

        this.backpackService = new BackpackService();
        this.backpack = Backpack.builder().id(UUID.randomUUID()).items(new ArrayList<>()).maxWeight(3.0).build();

        TextField itemName = new TextField("Item Name");

        NumberField itemWeight = new NumberField("Item Weight (kg)");
        itemWeight.setMin(0.0);
        itemWeight.setStep(0.1);
        itemWeight.setClearButtonVisible(true);

        ComboBox<SizeType> itemSize = new ComboBox<>("Item Size");
        itemSize.setItems(SizeType.values());
        itemSize.setPlaceholder("Select size");

        Button addButton = new Button("Add Item");

        addButton.addClickListener(event -> {

            if (itemName.isEmpty()) {
                Notification.show("Item name is required", 3000, Notification.Position.MIDDLE);
                return;
            }

            if (itemWeight.isEmpty() || itemWeight.getValue() == null) {
                Notification.show("Item weight is required", 3000, Notification.Position.MIDDLE);
                return;
            }

            if (itemSize.isEmpty()) {
                Notification.show("Item size is required", 3000, Notification.Position.MIDDLE);
                return;
            }

            double weight = itemWeight.getValue();
            SizeType size = itemSize.getValue();

            // Criação do item
            Item item = Item.builder()
                    .id(UUID.randomUUID())
                    .name(itemName.getValue())
                    .weight(weight)
                    .size(size)
                    .build();

            try {
                backpackService.addItem(backpack, item);
                Notification.show("Item '" + item.getName() + "' added successfully!", 3000, Notification.Position.MIDDLE);

                itemName.clear();
                itemWeight.clear();
                itemSize.clear();
            } catch (Exception e) {
                Notification.show(e.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });

        add(itemName, itemWeight, itemSize, addButton);
    }

}
