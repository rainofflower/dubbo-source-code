package com.lls.rpc.benchmark;

import com.yanghui.learn.dubbo.provider.api.UserProvider;
import com.yanghui.learn.dubbo.provider.dto.UserDTO;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author YangHui
 */
@State(Scope.Benchmark)
public class RpcBenchmarkApp {

    public static final int CONCURRENCY = 32;
    private UserProvider userProvider;
    private AtomicLong count = new AtomicLong(0);

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime, Mode.SampleTime})
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public CompletableFuture<UserDTO> getUserByIdAsync() throws Exception {
        return userProvider.getUserByIdAsync(count.getAndIncrement());
    }

    public RpcBenchmarkApp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        userProvider = (UserProvider) context.getBean("userProvider");
    }


    public static void main(String... args) throws Exception{
        Options opt = new OptionsBuilder()//
                .include(RpcBenchmarkApp.class.getSimpleName())//
                .warmupIterations(3)//
                .warmupTime(TimeValue.seconds(10))//
                .measurementIterations(3)//
                .measurementTime(TimeValue.seconds(10))//
                .threads(CONCURRENCY)//
                .forks(1)//
                .build();

        new Runner(opt).run();
    }
}