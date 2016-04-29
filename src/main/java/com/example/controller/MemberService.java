package com.example.controller;

import com.example.pojo.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberService {
    private final MernisService mernisService;
    private final LogService logService;

    public String signUp(User user) {

        User dbUser = User.builder().build();

        String mernisResult = mernisService.checkUser(dbUser);
        if (mernisResult.contains("yanlis")) {
            return "mernis basarisiz";
        }
        if (mernisResult.contains("basarili")) {
            logService.writeLog("gdsagasgas");
        }
        if (user.getTcKimlik() == null) {
            return "tc kimlik yanlis";
        }
        if (user.getLastname() == null) {
            return "lastname yanlis";
        }
        return "basariyla kaydedildi...";
    }

}
