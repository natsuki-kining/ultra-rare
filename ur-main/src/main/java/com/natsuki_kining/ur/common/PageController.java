package com.natsuki_kining.ur.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/7/25 20:31
 */
@Controller
public class PageController {

    @GetMapping("/bigScreen/{html}.html")
    public String bigScreenPage(@PathVariable("html") String html){
        return "bigscreen/"+html;
    }
}

