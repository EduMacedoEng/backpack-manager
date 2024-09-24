package com.example.backpack_manager.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Backpack {

    private UUID id;

    @Builder.Default
    private List<Item> items = new ArrayList<>();

    @Builder.Default
    private double maxWeight = 3.0;

}
