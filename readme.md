sdk use java 24.2.r24-nik

mvn clean package native:compile


curl http://localhost:8085/orders/test


=====

```
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>2025.0.0</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```

steps:
1.  compile project:

`mvn clean package native:compile`

2. run gateway:
```
cd spring-cloud-native/demo-gateway/target
java -jar demo-gateway-1.0-SNAPSHOT.jar
```

3. run product service
```
cd spring-cloud-native/demo-product/target
 ./demo-product
```

4. run order service
```
cd spring-cloud-native/demo-order/target
 ./demo-order
```

5. visit service
   curl http://localhost:8085/orders/test


and then,we can see thie message:

```

java.lang.IllegalArgumentException: Object of class [org.springframework.context.support.GenericApplicationContext] must be an instance of interface org.springframework.context.annotation.AnnotationConfigRegistry
	at org.springframework.util.Assert.instanceCheckFailed(Assert.java:618)
	at org.springframework.util.Assert.isInstanceOf(Assert.java:513)
	at org.springframework.util.Assert.isInstanceOf(Assert.java:546)
	at org.springframework.cloud.context.named.NamedContextFactory.registerBeans(NamedContextFactory.java:144)
	at org.springframework.cloud.context.named.NamedContextFactory.createContext(NamedContextFactory.java:138)
	at org.springframework.cloud.context.named.NamedContextFactory.getContext(NamedContextFactory.java:123)
	at org.springframework.cloud.context.named.NamedContextFactory.getInstances(NamedContextFactory.java:254)
	at org.springframework.cloud.openfeign.loadbalancer.RetryableFeignBlockingLoadBalancerClient.lambda$execute$2(RetryableFeignBlockingLoadBalancerClient.java:141)
	at org.springframework.retry.support.RetryTemplate.doExecute(RetryTemplate.java:357)
	at org.springframework.retry.support.RetryTemplate.execute(RetryTemplate.java:246)
	at org.springframework.cloud.openfeign.loadbalancer.RetryableFeignBlockingLoadBalancerClient.execute(RetryableFeignBlockingLoadBalancerClient.java:136)
	at feign.SynchronousMethodHandler.executeAndDecode(SynchronousMethodHandler.java:92)
	at feign.SynchronousMethodHandler.invoke(SynchronousMethodHandler.java:53)
	at feign.ReflectiveFeign$FeignInvocationHandler.invoke(ReflectiveFeign.java:104)
	at jdk.proxy4/jdk.proxy4.$Proxy/sd58dd7c7.findByIds(Unknown Source)
	at com.goby.demo.order.controller.OrderController.test(OrderController.java:37)
	at java.base@24/java.lang.reflect.Method.invoke(Method.java:565)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:258)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:191)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:991)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:896)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:195)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:110)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:116)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344)
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:398)
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:903)
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1776)
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:975)
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:493)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63)
	at java.base@24/java.lang.Thread.runWith(Thread.java:1460)
	at java.base@24/java.lang.Thread.run(Thread.java:1447)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:837)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:813)
```