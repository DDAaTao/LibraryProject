package com.library.libraryproject.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dcl
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String id;
    private String name;
}
