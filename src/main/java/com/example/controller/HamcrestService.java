package com.example.controller;

import java.util.ArrayList;
import java.util.List;

public class HamcrestService {
    private List<String> elems = new ArrayList<>();

    public List<String> add(String newItem) {
        elems.add(newItem);
        return elems;
    }
}
