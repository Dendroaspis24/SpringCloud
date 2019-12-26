eureka-server:注册中心
server-providfer:服务提供者
server-provider-fegin:服务消费者

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
 