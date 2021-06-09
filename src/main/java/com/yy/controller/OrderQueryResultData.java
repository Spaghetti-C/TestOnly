package com.yy.controller;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author chenyiqin02
 * @date 2020/06/18
 */
@Data
@XStreamAlias("qm:response")
public class OrderQueryResultData {
    @XStreamAlias("qm:header")
    private Header header;

    @XStreamAlias("qm:body")
    private Body body;

    @Data
    public static class Body {
        @XStreamAlias("qm:orderInfo")
        private OrderInfo orderInfo;
    }

    @Data
    public static class OrderInfo {
        @XStreamAlias("qm:partnerOrderId")
        private String partnerOrderId;

    }

    @Data
    public class Header {
        @XStreamAlias("qm:application")
        private String application;

        @XStreamAlias("qm:processor")
        private String processor;

        @XStreamAlias("qm:version")
        private String version;

        @XStreamAlias("qm:bodyType")
        private String bodyType;

        @XStreamAlias("qm:createUser")
        private String createUser;

        @XStreamAlias("qm:createTime")
        private String createTime;

        @XStreamAlias("qm:supplierIdentity")
        private String supplierIdentity;

        @XStreamAlias("qm:code")
        private Integer code;

        @XStreamAlias("qm:describe")
        private String describe;
    }

}
