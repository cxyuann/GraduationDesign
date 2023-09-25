package com.example.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.test.utils.RedisUtil;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/redis")
public class RedisController {
    @Resource
    RedisUtil redisClient;
    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        specCaptcha.setFont(Captcha.FONT_1);
        String id = UUID.randomUUID().toString();
        response.setHeader("id", id);
        CaptchaUtil.out(specCaptcha, request, response);
        String verCode = specCaptcha.text().toLowerCase();
        //不设置过期
        redisClient.set(id, verCode);
        //设置一分钟过期
        //redisClient.set(id,verCode,60);
    }

    @PostMapping(value = "/check")
    public boolean check(@RequestBody String info) {
        JSONObject jsonObject = JSON.parseObject(info);
        //获取传过来的id 和 code
        String id = jsonObject.getString("id");
        String code = jsonObject.getString("code");
        String s = "";
        //获取redis里面存的code
        Object obj = redisClient.get(id);
        if(obj != null){
            s = obj.toString();
        }
        //比较输入的code和redis的code
        boolean flag = code.equalsIgnoreCase(s);
        //匹配成功就删除redis存储
        if(flag){
            redisClient.del(id);
        }
        return flag;
    }

}
