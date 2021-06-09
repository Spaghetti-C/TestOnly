package com.yy.controller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenyiqin02
 * @date 2020/06/15
 */
@Controller
public class TestController {

    @RequestMapping("/")
    @ResponseBody
    public String testApi() {
        // 错误元素为qm:partnerorderId
//        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<qm:response\n" +
//                "    xmlns:qm=\"http://tour.ectrip.com/2014/QMResponseSchema\" xsi:schemaLocation=\"http://tour.ectrip.com/2014/QMResponseSchema QMRequestDataSchema-1.1.0.xsd\"\n" +
//                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
//                "    <qm:body xsi:type=\"qm:GetOrderByOTAResponseBody\">\n" +
//                "        <qm:orderInfo>\n" +
//                "            <qm:partnerorderId>20200212999777006</qm:partnerorderId>\n" +
//                "        </qm:orderInfo>\n" +
//                "    </qm:body>\n" +
//                "</qm:response>";

        // 错误元素为partnerorderId
//        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<qm:response\n" +
//                "    xmlns:qm=\"http://tour.ectrip.com/2014/QMResponseSchema\" xsi:schemaLocation=\"http://tour.ectrip.com/2014/QMResponseSchema QMRequestDataSchema-1.1.0.xsd\"\n" +
//                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
//                "    <qm:body xsi:type=\"qm:GetOrderByOTAResponseBody\">\n" +
//                "        <qm:orderInfo>\n" +
//                "            <partnerorderId>20200212999777006</partnerorderId>\n" +
//                "        </qm:orderInfo>\n" +
//                "    </qm:body>\n" +
//                "</qm:response>";

        // 增加header
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<qm:response xmlns:qm=\"http://tour.ectrip.com/2014/QMResponseSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://tour.ectrip.com/2014/QMResponseSchema QMRequestDataSchema-1.1.0.xsd\">\n" +
                "    <qm:header>\n" +
                "        <qm:application>123</qm:application>\n" +
                "    </qm:header>\n" +
                "    <qm:body xsi:type=\"qm:GetOrderByOTAResponseBody\">\n" +
                "        <qm:orderInfo>\n" +
                "            <qm:partnerOrderId>20200212999777006</qm:partnerOrderId>\n" +
                "        </qm:orderInfo>\n" +
                "    </qm:body>\n" +
                "</qm:response>";
        XStream xStream = new XStream(new Xpp3Driver(new NoNameCoder()));
        xStream.processAnnotations(OrderQueryResultData.class);
        xStream.ignoreUnknownElements();
        OrderQueryResultData orderQueryResultData = (OrderQueryResultData) xStream.fromXML(xml);
        System.out.println(orderQueryResultData.toString());

        return "SUCCESS";
    }
}
