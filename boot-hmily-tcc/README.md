Exception now , DO NOT USE!

### Hmily TCC com.esotericsoftware.kryo.KryoException: Unable to find class xxx.xxx

This phenomenon occurs in the case project of simulating distributed transactions using Hmily's TCC. The wrong class is in the TM role project, not in the startup project, and there is no such class in the startup project. but it occurs , why ?

I feel it's about serilizerbale or de serilizerbale for KryoException ,but the config default value is Kryo .thie demo is here 

TRACE LOG LIKE THIS:

```code
00:00  WARN: [kryo] Unable to load class com.xiaocai.distran.hmilyorder.service.OrderService with kryo's ClassLoader. Retrying with current..
2020-11-14 21:46:57.985 ERROR 28720 --- [self-recovery-1] .s.HmilyTransactionSelfRecoveryScheduled : hmily scheduled transaction log is error:

com.esotericsoftware.kryo.KryoException: Unable to find class: com.xiaocai.distran.hmilyorder.service.OrderService
Serialization trace:
targetClass (org.dromara.hmily.repository.spi.entity.HmilyInvocation)
	at com.esotericsoftware.kryo.util.DefaultClassResolver.readName(DefaultClassResolver.java:160) ~[kryo-shaded-4.0.0.jar:na]
	at com.esotericsoftware.kryo.util.DefaultClassResolver.readClass(DefaultClassResolver.java:133) ~[kryo-shaded-4.0.0.jar:na]
	at com.esotericsoftware.kryo.Kryo.readClass(Kryo.java:693) ~[kryo-shaded-4.0.0.jar:na]
	at com.esotericsoftware.kryo.serializers.DefaultSerializers$ClassSerializer.read(DefaultSerializers.java:329) ~[kryo-shaded-4.0.0.jar:na]
	at com.esotericsoftware.kryo.serializers.DefaultSerializers$ClassSerializer.read(DefaultSerializers.java:317) ~[kryo-shaded-4.0.0.jar:na]
	at com.esotericsoftware.kryo.Kryo.readObjectOrNull(Kryo.java:782) ~[kryo-shaded-4.0.0.jar:na]
	at com.esotericsoftware.kryo.serializers.ObjectField.read(ObjectField.java:132) ~[kryo-shaded-4.0.0.jar:na]
	at com.esotericsoftware.kryo.serializers.FieldSerializer.read(FieldSerializer.java:540) ~[kryo-shaded-4.0.0.jar:na]
	at com.esotericsoftware.kryo.Kryo.readObject(Kryo.java:709) ~[kryo-shaded-4.0.0.jar:na]
	at org.dromara.hmily.serializer.kryo.KryoSerializer.deSerialize(KryoSerializer.java:63) ~[hmily-serializer-kryo-2.1.1.jar:na]
	at org.dromara.hmily.repository.database.manager.AbstractHmilyDatabase.buildHmilyParticipantByResultMap(AbstractHmilyDatabase.java:543) ~[hmily-repository-database-manager-2.1.1.jar:na]
	at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193) ~[na:1.8.0_191]
	at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:175) ~[na:1.8.0_191]
	at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1382) ~[na:1.8.0_191]
	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:481) ~[na:1.8.0_191]
	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471) ~[na:1.8.0_191]
	at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708) ~[na:1.8.0_191]
	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) ~[na:1.8.0_191]
	at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:499) ~[na:1.8.0_191]
	at org.dromara.hmily.repository.database.manager.AbstractHmilyDatabase.listHmilyParticipant(AbstractHmilyDatabase.java:332) ~[hmily-repository-database-manager-2.1.1.jar:na]
	at org.dromara.hmily.core.schedule.HmilyTransactionSelfRecoveryScheduled.lambda$selfTccRecovery$2(HmilyTransactionSelfRecoveryScheduled.java:101) ~[hmily-core-2.1.1.jar:na]
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) ~[na:1.8.0_191]
	at java.util.concurrent.FutureTask.runAndReset(FutureTask.java:308) ~[na:1.8.0_191]
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$301(ScheduledThreadPoolExecutor.java:180) ~[na:1.8.0_191]
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:294) ~[na:1.8.0_191]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) ~[na:1.8.0_191]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) ~[na:1.8.0_191]
	at java.lang.Thread.run(Thread.java:748) ~[na:1.8.0_191]
Caused by: java.lang.ClassNotFoundException: com.xiaocai.distran.hmilyorder.service.OrderService
	at java.net.URLClassLoader.findClass(URLClassLoader.java:382) ~[na:1.8.0_191]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_191]
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349) ~[na:1.8.0_191]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_191]
	at java.lang.Class.forName0(Native Method) ~[na:1.8.0_191]
	at java.lang.Class.forName(Class.java:348) ~[na:1.8.0_191]
	at com.esotericsoftware.kryo.util.DefaultClassResolver.readName(DefaultClassResolver.java:154) ~[kryo-shaded-4.0.0.jar:na]
	... 27 common frames omitted
```





## boot-hmily-tcc

### Hmily TCC 模式分布式事务Demo工程

- Hmily TCC 模式Demo (非官方Demo)
- 理论就不重复介绍了，随便一搜就有。

### 分布式事务环境介绍

- JDK 1.8
- Apache-maven-3.6.0

- SpringBoot 2.2.2.RELEASE
- SpringCloud Hoxton.SR8
- Spring-Cloud-alibaba 2.2.3.RELEASE
- Nacos-Server 1.4.0
- 服务调用openfeign + ribbon+ hystrix
- 数据库 MySQL 5.7.31
- 测试仅学习和演示分布式事务，表设计和工程尽可能简化



### 服务说明

- Nacos-Server  作为注册中心来使用
- hmily-order-9911  模拟订单服务 hmily-order
- hmily-store-9912  模拟库存服务 hmily-store
- hmily-account-9913 模拟扣款服务 hmily-account

相关端口号均和服务名上的一致。

#### 调用流程

hmily-order ---> hmily-store  and  hmily-account

 



