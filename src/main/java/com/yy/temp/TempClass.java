package com.yy.temp;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 用于简单快速测试
 *
 * @author chenyiqin02
 * @date 2020/04/28
 */
@Builder
@Data
@Slf4j
public class TempClass {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0.1");
        BigDecimal bigDecimal1 = new BigDecimal("0.2");
        System.out.println(bigDecimal.add(bigDecimal1));
    }
}

