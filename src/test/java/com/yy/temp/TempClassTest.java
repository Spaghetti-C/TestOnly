package com.yy.temp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyiqin02
 * @date 2020/08/14
 */
public class TempClassTest {
    @Test
    public void tempTest() {
//        List<ExtPoiDO> extPoiDOList = Lists.newArrayList();
//        extPoiDOList.add(ExtPoiDO.builder().sourcePoiId("111").build());
//        extPoiDOList.add(ExtPoiDO.builder().sourcePoiId("222").build());
//        List<String> transform = Lists.transform(extPoiDOList, ExtPoiDO::getSourcePoiId);
//        transform.remove("222");
//        System.out.println(extPoiDOList.size());

        Long now = System.currentTimeMillis();
        Map<Integer, Future> map = new HashMap<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        map.put(1, threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(10 * 1000L);
            } catch (InterruptedException e) {

            }
        }));
        map.put(2, threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(10 * 1000L);
            } catch (InterruptedException e) {

            }
        }));
        map.forEach((key, value) -> {
            try {
                Object o = value.get(1L, TimeUnit.SECONDS);
            } catch (Exception e) {
            }
        });
        System.out.println(System.currentTimeMillis() - now);

    }

}

class ExtPoiDO {
    String sourcePoiId;

    public String getSourcePoiId() {
        return this.sourcePoiId;
    }

    public void setSourcePoiId(String sourcePoiId) {
        this.sourcePoiId = sourcePoiId;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private ExtPoiDO extPoiDO;

        Builder() {
            this.extPoiDO = new ExtPoiDO();
        }

        public Builder sourcePoiId(String sourcePoiId) {
            this.extPoiDO.setSourcePoiId(sourcePoiId);
            return this;
        }

        public ExtPoiDO build() {
            return this.extPoiDO;
        }
    }
}
