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