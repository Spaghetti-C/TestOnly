package com.yy.temp;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author chenyiqin02
 * @date 2020/08/14
 */
public class TempClassTest {
    @Test
    public void tempTest() {
        List<ExtPoiDO> extPoiDOList = Lists.newArrayList();
        extPoiDOList.add(ExtPoiDO.builder().sourcePoiId("111").build());
        extPoiDOList.add(ExtPoiDO.builder().sourcePoiId("222").build());
        List<String> transform = Lists.transform(extPoiDOList, ExtPoiDO::getSourcePoiId);
        transform.remove("222");
        System.out.println(extPoiDOList.size());
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
