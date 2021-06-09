package com.yy.designpattern.decoratorpattern;

/**
 * @author chenyiqin02
 * @date 2020/05/28
 */
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
