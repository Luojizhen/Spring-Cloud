## 项目结构

### SpringCloud

- [sp01-commons](./sp01-commons): 通用项目
- [sp02-itemservice](./sp02-itemservice): 商品服务 (提供者)
- [sp03-userservice](./sp03-userservice): 用户服务 (提供者)
- [sp04-orderservice](./sp04-orderservice): 订单服务 (提供者)
- [sp05-eureka](./sp05-eureka): Eureka 服务器
- [sp06-ribbon](./sp06-ribbon): Ribbon(负载均衡 重试) Hystrix 断路器(降级 熔断) (调用者)
- [sp08-hystrix-dashboard](./sp08-hystrix-dashboard): Hystrix dashboard (监控工具)
- [sp09-feign](./sp09-feign): Feign(集成Ribbon 集成 Hystrix)
- [sp10-turbine](./sp10-turbine): Turbine 集群聚合监控
- [sp11-zuul](./sp11-zuul): Zuul API 网关

### RabbitMQ

- [rabbitmq](./rabbitmq): RabbitMQ 消息中间件

```
├─SpringCloud
│  ├─sp01-commons
│  ├─sp02-itemservice
│  ├─sp03-userservice
│  ├─sp04-orderservice
│  ├─sp05-eureka
│  ├─sp06-ribbon
│  │  ├─Ribbon (负载均衡 重试)
│  │  └─Hystrix (降级 熔断)
│  ├─sp08-hystrix-dashboard
│  ├─sp09-feign
│  ├─sp10-turbine
│  └─sp11-zuul
├─RabbitMQ
│  └─rabbitmq
│  │  ├─m1_simple (简单模式)
│  │  ├─m2_work (工作模式)
│  │  └─m3_publishsubscribe (发布订阅模式)
```

![20200330135542918.png](./img/20200330135542918.png)

---
## 文章

- [blog.yanbingxu.com/2020/08/06/SpringCloud01/](http://blog.yanbingxu.com/2020/08/06/SpringCloud01/): SpringCloud 【01】

---
## 内容

![SpringCloud.png](./img/SpringCloud.png)

### sp05-eureka

![20191029165907586.png](./img/20191029165907586.png)

### sp06-ribbon Ribbon
 
![20191029165424201.png](./img/20191029165424201.png)

### sp06-ribbon Hystrix

![20191029165255589.png](./img/20191029165255589.png)

### sp08-hystrix-dashboard

- hystrix dashboard 断路器仪表盘

![20191029165134588.png](./img/20191029165134588.png)

### sp09-feign

![20200401182710247.png](./img/20200401182710247.png)

### sp10-turbine

![20191207225705406.png](./img/20191207225705406.png)

### sp11-zuul

![20191030151939810.png](./img/20191030151939810.png)

---
## 开发环境
> - Win10
> - 语言: **JDK 1.8**
> - IDE: **IDEA 2020.1**
> - 依赖管理: **Maven 3.6.3**
> - 数据库: **MySQL 5.7.24**

---
