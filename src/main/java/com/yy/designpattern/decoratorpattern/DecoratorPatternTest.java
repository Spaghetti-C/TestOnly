package com.yy.designpattern.decoratorpattern;

/**
 * @author chenyiqin02
 * @date 2020/05/28
 */
public class DecoratorPatternTest {
    public static void main(String[] args) {
        ABattercake aBattercake;
        aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);

        System.out.println(aBattercake.getDesc() + " 销售价格:" + aBattercake.cost());
    }
}
