package com.yy.spi;

import com.yy.spring.AbstractGeneralBiz;
import com.yy.spring.BizFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.ServiceLoader;

import static org.junit.Assert.*;
import static org.springframework.core.io.support.SpringFactoriesLoader.FACTORIES_RESOURCE_LOCATION;

/**
 * @author chenyiqin02
 * @date 2020/04/08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext_spi.xml"})
public class IOrderPayTest {
    @Resource(name = "huazhuBizImpl")
    AbstractGeneralBiz generalBiz;
    @Resource(name = "wehotelImpl")
    IOrderPay orderPay;

    @Test
    public void javaSpiTest() {
//        System.out.println(generalBiz.getServiceId());
        ServiceLoader<IOrderPay> serviceLoader = ServiceLoader.load(IOrderPay.class);
        serviceLoader.forEach(iOrderPay -> {
            iOrderPay.pay();
            System.out.println("done");
        });
    }

    @Test
    public void springSpiTest() throws IOException {
        System.out.println(generalBiz.getServiceId());
        orderPay.pay();

        Properties properties = PropertiesLoaderUtils.loadAllProperties(FACTORIES_RESOURCE_LOCATION,null);
        System.out.println(properties);

        List<IOrderPay> iOrderPays = SpringFactoriesLoader.loadFactories(IOrderPay.class, null);
        iOrderPays.forEach(iOrderPay -> {
            iOrderPay.pay();
            System.out.println("done");
        });
    }

    @Test
    public void dubboSpiTest() {

    }
}