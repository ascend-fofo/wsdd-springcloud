package com.wsdd.cn.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.wsdd.cn.mapper")
public class MybatisConfiguration {
}
