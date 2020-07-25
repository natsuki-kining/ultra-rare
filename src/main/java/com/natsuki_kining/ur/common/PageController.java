package com.natsuki_kining.ur.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/7/25 20:31
 */
@Controller
public class PageController {

    @GetMapping("page")
    public String page(String html){
        return html;
    }
}
