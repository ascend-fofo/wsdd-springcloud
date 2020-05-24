package com.wsdd.cn.feign;

import com.wsdd.cn.exception.ServiceException;
import com.wsdd.cn.utils.PageUtils;
import com.wsdd.cn.utils.ReturnResult;
import com.wsdd.cn.utils.ReturnResultUtils;
import com.wsdd.cn.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "wsdd-springcloud-service", fallback = MenuFeign.MenuHystrix.class)
public interface MenuFeign {

    @GetMapping(value = "/menu/showMenuList")
    ReturnResult<PageUtils<List<SysMenuVo>>> showMenuList2(@RequestParam(value = "searchStr", required = false) String searchStr,
                                                           @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize);

    @Component
    public class MenuHystrix implements MenuFeign {
        @Override
        public ReturnResult<PageUtils<List<SysMenuVo>>> showMenuList2(@RequestParam(value = "searchStr", required = false) String searchStr,
                                                                      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                                                      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
            MenuFeign menuFeign = null;

            return ReturnResultUtils.returnSuccess(menuFeign.showMenuList2(searchStr, pageNo, pageSize));
        }
    }
}
