//package com.yy.filter;
//
//
//import sun.jvm.hotspot.oops.InstanceKlass;
//import sun.jvm.hotspot.tools.jcore.ClassFilter;
//
///**
// * @author chenyiqin02
// * @date 2019/07/02
// */
//public class ReflectionFilter implements ClassFilter {
//
//    @Override
//    public boolean canInclude(InstanceKlass instanceKlass) {
//        String klassName = instanceKlass.getName().asString();
//        return klassName.startsWith("sun/reflect/");
//    }
//}
