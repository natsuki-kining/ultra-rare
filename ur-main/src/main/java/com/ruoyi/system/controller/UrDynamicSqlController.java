package com.ruoyi.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ruoyi.system.controller.abs.AbstractUrDynamicSqlController;

/**
 * 动态sqlController
 * 
 * @author natsuki_kining
 * @date 2020-10-14
 */
@Controller
@RequestMapping("/system/sql")
public class UrDynamicSqlController extends AbstractUrDynamicSqlController {

    /**
     * 新增动态sql
     */
    @GetMapping("/addDynamicSql" )
    public String addDynamicSql() {
        return prefix + "/addDynamicSql" ;
    }

}
