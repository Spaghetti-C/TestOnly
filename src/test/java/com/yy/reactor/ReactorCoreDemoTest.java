package com.yy.reactor;

import org.junit.Test;

/**
 * @author chenyiqin02
 * @date 2020/09/22
 */
public class ReactorCoreDemoTest {
    @Test
    public void testFluxDemo() {
        ReactorCoreDemo reactorCoreDemo = new ReactorCoreDemo();
        reactorCoreDemo.fluxDemo();
    }

    @Test
    public void testMonoDemo() {
        ReactorCoreDemo reactorCoreDemo = new ReactorCoreDemo();
        reactorCoreDemo.monoDemo();
    }
}