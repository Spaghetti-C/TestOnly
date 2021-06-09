package com.yy.spring;

import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenyiqin02
 * @date 2019/12/25
 */
public class BizFactory implements InitializingBean {
    private Map<Integer, AbstractGeneralBiz> bizMap;
    @Setter
    private List<AbstractGeneralBiz> bizList;

    @Override
    public void afterPropertiesSet() throws Exception {
        bizMap = new HashMap<>(64);
        bizList.forEach(biz -> bizMap.put(biz.getServiceId(), biz));
    }

    public void printBizMap() {
        bizMap.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
