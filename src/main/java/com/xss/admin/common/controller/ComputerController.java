package com.xss.admin.common.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xss.admin.common.aop.UserAccess;
import com.xss.admin.common.model.Computers;
import com.xss.admin.common.service.ComputerService;
import com.xss.modules.utils.AjaxJson;
import com.xss.modules.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ComputerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ComputerService computerService;

    @RequestMapping("/computer/list")
    public String List(Model model) {
        return "computerindex";
    }

    @RequestMapping("/computer/json")
    @ResponseBody
    public String computerjson(Model model, Computers computers, int page, int limit) {
        PageHelper.startPage(NumberUtils.toInt(page, 1), NumberUtils.toInt(limit, 10));
        List<Computers> list2 = computerService.search(computers);
        PageInfo pageInfo = new PageInfo<>(list2);
        String json = AjaxJson.getJson2UI(pageInfo);
        return json;
    }

    @RequestMapping("/computer/add")
    @ResponseBody
    @UserAccess
    public String computerAdd(Model model, HttpServletRequest request, Computers computers) {
        AjaxJson json = new AjaxJson();
        int insert2 = computerService.insert(computers);
        if (insert2 > 0) {
            json.setMsg("新建成功");
        } else {
            json.setSuccess(false);
            json.setMsg("新建失败");
        }
        return json.getJsonStr();
    }

    @RequestMapping("/computer/update")
    @ResponseBody
    @UserAccess
    public String updatecache(Model model, Computers computers) {
        AjaxJson json = new AjaxJson();
        if (!"".equals(computers.getId())) {
            int update2 = computerService.update(computers);
            if (update2 > 0) {
                json.setMsg("更新成功");
            } else {
                json.setSuccess(false);
                json.setMsg("更新失败");
            }
        } else {
            json.setSuccess(false);
            json.setMsg("更新失败");
        }
        return json.getJsonStr();
    }
    @RequestMapping("/computer/delete")
    @ResponseBody
    @UserAccess
    public String delete(Model model, Computers computers) {
        AjaxJson json = new AjaxJson();
        if (!"".equals(computers.getId())) {
            int delete = computerService.delete(computers.getId());
            if (delete > 0) {
                json.setMsg("删除成功");
            } else {
                json.setSuccess(false);
                json.setMsg("删除失败");
            }
        } else {
            json.setSuccess(false);
            json.setMsg("删除失败");
        }
        return json.getJsonStr();
    }
}
