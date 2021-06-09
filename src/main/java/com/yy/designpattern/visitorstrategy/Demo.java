package com.yy.designpattern.visitorstrategy;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyiqin02
 * @date 2019/07/29
 */
public class Demo {
    public static void main(String[] args) {
        List<FA> fas = new ArrayList<>();
        List<FB> fbs = Lists.newArrayList();
        FA a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        fas.add(a);
        fas.add(b);
        fbs.add(c);
        fbs.add(d);

        Visitor visitor = new Visitor();
        visitor.visit(a);
    }
}

class Visitor {
    public void visit(A a, B b) {
        System.out.println("ab");
    }

    public void visit(A a, C b) {
    }

    public void visit(A a) {
        System.out.println("a");
    }

    public void visit(B b) {
        System.out.println("b");
    }

    public void visit(FA fa) {
        System.out.println("fa");
    }
}

class FA {
    public void say() {
        System.out.println("say fa");
    }
}
class FB {}

class A extends FA {
    @Override
    public void say() {
        System.out.println("say a");
    }
}

class B extends FA {

}

class C extends FB {

}

class D extends FB {

}
