package com.example.controller;

import lombok.extern.java.Log;

@Log
public class LogService {

    public void writeLog(String s) {
        log.info("log writing" + s);
    }
}
