Exception now , DO NOT USE!

### Hmily TCC  Error not found service provider for : org.dromara.hmily.core.service.HmilyTransactionHandlerFactory

TRACE LOG LIKE THIS:

```code
2020-11-15 15:18:44.844  INFO 13656 --- [nio-9912-exec-1] c.x.d.h.controller.StockController       :  receive param prodId = 1001
2020-11-15 15:18:44.844  INFO 13656 --- [nio-9912-exec-1] c.x.d.h.controller.StockController       :  receive param count = 1
2020-11-15 15:18:44.870 ERROR 13656 --- [nio-9912-exec-1] org.dromara.hmily.spi.ExtensionLoader    : not found service provider for : org.dromara.hmily.core.service.HmilyTransactionHandlerFactory
2020-11-15 15:18:44.893  INFO 13656 --- [nio-9912-exec-1] c.x.d.h.service.impl.StockServiceImpl    : ----- decrease Store try ... 
2020-11-15 15:18:44.894  INFO 13656 --- [nio-9912-exec-1] c.x.d.h.service.impl.StockServiceImpl    : ----开始执行 try 扣减库存操作-----
Creating a new SqlSession
SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@4743d72a] was not registered for synchronization because synchronization is not active
JDBC Connection [com.mysql.jdbc.JDBC4Connection@40aa9fa] will not be managed by Spring
==>  Preparing: update wms_store set total_stock = total_stock - ?, lock_stock = lock_stock + ? where prod_id= ?
==> Parameters: 1(Integer), 1(Integer), 1001(Integer)
<==    Updates: 1
Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@4743d72a]
2020-11-15 15:18:44.928  INFO 13656 --- [nio-9912-exec-1] c.x.d.h.service.impl.StockServiceImpl    : ----执行 try 扣减库存操作成功-----
2020-11-15 15:18:45.032  INFO 13656 --- [nio-9912-exec-2] c.x.d.h.controller.StockController       :  receive param prodId = 1001
2020-11-15 15:18:45.032  INFO 13656 --- [nio-9912-exec-2] c.x.d.h.controller.StockController       :  receive param count = 1
2020-11-15 15:18:45.057 ERROR 13656 --- [nio-9912-exec-2] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.dromara.hmily.common.exception.HmilyRuntimeException:  hmilyParticipant execute confirm exception:HmilyParticipant(participantId=5598468807666819072, participantRefId=null, transId=5598468483128352768, transType=TCC, status=1, appName=null, role=3, retry=0, targetClass=com.xiaocai.distran.hmilystock.service.impl.StockServiceImpl, targetMethod=decreaseStock, confirmMethod=confirmDecreaseStock, cancelMethod=cancelDecreaseStock, version=1, createTime=Sun Nov 15 15:18:44 CST 2020, updateTime=Sun Nov 15 15:18:44 CST 2020, confirmHmilyInvocation=HmilyInvocation(targetClass=interface com.xiaocai.distran.hmilystock.service.StockService, methodName=decreaseStock, parameterTypes=[class java.lang.Integer, class java.lang.Integer], args=[1001, 1]), cancelHmilyInvocation=HmilyInvocation(targetClass=interface com.xiaocai.distran.hmilystock.service.StockService, methodName=decreaseStock, parameterTypes=[class java.lang.Integer, class java.lang.Integer], args=[1001, 1]))] with root cause

org.dromara.hmily.common.exception.HmilyRuntimeException:  hmilyParticipant execute confirm exception:HmilyParticipant(participantId=5598468807666819072, participantRefId=null, transId=5598468483128352768, transType=TCC, status=1, appName=null, role=3, retry=0, targetClass=com.xiaocai.distran.hmilystock.service.impl.StockServiceImpl, targetMethod=decreaseStock, confirmMethod=confirmDecreaseStock, cancelMethod=cancelDecreaseStock, version=1, createTime=Sun Nov 15 15:18:44 CST 2020, updateTime=Sun Nov 15 15:18:44 CST 2020, confirmHmilyInvocation=HmilyInvocation(targetClass=interface com.xiaocai.distran.hmilystock.service.StockService, methodName=decreaseStock, parameterTypes=[class java.lang.Integer, class java.lang.Integer], args=[1001, 1]), cancelHmilyInvocation=HmilyInvocation(targetClass=interface com.xiaocai.distran.hmilystock.service.StockService, methodName=decreaseStock, parameterTypes=[class java.lang.Integer, class java.lang.Integer], args=[1001, 1]))
	at org.dromara.hmily.tcc.executor.HmilyTccTransactionExecutor.participantConfirm(HmilyTccTransactionExecutor.java:180) ~[hmily-tcc-2.1.1.jar:na]
	at org.dromara.hmily.tcc.handler.ParticipantHmilyTccTransactionHandler.handler(ParticipantHmilyTccTransactionHandler.java:74) ~[hmily-tcc-2.1.1.jar:na]
	at org.dromara.hmily.core.service.HmilyTransactionAspectInvoker.invoke(HmilyTransactionAspectInvoker.java:70) ~[hmily-core-2.1.1.jar:na]
	at org.dromara.hmily.core.interceptor.HmilyGlobalInterceptor.interceptor(HmilyGlobalInterceptor.java:44) ~[hmily-core-2.1.1.jar:na]
	at org.dromara.hmily.core.aspect.AbstractHmilyTransactionAspect.interceptTccMethod(AbstractHmilyTransactionAspect.java:54) ~[hmily-core-2.1.1.jar:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_191]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_191]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_191]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_191]
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:644) ~[spring-aop-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:633) ~[spring-aop-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:70) ~[spring-aop-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175) ~[spring-aop-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747) ~[spring-aop-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689) ~[spring-aop-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at com.xiaocai.distran.hmilystock.service.impl.StockServiceImpl$$EnhancerBySpringCGLIB$$ac49238f.decreaseStock(<generated>) ~[classes/:na]
	at com.xiaocai.distran.hmilystock.controller.StockController.decreaseStock(StockController.java:32) ~[classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_191]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_191]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_191]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_191]
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190) ~[spring-web-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138) ~[spring-web-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106) ~[spring-webmvc-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888) ~[spring-webmvc-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793) ~[spring-webmvc-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040) ~[spring-webmvc-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943) ~[spring-webmvc-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) ~[spring-webmvc-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:634) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:741) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter.doFilterInternal(WebMvcMetricsFilter.java:108) ~[spring-boot-actuator-2.2.2.RELEASE.jar:2.2.2.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.2.RELEASE.jar:5.2.2.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202) ~[tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:526) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:367) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:860) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1591) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) [na:1.8.0_191]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) [na:1.8.0_191]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-9.0.29.jar:9.0.29]
	at java.lang.Thread.run(Thread.java:748) [na:1.8.0_191]

2020-11-15 15:19:44.564  INFO 13656 --- [self-recovery-1] .s.HmilyTransactionSelfRecoveryScheduled : hmily tcc transaction begin self recovery: HmilyParticipant(participantId=5598468807666819072, participantRefId=null, transId=5598468483128352768, transType=TCC, status=1, appName=hmily-stock, role=3, retry=1, targetClass=com.xiaocai.distran.hmilystock.service.impl.StockServiceImpl, targetMethod=decreaseStock, confirmMethod=confirmDecreaseStock, cancelMethod=cancelDecreaseStock, version=2, createTime=Sun Nov 15 15:19:44 CST 2020, updateTime=Sun Nov 15 15:19:44 CST 2020, confirmHmilyInvocation=HmilyInvocation(targetClass=interface com.xiaocai.distran.hmilystock.service.StockService, methodName=decreaseStock, parameterTypes=[class java.lang.Integer, class java.lang.Integer], args=[1001, 1]), cancelHmilyInvocation=HmilyInvocation(targetClass=interface com.xiaocai.distran.hmilystock.service.StockService, methodName=decreaseStock, parameterTypes=[class java.lang.Integer, class java.lang.Integer], args=[1001, 1]))
2020-11-15 15:19:44.567 ERROR 13656 --- [self-recovery-1] .d.h.c.s.HmilyTransactionRecoveryService : hmily Recovery executor confirm exception param:HmilyParticipant(participantId=5598468807666819072, participantRefId=null, transId=5598468483128352768, transType=TCC, status=1, appName=hmily-stock, role=3, retry=1, targetClass=com.xiaocai.distran.hmilystock.service.impl.StockServiceImpl, targetMethod=decreaseStock, confirmMethod=confirmDecreaseStock, cancelMethod=cancelDecreaseStock, version=2, createTime=Sun Nov 15 15:19:44 CST 2020, updateTime=Sun Nov 15 15:19:44 CST 2020, confirmHmilyInvocation=HmilyInvocation(targetClass=interface com.xiaocai.distran.hmilystock.service.StockService, methodName=decreaseStock, parameterTypes=[class java.lang.Integer, class java.lang.Integer], args=[1001, 1]), cancelHmilyInvocation=HmilyInvocation(targetClass=interface com.xiaocai.distran.hmilystock.service.StockService, methodName=decreaseStock, parameterTypes=[class java.lang.Integer, class java.lang.Integer], args=[1001, 1])) 

java.lang.NullPointerException: null
	at org.apache.commons.lang3.reflect.MethodUtils.invokeMethod(MethodUtils.java:219) ~[commons-lang3-3.9.jar:3.9]
	at org.apache.commons.lang3.reflect.MethodUtils.invokeMethod(MethodUtils.java:256) ~[commons-lang3-3.9.jar:3.9]
	at org.dromara.hmily.core.reflect.HmilyReflector.executeLocal(HmilyReflector.java:84) ~[hmily-core-2.1.1.jar:na]
	at org.dromara.hmily.core.reflect.HmilyReflector.executor(HmilyReflector.java:59) ~[hmily-core-2.1.1.jar:na]
	at org.dromara.hmily.core.schedule.HmilyTransactionRecoveryService.confirm(HmilyTransactionRecoveryService.java:62) ~[hmily-core-2.1.1.jar:na]
	at org.dromara.hmily.core.schedule.HmilyTransactionSelfRecoveryScheduled.tccRecovery(HmilyTransactionSelfRecoveryScheduled.java:138) [hmily-core-2.1.1.jar:na]
	at org.dromara.hmily.core.schedule.HmilyTransactionSelfRecoveryScheduled.lambda$selfTccRecovery$2(HmilyTransactionSelfRecoveryScheduled.java:124) [hmily-core-2.1.1.jar:na]
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) ~[na:1.8.0_191]
	at java.util.concurrent.FutureTask.runAndReset(FutureTask.java:308) ~[na:1.8.0_191]
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$301(ScheduledThreadPoolExecutor.java:180) ~[na:1.8.0_191]
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:294) ~[na:1.8.0_191]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) ~[na:1.8.0_191]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) ~[na:1.8.0_191]
	at java.lang.Thread.run(Thread.java:748) ~[na:1.8.0_191]


Process finished with exit code -1

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
- hmily-order  模拟订单服务 hmily-order 端口号 9911
- hmily-stock  模拟库存服务 hmily-store  端口号 9912
- hmily-account 模拟扣款服务 hmily-account 端口号 9913

相关端口号写在了服务名上。

#### 调用流程

hmily-order ---> hmily-store  and  hmily-account

测试入口：

http://localhost:9911/v1/order/add/1001/1/120



