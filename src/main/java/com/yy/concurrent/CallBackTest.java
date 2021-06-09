package com.yy.concurrent;

/**
 * @author chenyiqin02
 * @date 2020/02/06
 */
public class CallBackTest {
    interface ComputeJob {
        void answer(int rst);
    }

    static class A implements ComputeJob {
        public void compute(int a, int b) {
            // 偷偷问B同学答案是什么
            new B().compute(a, b, this);
        }

        public void answer(int rst) {
            // 回答老师问题
            System.out.println(rst);
        }
    }

    static class B {
        public void compute(int a, int b, ComputeJob job) {
            // 这里是回调，告诉A同学答案
            job.answer(a + b);
        }
    }

    public static void main(String[] args) {
        // 老师让A同学回答问题
        new A().compute(5, 6);
    }
}
