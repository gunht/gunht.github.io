package com.example.bug_report.utils;

public class PageUtil {

    public Integer getPage(Integer page) {
        Integer pageUtil = page;

        if (pageUtil == null) {
            pageUtil = 0;
        } else {
            pageUtil--;
            if (pageUtil < 0) {
                pageUtil = 0;
            }
        }

        return pageUtil;
    }
}
