package com.wsdd.cn.feign;

import com.wsdd.cn.service.SysMenuService;
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
import java.util.Map;

@Api(tags = "菜单管理")
@RestController
@RequestMapping(value = "/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "菜单列表")
    @GetMapping(value = "/showMenuList")
    public ReturnResult<PageUtils<List<SysMenuVo>>> showMenuList2(@RequestParam(value = "searchStr",required = false)String searchStr,
                                                                 @RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                                                 @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        PageUtils pageUtils = new PageUtils();
        pageUtils.setPageNo(pageNo);
        pageUtils.setPageSize(pageSize);
        Map<String,Object> maps = sysMenuService.showMenuListMap(searchStr,pageUtils.getPageNo(),pageSize);
        pageUtils.setCurrentList((List<SysMenuVo>)maps.get("menuList"));
        pageUtils.setTotalCount((long)maps.get("count"));
        pageUtils.setCurrentPage(pageNo);
        return ReturnResultUtils.returnSuccess(pageUtils);
    }

}
