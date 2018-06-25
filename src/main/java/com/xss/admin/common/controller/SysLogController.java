package com.xss.admin.common.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xss.admin.common.model.Computers;
import com.xss.admin.common.model.Log;
import com.xss.admin.common.service.SysLogService;
import com.xss.modules.utils.AjaxJson;
import com.xss.modules.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysLogController {
    @Autowired
    SysLogService sysLogService;
    @RequestMapping("/log/list")
    public String List(Model model) {
        return "logindex";
    }

    @RequestMapping("/log/json")
    @ResponseBody
    public String computerjson(Model model,  int page, int limit) {
        PageHelper.startPage(NumberUtils.toInt(page, 1), NumberUtils.toInt(limit, 10));
        List<Log> list2 = sysLogService.search();
        PageInfo pageInfo = new PageInfo<>(list2);
        String json = AjaxJson.getJson2UI(pageInfo);
        return json;
    }

}
