package com.yy.reactor;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.junit.Test;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author chenyiqin02
 * @date 2020/09/22
 */
public class ReactorCoreDemo {
    private static final Scheduler SCHEDULER = Schedulers.newSingle("scheduler-demo");

    public void fluxDemo() {
        Flux.just("hello", "world").subscribe(System.out::println);

        Flux<String> publish = Flux.just("hello2", "world2").publish().autoConnect();
        System.out.println("sleep 2 second");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        publish.subscribe(System.out::println);
        publish.toStream().forEach(System.out::println);
        publish.subscribe(System.out::println);

        System.out.println("done");

        final Flux<Long> source = Flux.interval(Duration.of(1000, ChronoUnit.MILLIS))
                .take(3)
                .publish()
                .autoConnect();
        source.subscribe(System.out::println);
        try {
//            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        source.toStream().forEach(System.out::println);
        source.subscribe(System.out::println);

        Flux.create(fluxSink -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("flux");
        }).subscribe();

        Flux<String> just = Flux.just("123", "234").map(s -> {
            System.out.println(s);
            return s;
        });
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        just.subscribe();

        System.out.println("done");
    }

    public void monoDemo() {
        Mono.create(monoSink -> monoSink.success("111")).subscribe(System.out::println);

        Mono<String> mono = Mono.create(new Consumer<MonoSink<String>>() {
            @SneakyThrows
            @Override
            public void accept(MonoSink<String> stringMonoSink) {
                // 模拟RPC调用耗时
                System.out.println("accept");
                TimeUnit.SECONDS.sleep(2);
                stringMonoSink.success("hello");
            }
        }).subscribeOn(SCHEDULER);
        System.out.println("mono subscribe");
        mono.subscribe(System.out::println);

        Mono.create(new Consumer<MonoSink<String>>() {
            @SneakyThrows
            @Override
            public void accept(MonoSink<String> stringMonoSink) {
                // 模拟RPC调用耗时
                TimeUnit.SECONDS.sleep(2);
                stringMonoSink.success("hello noscheduler");
                System.out.println("accept noscheduler");
            }
        }).subscribe(System.out::println);

        try {
            System.out.println("sleep 3 seconds");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("done");
    }
}
