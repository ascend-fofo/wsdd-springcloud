package com.wsdd.cn.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wsdd.cn.entity.SysMenu;
import com.wsdd.cn.entity.SysMenuExample;
import com.wsdd.cn.mapper.SysMenuMapper;
import com.wsdd.cn.service.SysMenuService;
import com.wsdd.cn.vo.SysMenuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public Map showMenuListMap(String searchStr, int pageNo, int pageSize) {
        SysMenuExample sysMenuExample = new SysMenuExample();
        if (!StringUtils.isEmpty(searchStr)) sysMenuExample.createCriteria().andNameLike("%" + searchStr + "%");
        sysMenuExample.setLimit(pageNo);
        sysMenuExample.setOffset(pageSize);
        Map<String, Object> maps = Maps.newHashMap();
        List<SysMenu> menuList = sysMenuMapper.selectByExample(sysMenuExample);
        long count = sysMenuMapper.countByExample(sysMenuExample);

        List<SysMenuVo> sysMenuVoList = Lists.newArrayList();
        menuList.stream().forEach(menuDto -> {
            SysMenuVo sysMenuVo = new SysMenuVo();
            BeanUtils.copyProperties(menuDto, sysMenuVo);
            sysMenuVoList.add(sysMenuVo);
        });
        maps.put("menuList",sysMenuVoList);
        maps.put("count",count);
        return maps;
    }
}
