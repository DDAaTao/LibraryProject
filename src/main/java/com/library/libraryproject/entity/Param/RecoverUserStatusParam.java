package com.library.libraryproject.entity.Param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dcl
 * */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecoverUserStatusParam {

    private List<Integer> userIds;

    private String status;
}
