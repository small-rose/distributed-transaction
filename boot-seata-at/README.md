## distributed-tx-seata

### Seata AT 模式分布式事务Demo工程

- seata AT 模式Demo
- 理论就不重复介绍了，随便一搜就有。

### 分布式事务环境介绍

- SpringBoot 2.2.2.RELEASE
- SpringCloud Hoxton.SR8
- Spring-Cloud-alibaba 2.2.3.RELEASE
- seata-server 1.3.0
- 服务注册与服务发现 使用 Eureka 
- 服务调用openfeign + ribbon+ hystrix
- 数据库 MySQL 5.7.31
- 测试仅学习和演示分布式事务，表设计和工程尽可能简化



### 服务说明

- server-eureka-9900 作为注册中心来使用
- server-order-9901  模拟订单服务 server-order
- server-store-9902  模拟库存服务 server-store
- server-account-9903 模拟扣款服务 server-account

相关端口号均和服务名上的一致。

#### 调用流程

server-order ---> server-store  ---> server-account



### 工程使用

#### 1、下载工程代码

```bash
git clone git@github.com:small-rose/distributed-tx-seata.git
```

导入IDEA即可，maven 编译即可。

#### 2、准备环境

- jdk 1.8 （必须）

- mysql 5.7 （建议）

- seata 版本：seata-server 1.3.0 （建议）

#### 3、数据库环境

因为是模拟，可以创建四个数据库，也可以在一个数据库里然后使用四个数据源的方式。

我使用的创建4个数据库：

- seata
- server-order
- server-store
- server-account

#### 4、启动注册中心

server-eureka-9900

访问地址：http://localhost:9900/

#### 5、启动Seata-server

windows 版本

```bash
seata.bat -m db
```

linux 版本

```bash
seata.sh -m db
```

刷新注册中心地址：http://localhost:9900/ 验证seata-server 注册情况。

#### 6、启动其他工程

 依次启动三个工程：（没有特别顺序要求）

- server-order-9900 （访问入口工程）

- server-store-9900

- server-account-9900

刷新注册中心地址：http://localhost:9900/ 验证相关服务注册情况。



#### 7、测试验证

访问入口：http://localhost:9901/v1/order/add/1001/1



#### 8、更多详细说明

欢迎stars 和 fork , 也欢迎邮件交流 <a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=ssHf097en8Ddwdfyw8Oc0d3f"> 给我Emall </a>

