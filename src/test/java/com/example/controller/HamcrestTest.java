package com.example.controller;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HamcrestTest {
    private HamcrestService hamcrestService = new HamcrestService();


    @Test
    public void first() {

        List<String> myList;
        hamcrestService.add("deniz");
        myList = hamcrestService.add("Q7");

        assertTrue(myList.get(1).equalsIgnoreCase("Q7"));
        assertTrue(myList.get(0).equalsIgnoreCase("deniz"));

        assertThat(myList, CoreMatchers.hasItem("Q7"));
        assertThat(myList, CoreMatchers.hasItem("deniz"));

        assertThat(myList, contains("deniz","Q7"));

    }
}
