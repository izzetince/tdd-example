package com.example.controller;

import com.example.pojo.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberService {
    private final MernisService mernisService;
    private final LogService logService;

    public String signUp(User user) {

        String mernisResult = mernisService.checkUser(user);


        if (mernisResult.contains("yanlis")) {
            logService.writeLog("mernis yanlis");
            logService.writeLog("uyelik iptal!");

            return "mernis basarisiz";
        }
        if (mernisResult.contains("basarili")) {
            logService.writeLog("...");
        }
        if (user.getTcKimlik() == null) {
            return "tc kimlik yanlis";
        }
        if (user.getLastname() == null) {
            return "lastname yanlis";
        }
        logService.writeLog("hersey basarili");

        return "basariyla kaydedildi...";
    }

}
