package com.yy.spring;

import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author chenyiqin02
 * @date 2019/12/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext_spring.xml"})
public class SpringTest {
    @Resource(name = "bizFactory")
    static BizFactory bizFactory2;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext_spring.xml");
        context.getBeansOfType(AbstractGeneralBiz.class)
                .forEach((s, abstractGeneralBiz) -> System.out.println(s + " " + abstractGeneralBiz));
        BizFactory bizFactory = (BizFactory) context.getBean("bizFactory");

        bizFactory.printBizMap();
        bizFactory2.printBizMap();
    }
}
