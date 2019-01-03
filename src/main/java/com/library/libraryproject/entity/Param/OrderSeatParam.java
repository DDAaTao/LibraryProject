package com.library.libraryproject.entity.Param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author dcl
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSeatParam {
    private Date orderStart;
    private Date orderFinish;
    private Integer userId;
    private String seatId;
}
