package com.xss.admin.common.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xss.admin.common.aop.UserAccess;
import com.xss.admin.common.model.Computers;
import com.xss.admin.common.model.User;
import com.xss.admin.common.service.UserService;
import com.xss.modules.utils.AjaxJson;
import com.xss.modules.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user/list")
    @UserAccess
    public String List(Model model) {
        return "userindex";
    }

    @RequestMapping("/user/json")
    @ResponseBody
    @UserAccess
    public String json(Model model, int page, int limit) {
        PageHelper.startPage(NumberUtils.toInt(page, 1), NumberUtils.toInt(limit, 10));
        List<User> list2 = userService.search();
        PageInfo pageInfo = new PageInfo<>(list2);
        String json = AjaxJson.getJson2UI(pageInfo);
        return json;
    }

    @RequestMapping("/user/add")
    @ResponseBody
    @UserAccess
    public String Add(Model model, HttpServletRequest request, User user) {
        AjaxJson json = new AjaxJson();
        int insert2 = userService.insert(user);
        if (insert2 > 0) {
            json.setMsg("新建成功");
        } else {
            json.setSuccess(false);
            json.setMsg("新建失败");
        }
        return json.getJsonStr();
    }

    @RequestMapping("/user/update")
    @ResponseBody
    @UserAccess
    public String update(Model model, User user) {
        AjaxJson json = new AjaxJson();
        if (!"".equals(user.getUserid().toString())) {
            int update2 = userService.update(user);
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

    @RequestMapping("/user/delete")
    @ResponseBody
    @UserAccess
    public String delete(Model model, User user) {
        AjaxJson json = new AjaxJson();
        if (!"".equals(user.getUserid())) {
            int delete = userService.delete(user.getUserid());
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
