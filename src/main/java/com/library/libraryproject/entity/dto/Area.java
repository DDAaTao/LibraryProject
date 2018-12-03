package com.library.libraryproject.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 文涛
 * @since 2018年11月29日23:46:08
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    private String name;
    private String id;
    private List<Building> buildings;
}
