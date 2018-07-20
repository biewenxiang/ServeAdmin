package com.xss.admin.common.controller;

import ch.qos.logback.classic.net.SyslogAppender;
import com.alibaba.fastjson.JSONObject;
import com.sun.net.httpserver.Authenticator;
import com.xss.admin.common.model.Log;
import com.xss.admin.common.model.User;
import com.xss.admin.common.service.SysLogService;
import com.xss.admin.common.service.TokenCache;
import com.xss.admin.common.service.UserService;
import com.xss.modules.utils.HttpUtil;
import com.xss.modules.utils.IpUtil;
import com.xss.modules.utils.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    SysLogService sysLogService;

    @RequestMapping("/loginview")
    public String loginView(Model model) {
        return "loginview";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(String username, HttpServletRequest request, String password, HttpSession session) throws Exception {
        String islogin = "fail";
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            User user = userService.searchByname(username);
            if (user != null && user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                Log log = new Log();
                log.setUsername(username);
                log.setCreatetime(TimeUtil.getCurDateTime());
                log.setIp(IpUtil.getIpAddr(request));
                log.setOperation("登录");
                sysLogService.sysadd(log);
                // 登录信息存入session
                islogin = "success";
            }
        }
        return islogin;
    }

    @ResponseBody
    @RequestMapping("/getUserInfo")
    public String getInfo(String code, HttpServletRequest request, String password) throws Exception {
        String results = "";
        if (StringUtils.isNotBlank(code)) {
            System.out.println(code);
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + TokenCache.appid + "&secret="+TokenCache.secret+"&js_code=" + code + "&grant_type=authorization_code";
            results = HttpUtil.getUrlContent(url);
            System.out.println(results);
            JSONObject jsonObject = JSONObject.parseObject(results);
            if (jsonObject.get("openid") != null) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("openid", jsonObject.get("openid"));
                results = jsonObject1.toJSONString();
            }
        }

        //System.out.println(results);
        return results;
    }

    @ResponseBody
    @RequestMapping("/addformid")
    public String addfromid(String openid, HttpServletRequest request, String formid) throws Exception {
        String results = "";
        if (!"".equals(openid) && !"".equals(formid)) {
            System.out.println(openid + "" + formid);
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("openid", openid);
            jsonObject1.put("formid", formid);
            results = jsonObject1.toJSONString();
        }
        System.out.println(results);
        return results;
    }

    @ResponseBody
    @RequestMapping("/addUserInfo")
    public String addUserInfo(String openid, HttpServletRequest request, String nickname) throws Exception {
        String results = "";
        if (StringUtils.isNotBlank(openid) && !"".equals(nickname)) {
            String realnickname = "select realnickname from table where openid = ?";//数据库中存的微信名
            if ("".equals(realnickname)) {
                //添加openID与Nickname到数据库
                System.out.println(openid + "" + nickname);

            } else if (!realnickname.equals(nickname)) {
                //更新Nickname
                System.out.println(openid + "" + nickname);
            }
            System.out.println(openid + "" + nickname);
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("openid", openid);
            jsonObject1.put("nickname", nickname);

            results = jsonObject1.toJSONString();
        }

        //System.out.println(results);
        return results;
    }

    @RequestMapping("/loginout")
    public String magPriceLoginOut(Model model, HttpSession session) {
        session.removeAttribute("user");
        return "loginview";
    }


}
