package com.yy.spi;

import com.yy.spring.AbstractGeneralBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenyiqin02
 * @date 2020/04/08
 */
@Service("wehotelImpl")
public class WehotelImpl implements IOrderPay {
    @Resource(name = "huazhuBizImpl")
    AbstractGeneralBiz generalBiz;

    @Override
    public void pay() {
        System.out.println("serviceId" + generalBiz.getServiceId());
        System.out.println("wehotel");
    }
}
