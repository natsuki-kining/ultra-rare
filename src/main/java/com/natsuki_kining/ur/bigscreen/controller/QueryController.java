package com.natsuki_kining.ur.bigscreen.controller;

import com.natsuki_kining.ssr.core.beans.QueryParams;
import com.natsuki_kining.ssr.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/7/25 20:20
 */
@RestController
public class QueryController {

    @Autowired
    private Query query;

    @PostMapping("query")
    public Object query(@RequestBody QueryParams queryParams) {
        return this.query.queryResult(queryParams);
    }


}