使用此demo过程有问题可以参考我的博客文章：[《SpringCloud 分布式事务 Seata 方案实例》](https://zhangxiaocai.cn/posts/ea07db80.html)

如果涉及seata版本问题，文章也有整理说明。

如果有异常可以参考文章 [《spring-cloud 常见异常》](https://zhangxiaocai.cn/posts/1618e871.html) （适合新手）。

### Seata-Server 配置

服务端 file.conf 的配置

```
transport {
  # tcp udt unix-domain-socket
  type = "TCP"
  #NIO NATIVE
  server = "NIO"
  #enable heartbeat
  heartbeat = true
  # the client batch send request enable
  enableClientBatchSendRequest = false
  #thread factory for netty
  threadFactory {
    bossThreadPrefix = "NettyBoss"
    workerThreadPrefix = "NettyServerNIOWorker"
    serverExecutorThreadPrefix = "NettyServerBizHandler"
    shareBossWorker = false
    clientSelectorThreadPrefix = "NettyClientSelector"
    clientSelectorThreadSize = 1
    clientWorkerThreadPrefix = "NettyClientWorkerThread"
    # netty boss thread size,will not be used for UDT
    bossThreadSize = 1
    #auto default pin or 8
    workerThreadSize = "default"
  }
  shutdown {
    # when destroy server, wait seconds
    wait = 3
  }
  serialization = "seata"
  compressor = "none"
}

# service configuration, only used in client side
service {
  #transaction service group mapping
  vgroupMapping.my_test_tx_group = "default"
  default.grouplist = "127.0.0.1:8091"
  #degrade, current not support
  enableDegrade = false
  #disable seata
  disableGlobalTransaction = false
}
#client transaction configuration, only used in client side
client {
  rm {
    asyncCommitBufferLimit = 10000
    lock {
      retryInterval = 10
      retryTimes = 30
      retryPolicyBranchRollbackOnConflict = true
    }
    reportRetryCount = 5
    tableMetaCheckEnable = false
    reportSuccessEnable = false
    sqlParserType = druid
  }
  tm {
    commitRetryCount = 5
    rollbackRetryCount = 5
  }
  undo {
    dataValidation = true
    logSerialization = "jackson"
    logTable = "undo_log"
  }
  log {
    exceptionRate = 100
  }
}

## transaction log store, only used in seata-server
store {
  ## store mode: file、db、redis
  mode = "db"

  ## file store property
  file {
    ## store location dir
    dir = "sessionStore"
    # branch session size , if exceeded first try compress lockkey, still exceeded throws exceptions
    maxBranchSessionSize = 16384
    # globe session size , if exceeded throws exceptions
    maxGlobalSessionSize = 512
    # file buffer size , if exceeded allocate new buffer
    fileWriteBufferCacheSize = 16384
    # when recover batch read size
    sessionReloadReadSize = 100
    # async, sync
    flushDiskMode = async
  }

  ## database store property
  db {
    ## the implement of javax.sql.DataSource, such as DruidDataSource(druid)/BasicDataSource(dbcp)/HikariDataSource(hikari) etc.
    datasource = "druid"
    ## mysql/oracle/postgresql/h2/oceanbase etc.
    dbType = "mysql"
    driverClassName = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://127.0.0.1:3306/seata"
    user = "root"
    password = "123456"
    minConn = 5
    maxConn = 30
    globalTable = "global_table"
    branchTable = "branch_table"
    lockTable = "lock_table"
    queryLimit = 100
    maxWait = 5000
  }

  ## redis store property
  redis {
    host = "127.0.0.1"
    port = "6379"
    password = ""
    database = "0"
    minConn = 1
    maxConn = 10
    queryLimit = 100
  }

}

## server configuration, only used in server side
server {
  recovery {
    #schedule committing retry period in milliseconds
    committingRetryPeriod = 1000
    #schedule asyn committing retry period in milliseconds
    asynCommittingRetryPeriod = 1000
    #schedule rollbacking retry period in milliseconds
    rollbackingRetryPeriod = 1000
    #schedule timeout retry period in milliseconds
    timeoutRetryPeriod = 1000
  }
  undo {
    logSaveDays = 7
    #schedule delete expired undo_log in milliseconds
    logDeletePeriod = 86400000
  }
  #unit ms,s,m,h,d represents milliseconds, seconds, minutes, hours, days, default permanent
  maxCommitRetryTimeout = "-1"
  maxRollbackRetryTimeout = "-1"
  rollbackRetryTimeoutUnlockEnable = false
}

## metrics configuration, only used in server side
metrics {
  enabled = false
  registryType = "compact"
  # multi exporters use comma divided
  exporterList = "prometheus"
  exporterPrometheusPort = 9898
}

```

服务端 registry.conf 的配置

```$xslt
registry {
  # file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
  type = "eureka"

  nacos {
    application = "seata-server"
    serverAddr = "127.0.0.1:8848"
    group = "SEATA_GROUP"
    namespace = ""
    cluster = "default"
    username = ""
    password = ""
  }
  eureka {
    serviceUrl = "http://localhost:9900/eureka"
    application = "seata_server"
    weight = "1"
  }
  redis {
    serverAddr = "localhost:6379"
    db = 0
    password = ""
    cluster = "default"
    timeout = 0
  }
  zk {
    cluster = "default"
    serverAddr = "127.0.0.1:2181"
    sessionTimeout = 6000
    connectTimeout = 2000
    username = ""
    password = ""
  }
  consul {
    cluster = "default"
    serverAddr = "127.0.0.1:8500"
  }
  etcd3 {
    cluster = "default"
    serverAddr = "http://localhost:2379"
  }
  sofa {
    serverAddr = "127.0.0.1:9603"
    application = "default"
    region = "DEFAULT_ZONE"
    datacenter = "DefaultDataCenter"
    cluster = "default"
    group = "SEATA_GROUP"
    addressWaitTime = "3000"
  }
  file {
    name = "file.conf"
  }
}

config {
  # file、nacos 、apollo、zk、consul、etcd3
  type = "file"

  nacos {
    serverAddr = "127.0.0.1:8848"
    namespace = ""
    group = "SEATA_GROUP"
    username = ""
    password = ""
  }
  consul {
    serverAddr = "127.0.0.1:8500"
  }
  apollo {
    appId = "seata-server"
    apolloMeta = "http://192.168.1.204:8801"
    namespace = "application"
  }
  zk {
    serverAddr = "127.0.0.1:2181"
    sessionTimeout = 6000
    connectTimeout = 2000
    username = ""
    password = ""
  }
  etcd3 {
    serverAddr = "http://localhost:2379"
  }
  file {
    name = "file.conf"
  }
}

```

