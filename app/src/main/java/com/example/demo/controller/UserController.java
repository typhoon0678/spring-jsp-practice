package com.example.demo.controller;

import com.example.demo.form.UserRegisterForm;
import com.example.demo.service.SiteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SiteUserService siteUserService;

    @GetMapping("/register")
    public String form() {
        return "user/form";
    }

    @PostMapping("/register")
    public String register(UserRegisterForm form) {

        siteUserService.addUser(form);
        /**
         * 상대 경로 : 맨 마지막 / 기준
         * (/user/register 이므로, /user/ 에 상대 경로가 붙음)
         *
         * 또는 절대 경로로 redirect:/user/success 로 작성
         */
        return "redirect:success";
    }

    @GetMapping("/success")
    public String registered() {
        return "user/completed";
    }
}
