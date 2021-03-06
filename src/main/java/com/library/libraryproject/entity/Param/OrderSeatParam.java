package com.library.libraryproject.entity.Param;

import lombok.*;

import java.util.Date;

/**
 * @author dcl
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderSeatParam {
    private Date orderStart;
    private Date orderFinish;
    private Integer userId;
    private String seatId;
}
