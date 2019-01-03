package com.library.libraryproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author dcl
 * @date 2018年9月14日00:01:30
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private Integer userId;
    private String seatId;
    private String orderStatus;
    private Date orderStart;
    private Date orderFinish;
    private Date orderCreate;
    private Integer deleted;
}
