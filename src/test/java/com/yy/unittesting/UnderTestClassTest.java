package com.yy.unittesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * Description:
 *
 * @author chenyiqin02
 * @date 2021/04/28
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UnderTestClass.class})
public class UnderTestClassTest {
    @InjectMocks
    UnderTestClass underTestClass;

    @Test
    public void testPrivateMethod() throws Exception {
        Whitebox.invokeMethod(underTestClass, "privateMethod");
        PowerMockito.verifyPrivate(underTestClass, Mockito.times(1)).invoke("privateMethod");
    }
}