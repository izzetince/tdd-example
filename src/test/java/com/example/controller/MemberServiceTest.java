package com.example.controller;

import com.example.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MemberServiceTest {

    private MemberService memberService;
    private MernisService mernisService;

    @Before
    public void setUp() {
        mernisService = Mockito.mock(MernisService.class);
        memberService = new MemberService(mernisService);
    }


    @Test
    public void should() {
        // Given
        User user = User.builder()
                .lastname("silahcilar")
                .name("deniz")
                .tcKimlik("13242342342")
                .username("dsilahcilar")
                .build();
        //When
        Boolean result = memberService.signUp(user);

        Mockito.verify(mernisService).checkUser(user);

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
        Boolean result = memberService.signUp(user);

        //Then
        assertFalse(result);
    }

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
}