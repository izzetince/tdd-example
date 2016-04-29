package com.example.controller;

import com.example.pojo.User;

public class MemberController {
    private MemberService memberService;

    public Boolean signUp(User user) {
        memberService.signUp(user);
        return false;
    }
}
