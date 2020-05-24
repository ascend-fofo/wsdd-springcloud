package com.wsdd.cn.feignapi;

import com.wsdd.cn.feign.MenuFeign;
import com.wsdd.cn.utils.PageUtils;
import com.wsdd.cn.utils.ReturnResult;
import com.wsdd.cn.utils.ReturnResultUtils;
import com.wsdd.cn.vo.SysMenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "菜单管理")
@RestController
@RequestMapping(value = "/get")
public class MenuFeignController {

    @Autowired
    private MenuFeign menuFeign;

    @ApiOperation(value = "菜单列表")
    @GetMapping(value = "/sysMenu")
    public ReturnResult<PageUtils<List<SysMenuVo>>> getMenu(@RequestParam(value = "searchStr",required = false)String searchStr,
                                                            @RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return ReturnResultUtils.returnSuccess(menuFeign.showMenuList2(searchStr,pageNo,pageSize));
    }
}
