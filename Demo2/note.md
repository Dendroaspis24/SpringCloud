Git，动态配置中心
spring-config-git-client:客户端
spring-config-git-server:服务端
config-repo 存放配置文件的文件夹

1.创建了一个文件夹 config-repo 用来存放配置文件
// 开发环境
config-client-dev.yml
// 测试环境
config-client-test.yml
// 生产环境
config-client-prod.yml

2.server端
仔yml文件中配置git的相关参数信息
pom文件增加依赖
 <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
            <version>2.2.1.RELEASE</version>
        </dependency>
 启动类增加注解 @EnableConfigServer 激活配置中心
 测试： http://localhost:12000/config-client-dev.yml 
3.client端
pom文件增加依赖
      <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
            <version>2.2.1.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
            <version>2.2.1.RELEASE</version>
        </dependency>
        <!--实时刷新服务端的参数-->
        需要给加载变量的类上面加载 @RefreshScope，在客户端执行 /actuator/refresh 的时候就会更新此类下面的变量值。
            <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-actuator</artifactId>
                    <version>2.2.1.RELEASE</version>
                </dependency>
配置两个配置文件，application.yml 和 bootstrap.yml   
注：项目启动,加载优先级bootstrap>application
添加测试类TestController
测试：http://localhost:13000/test/info

4.Webhook(github配置项)

Webhook 是当某个事件发生时，通过发送 HTTP POST 请求的方式来通知信息接收方。Webhook 来监测你在 Github.com 上的各种事件，最常见的莫过于 push 事件。
如果你设置了一个监测 push 事件的 Webhook，那么每当你的这个项目有了任何提交，这个 Webhook 都会被触发，这时 Github 就会发送一个 HTTP POST 请求到你配置好的地址
Payload URL ：触发后回调的 URL
Content type ：数据格式，两种一般使用 json
Secret ：用作给 POST 的 body 加密的字符串。采用 HMAC 算法
events ：触发的事件列
events 事件类型	    描述
push	            仓库有 push 时触发。默认事件
create	            当有分支或标签被创建时触发
delete	            当有分支或标签被删除时触发
5.把 config-server 也注册为服务，这样所有客户端就能以服务的方式进行访问。通过这种方法，只需要启动多个指向同一 Git 仓库位置的 config-server 就能实现高可用了
6.Spring Cloud Bus


