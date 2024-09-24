package com.example.backpack_manager.backend.entity;

import com.example.backpack_manager.enums.SizeType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Item {

    @Id
    private final UUID id;

    @NotBlank
    private final String name;

    @NotNull
    private final SizeType size;

    @NotNull
    private final Double weight;

}
