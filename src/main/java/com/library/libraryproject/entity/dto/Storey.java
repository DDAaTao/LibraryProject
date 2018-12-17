package com.library.libraryproject.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dcl
 * @since 2018年10月23日23:23:09
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Storey {
    private String name;
    private String id;
    private List<String> rooms;
}
