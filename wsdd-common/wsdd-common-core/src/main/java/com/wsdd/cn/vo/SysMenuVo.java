package com.wsdd.cn.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "menu对象",description = "menu对象实体类" )
public class SysMenuVo implements Serializable {
    @ApiModelProperty(value = "菜单ID",name = "menuId")
    private Integer menuId;


    @ApiModelProperty(value = "菜单名称",name = "name")
    private String name;


    @ApiModelProperty(value = "菜单权限标识",name = "permission")
    private String permission;


    @ApiModelProperty(value = "前端URL",name = "path")
    private String path;


    @ApiModelProperty(value = "父菜单ID",name = "parentId")
    private Integer parentId;


    @ApiModelProperty(value = "图标",name = "icon")
    private String icon;


    @ApiModelProperty(value = "VUE页面",name = "component")
    private String component;


    @ApiModelProperty(value = "排序值",name = "sort")
    private Integer sort;


    @ApiModelProperty(value = "是否开启",name = "keepAlive")
    private String keepAlive;


    @ApiModelProperty(value = "菜单类型",name = "type")
    private String type;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间",name = "createTime")
    private Date createTime;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间",name = "updateTime")
    private Date updateTime;


    @ApiModelProperty(value = "逻辑删除标记",name = "delFlag")
    private String delFlag;
}
