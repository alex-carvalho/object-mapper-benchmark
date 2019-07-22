package com.ac.benchmark;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkExecutor {


    public static void main(String... args) throws Exception {
        Options opts = new OptionsBuilder()
                .warmupIterations(8)
                .measurementIterations(8)
                .jvmArgs("-server")
                .forks(1)
                .resultFormat(ResultFormatType.TEXT)
                .build();

        new Runner(opts).run();
    }
}
