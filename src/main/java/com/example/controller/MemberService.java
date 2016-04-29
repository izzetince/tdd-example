package com.example.controller;

import com.example.pojo.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberService {
    private final MernisService mernisService;

    public Boolean signUp(User user) {


      //  mernisService.checkUser(user);


        if (user.getTcKimlik() == null) {
            return false;
        }
        if (user.getLastname() == null) {
            return false;
        }
        return true;
    }

}
