package com.library.libraryproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dcl
 * @date 2018年9月14日00:01:30
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private Integer managerId;
    private String managerAccount;
    private String managerPwd;
    private String managerAuthority;
}
