package com.example.controller;

import com.example.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.only;

public class MemberServiceTest {

    private MemberService memberService;
    private MernisService mernisService;
    private LogService logService;

    @Before
    public void setUp() {
        mernisService = Mockito.mock(MernisService.class);
        logService = Mockito.mock(LogService.class);
        memberService = new MemberService(mernisService, logService);
    }


    @Test
    public void shouldVerifyNoInteraction() {
        User user = getUser();

        Mockito.when(mernisService.checkUser(user)).thenReturn("yanlis");

        String result = memberService.signUp(user);

        Mockito.verify(mernisService).checkUser(user);
        Mockito.verify(logService).writeLog("mernis yanlis");
        Mockito.verify(logService, only()).writeLog(any());
        Mockito.verifyNoMoreInteractions(logService);

    }

    @Test
    public void shouldReturnMernisHataliWhenMernisAuthIsUnsuccess() {
        User user = getUser();
        //When

        Mockito.when(mernisService.checkUser(user)).thenReturn("yanlis");

        String result = memberService.signUp(user);

        Mockito.verify(mernisService).checkUser(user);

        assertEquals("Mernis testi basarisiz", result, "mernis basarisiz");

    }

    private User getUser() {
        // Given
        return User.builder()
                .lastname("silahcilar")
                .name("deniz")
                .tcKimlik("13242342342")
                .username("dsilahcilar")
                .build();
    }


    @Test
    public void shouldSpy() {
        User user = getUser();

        LogService newLogservice = Mockito.spy(new LogService());
        memberService = new MemberService(mernisService, newLogservice);

        Mockito.when(mernisService.checkUser(Matchers.any())).thenReturn("basarili");

        //When
        String result = memberService.signUp(user);

        Mockito.verify(newLogservice).writeLog("...");
    }

    @Test
    public void shouldWriteLogWhenMernisAuthIsSuccess() {
        // Given
        User user = getUser();
        //When

        Mockito.when(mernisService.checkUser(Matchers.any())).thenReturn("basarili");

        String result = memberService.signUp(user);

        Mockito.verify(mernisService).checkUser(Matchers.any(User.class));
        Mockito.verify(logService).writeLog(Matchers.anyString());

        //   assertEquals("Mernis testi basarisiz", result, "mernis basarisiz");

    }

    @Test
    public void shouldReturnFalseWhenTcKimlikIsEmpty() {
        // Given
        User user = User.builder()
                .lastname("silahcilar")
                .name("deniz")
                .tcKimlik(null)
                .username("dsilahcilar")
                .build();

        //when
        // Boolean result = memberService.signUp(user);

        //Then
        // assertFalse(result);
    }
/*
    @Test
    public void shouldReturnFalseWhenLastNameIsEmpty() {

        // Given
        User user = User.builder()
                .lastname(null)
                .name("deniz")
                .tcKimlik("12321312")
                .username("dsilahcilar")
                .build();

        //when
        Boolean result = memberService.signUp(user);

        //Then
        assertFalse("last name is null", result);

    }

    @Test
    public void shouldReturnTrueWhenAllFieldsIsNotEmpty() {

        // Given
        User user = User.builder()
                .lastname("silahcilar")
                .name("deniz")
                .tcKimlik("12312451251")
                .username("dsilahcilar")
                .build();

        //when
        Boolean result = memberService.signUp(user);

        //Then
        assertTrue(result);
    }
    */
}