# 第1周作业


参见 我的教室 -> 本周作业

## 作业内容


> Week01 作业题目：

1.（选做）自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码，有问题群里讨论。

2.（必做）自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。

3.（必做）画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。

4.（选做）检查一下自己维护的业务系统的 JVM 参数配置，用 jstat 和 jstack、jmap 查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。

注意：如果没有线上系统，可以自己 run 一个 web/java 项目。

5.（选做）本机使用 G1 GC 启动一个程序，仿照课上案例分析一下 JVM 情况。

6.（选做）使用 [GCLogAnalysis.java] 演练一遍 串行/并行/CMS/G1 的案例。

7.（选做）使用压测工具（wrk 或 sb），演练 gateway-server-0.0.1-SNAPSHOT.jar 示例。

8.（选做）如果自己本地有可以运行的项目，可以按照 2 的方式进行演练。



## 操作步骤


### 作业1（选做）

1. 编写代码, Math.class。
2. 编译代码, 执行命令： `javac -encoding UTF-8 Math.java`
3. 查看反编译的代码。
  - 3.1 可以安装并使用idea的jclasslib插件, 选中 [Hello.java](./Hello.java) 文件, 选择 `View --> Show Bytecode With jclasslib` 即可。
  - 3.2 或者直接通过命令行工具 javap, 执行命令: `javap -v Math.class`
4. 分析相关的字节码。【此步骤需要各位同学自己进行分析】


### 作业2（必做）

1. Idea或者Eclipse从已有的Source导入Maven项目；
2. 从课件资料中找到资源 Hello.xlass 文件并复制到 src/main/resources 目录；
3. 编写代码 CustomClassLoader，实现 findClass 方法，以及对应的解码方法；
4. 编写测试类 TestCustomClassLoader，调用 loadClass 方法，并创建实例，调用方法。
5. 执行.

### 作业3（必做）

对应的图片需要各位同学自己绘制，可以部分参考PPT课件。

提示:

- Xms 设置堆内存的初始值
- Xmx 设置堆内存的最大值
- Xmn 设置堆内存中的年轻代的最大值
- Meta 区不属于堆内存, 归属为非堆
- DirectMemory 直接内存, 属于 JVM 内存中开辟出来的本地内存空间。
- Xss设置的是单个线程栈的最大空间;

JVM进程空间中的内存一般来说包括以下这些部分:

- 堆内存(Xms ~ Xmx) = 年轻代(~Xmn) + 老年代
- 非堆 = Meta + CodeCache + ...
- Native内存 = 直接内存 + Native + ...
- 栈内存 = n * Xss

另外，注意区分规范与实现的区别, 需要根据具体实现以及版本, 才能确定。 一般来说，我们的目的是为了排查故障和诊断问题，大致弄清楚这些参数和空间的关系即可。 具体设置时还需要留一些冗余量。


### 作业4（选做）

这个是具体案例分析, 请各位同学自己分析。

比如我们一个生产系统应用的启动参数为:

```
JAVA_OPTS=-Xmx200g -Xms200g -XX:+UnlockExperimentalVMOptions -XX:+UseZGC -XX:ZCollectionInterval=30 -XX:ZAllocationSpikeTolerance=5 -XX:ReservedCodeCacheSize=2g -XX:InitialCodeCacheSize=2g -XX:ConcGCThreads=8 -XX:ParallelGCThreads=16
```

另一个系统的启动参数为:

```
JAVA_OPTS=-Xmx4g -Xms4g -XX:+UseG1GC -XX:MaxGCPauseMillis=50
```

具体如何设置, 需要考虑的因素包括:

- 系统容量: 业务规模, 并发, 成本预算; 需要兼顾性能与成本;
- 延迟要求: 最坏情况下能接受多少时间的延迟尖刺。
- 吞吐量:  根据业务特征来确定, 比如, 网关, 大数据底层平台, 批处理作业系统, 在线实时应用, 他们最重要的需求不一样。
- 系统架构: 比如拆分为小内存更多节点, 还是大内存少量节点。
- 其他...


### 作业5（选做）

例如使用以下命令:

```
# 编译
javac -g GCLogAnalysis.java
# JDK8 启动程序
java -Xmx2g -Xms2g -XX:+UseG1GC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:gc.log  GCLogAnalysis
```

尝试使用课程中介绍的各种工具JDK命令行和图形工具来进行分析。

其中 [GCLogAnalysis.java](./GCLogAnalysis.java) 文件也可以从课件资料zip中找到.

### 作业6（选做）
以在 windows IDEA 中执行为例。
1. 编译 GCLogAnalysis.java。
2. 执行命令切换目录：cd jvm/target/classes。

3. 设置不同的参数启动，并打印出GC日志。
```bash
-XX:+PrintGC 更简洁
-XX:+PrintGCDetails GC详情
-XX:-UseAdaptiveSizePolicy 可以关闭自适应参数
```

- Parallel（默认）
```bash
java -XX:+PrintGCDetails gc.GCLogAnalysis
java -XX:+PrintGCDetails -Xms1g -Xmx1g gc.GCLogAnalysis
java -XX:+PrintGCDetails -Xms512m -Xmx512m gc.GCLogAnalysis
java -XX:+PrintGCDetails -Xms128m -Xmx128m gc.GCLogAnalysis
```

- CMS
```bash
java -Xms1g -Xmx1g -XX:+PrintGC -XX:+UseConcMarkSweepGC gc.GCLogAnalysis
java -Xms1g -Xmx1g -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC gc.GCLogAnalysis
```

- G1
```bash
java -Xms1g -Xmx1g -XX:+PrintGC -XX:+UseG1GC gc.GCLogAnalysis
java -Xms1g -Xmx1g -XX:+PrintGCDetails -XX:+UseG1GC gc.GCLogAnalysis
```

4. 复制到 GCeasy，图形化分析。
