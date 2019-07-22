# Object Mapper Benchmark



Comparison between object mapper frameworks


### Results

* Machine: AWS EC2 m5.large  2vCPU 8GiB

```
java -jar object-mapper-benchmark.jar -i 8 -wi 8 -rf TEXT -f5

# JMH version: 1.19
# VM version: JDK 1.8.0_201, VM 25.201-b09
# VM invoker: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.201.b09-0.43.amzn1.x86_64/jre/bin/java
# Warmup: 8 iterations, 1 s each
# Measurement: 8 iterations, 1 s each

# Run complete. Total time: 00:06:48

Benchmark          Mode  Cnt       Score       Error  Units
ManualMapper      thrpt   40  466220.169 ±  4729.341  ops/s
MapStructMapper   thrpt   40  450829.890 ± 10787.482  ops/s
JacksonMapper     thrpt   40  292331.184 ±  3694.772  ops/s
BullMapper        thrpt   40  237639.904 ±  4703.601  ops/s
ModelMapper       thrpt   40  177962.457 ±  1255.442  ops/s

```