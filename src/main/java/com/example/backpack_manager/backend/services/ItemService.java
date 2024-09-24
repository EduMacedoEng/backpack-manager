package com.example.backpack_manager.backend.services;

import com.example.backpack_manager.backend.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ItemService {

    public void open(Item item) {
        log.info("The item '{}' has been opened.", item.getName());
    }

    public void close(Item item) {
        log.info("The item '{}' has been closed.", item.getName());
    }

    public void turnOn(Item item) {
        log.info("The item '{}' has been turned on.", item.getName());
    }

    public void turnOff(Item item) {
        log.info("The item '{}' has been turned off.", item.getName());
    }
}
