package com.yy.designpattern.observerpattern;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenyiqin02
 * @date 2020/02/06
 */
public class ObserverPatternTest {
    interface Subject {
        void add(Observer observer);

        void remove(Observer observer);

        void notifyObserver(String message);
    }

    interface Observer {
        void response(String message);
    }

    static class Teacher implements Subject {
        List<Observer> observers = Lists.newArrayList();

        @Override
        public void add(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void remove(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObserver(String message) {
            observers.forEach(observer -> observer.response(message));
        }
    }

    static class Parent implements Observer {
        private String parentName;

        Parent(String parentName) {
            this.parentName = parentName;
        }

        @Override
        public void response(String message) {
            System.out.println("\"" + message + "\"" + "消息" + parentName + "已收到");
        }
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Parent parentChen = new Parent("陈家长");
        Parent parentLi = new Parent("李家长");

        teacher.add(parentChen);
        teacher.add(parentLi);
        teacher.notifyObserver("开学了");
    }
}
