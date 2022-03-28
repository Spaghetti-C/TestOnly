package com.yy.designpattern.builder;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author chenyiqin02
 * @date 2022/03/28
 */
public class ComputerTest {
    @Test
    public void test() {
        System.out.println(Computer.builder().setCpu("111").build());
    }

}