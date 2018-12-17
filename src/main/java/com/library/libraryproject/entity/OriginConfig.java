package com.library.libraryproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author dcl
 * 2018年10月22日20:55:18
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OriginConfig {
    private Integer id;
    private Date createTime;
    private Date updateTime;
    private String configName;
    private String configBody;
    private String areaId;
    private Integer delete;
}
