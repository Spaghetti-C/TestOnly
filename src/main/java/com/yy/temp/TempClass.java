package com.yy.temp;

import lombok.Builder;
import lombok.Data;

import java.util.*;

/**
 * @author chenyiqin02
 * @date 2020/04/28
 */
@Builder
@Data
public class TempClass {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.hashCode());
        String sb = "abc";
        System.out.println(sb.hashCode());
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "bb");
        map.put(2, "s");
        System.out.println(map);
        map.remove(1);
        System.out.println(map);
        String data = "a,b";
        String[] dataArray = data.split(",");
        List<String> datas = new ArrayList<>(Arrays.asList(dataArray));
        datas.remove(0);
    }

}

