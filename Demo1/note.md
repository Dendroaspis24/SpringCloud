eureka-server:注册中心
server-providfer:服务提供者
server-provider-fegin:服务消费者
hystrix-dashboard: 查看hystrix指标数据的可视化面板
注册中心，服务提供者，服务消费者pom文件都需要依赖的jar包：
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
            <version>2.2.1.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            <version>2.2.1.RELEASE</version>
        </dependency>
 具体细节在代码中有注释
 
        
 Feign Hystrix 熔断机制 （针对服务消费者）
 设置参数 feign:
            hystrix:
                enabled: true
 设置对应的熔断回调类实现基础类，在实现方法中实现回调的内容               
 当调用超时，或无法找到对应服务时则自动调用对应类的对应方法              
 
 通过使用 Hystrix，我们能方便的防止雪崩效应，同时使系统具有自动降级和自动恢复服务的效果
 
 
 
 断路器是根据一段时间窗内的请求情况来判断并操作断路器的打开和关闭状态的。而这些请求情况的指标信息都是 HystrixCommand 和 HystrixObservableCommand 实例在执行过程中记录的重要度量信息，它们除了 Hystrix 断路器实现中使用之外，对于系统运维也有非常大的帮助。这些指标信息会以 “滚动时间窗” 与 “桶” 结合的方式进行汇总，并在内存中驻留一段时间，以供内部或外部进行查询使用，Hystrix Dashboard 就是这些指标内容的消费者之一
 
 
   # Hystrix Dashboard 共支持三种不同的监控方式：
     #
     #默认的集群监控：通过 URL：http://turbine-hostname:port/turbine.stream 开启，实现对默认集群的监控。
     #指定的集群监控：通过 URL：http://turbine-hostname:port/turbine.stream?cluster=[clusterName] 开启，实现对 clusterName 集群的监控。
     #单体应用的监控： 通过 URL：http://hystrix-app:port/hystrix.stream 开启 ，实现对具体某个服务实例的监控。（现在这里的 URL 应该为 http://hystrix-app:port/actuator/hystrix.stream，Actuator 2.x 以后  endpoints 全部在 /actuator 下，可以通过 management.endpoints.web.base-path 修改）
     #前两者都对集群的监控，需要整合 Turbine 才能实现。这一部分我们先实现对单体应用的监控，这里的单体应用就用我们之前使用 Feign 和 Hystrix 实现的服务消费者 ——eureka-consumer-feign-hystrix。
     #
     #页面上的另外两个参数：
     #
   #Delay：控制服务器上轮询监控信息的延迟时间，默认为 2000 毫秒，可以通过配置该属性来降低客户端的网络和 CPU 消耗。
   #Title：该参数可以展示合适的标题。
 