package com.natsuki_kining.ur.manager.sys.controller.generator;

import com.alibaba.fastjson.JSON;
import com.natsuki_kining.ur.manager.sys.controller.BaseController;
import com.natsuki_kining.ur.manager.sys.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sys/generator")
//@RequiresRoles(value={"role:all","admin:all","admin:sys:all","sys:generator"})
public class GeneratorController extends BaseController {
	
	@Autowired
	private GeneratorService generatorService;

}
