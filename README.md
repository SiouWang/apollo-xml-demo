# Apollo是什么？
Apollo（阿波罗）是携程框架部门研发的分布式配置中心，能够集中化管理应用不同环境、不同集群的配置，配置修改后能够实时推送到应用端，并且具备规范的权限、流程治理等特性，适用于微服务配置管理场景。请参考携程Apollo项目主页：[Apollo](http://https://github.com/ctripcorp/apollo "Apollo")

# 运行本demo的前置准备
- 需要了解apollo的基本功能
- 在本机通过apollo源码正确运行apollo的服务端、管理台、客户端
> 强烈建议先根据Apollo官方指南进行实践操作, 请参考[Quick-Start](https://github.com/ctripcorp/apollo/wiki/Quick-Start "Quick-Start")

# 本Demo主要演示功能？
本demo集成了Apollo客户端，用于展示结合Spring环境使用动态配置管理。将原有的使用properties配置文件的方式改为自动注入配置，以纯xml配置方式实现。可以动态的获取由apollo管理的配置信息，做到远程管理，远程发布，自动更新配置。在本demo运行过程中，可在apollo管理台更改配置，可以看到控制台输出的配置，会随着apollo的发布而更新。
> 注意： 由于数据库连接池这中组件的特殊性，它不支持动态更改已经初始化好的部分属性，例如：数据库连接地址、账号、密码

# 如何运行本demo？
本demo使用的Apollo版本为0.11.X，在此版本下，需要在apollo-core工程下面配置apollo服务端地址，并且需要自己打包apollo-core和apollo-client，所以需要使用本demo，需要在你的环境下使用0.11.X版本的源码，配置你的环境地址进行打包方可使用。默认情况下本demo依赖的apollo-core使用dev模式meta地址为dev.meta=http://localhost:8080。
- 配置你本机的apollo-core工程的dev.meta地址
- 安装至你的maven仓库
- 启动你本机的apollo服务端、管理台
- 在apollo管理台创建名称为apollo-xml-demo的APP，并创建如下配置:
    jdbc.driver.class.name = com.mysql.jdbc.Driver    
    jdbc.url = jdbc:mysql://xxx.xxx.xxx.xxx:3306/h-user    
    jdbc.user = xxxx    
    jdbc.password = xxxxxx    
    initialSize = 1    
    maxActive = 2    
    maxWait = 60000    
    timeBetweenEvictionRunsMillis = 60000    
    minEvictableIdleTimeMillis = 300000    
    maxPoolPreparedStatementPerConnectionSize = 20    
    userName = 韩梅梅    
    age = 20    
    address = Beijing    
> 注意：由于这里使用了数据库连接池来模拟生产应用，故需要配置数据库连接地址，在查询中使用了user_basic表，可使用demo提供的sql/h-user.sql SQL语句可替换为你自己的表。具体参考demo代码自己修改[UserService.java](https://github.com/SiouWang/apollo-xml-demo/blob/master/src/main/java/com/example/service/UserService.java "UserService.java")
- 运行Main函数，观察控制台的输出
> 也可以使用你现有的配置，只需要将本demo的resources/app.properties中的app.id改为你自己的appId即可
