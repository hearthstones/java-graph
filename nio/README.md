1. 实现socket编程，并压测。
2. 运行课上的例子，以及 Netty 的例子，分析相关现象。
3. 写一段代码，使用 HttpClient 或 OkHttp 访问 http://localhost:8801。
4. 整合你上次作业的 httpclient/okhttp。
5. 使用 Netty 实现后端 HTTP 访问（代替上一步骤）。
6. 实现过滤器。
7. 实现路由。
8. 跑一跑课上的各个例子，加深对多线程的理解。
9. 完善网关的例子，试着调整其中的线程池参数。
10. 分析 spring cloud zuul 与 spring cloud gateway。


# 实现
## 实现1
1. HttpServer01、HttpServer02、HttpServer03。
2. sb压测：
- -c: 并发请求数量
- -N: 运行时间（s）
```bash
sb -u http://localhost:8801 -c 40 -N 30
sb -u http://localhost:8802 -c 40 -N 30
sb -u http://localhost:8803 -c 40 -N 30
```

## 实现2
1. 代码实现：NettyHttpServer、HttpServerInitializer、HttpHandler。
2. sb压测：`sb -u http://localhost:8804 -c 40 -N 30` 。

## 实现3&4
1. 分别引入 httpclient 和 okhttp 的依赖。
2. HttpClient、OkHttp。

## 实现5
