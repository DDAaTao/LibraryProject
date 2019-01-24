package com.library.libraryproject.entity.Param;


import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author dcl
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeleteOrderParam {
    private List<Integer> orderIds;
    private Date mdfDate;
    private Integer deleted;
}
