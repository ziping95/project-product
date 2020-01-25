package com.wzp.projectproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 开始事务注解(@EnableTransactionManagement) 其实在大多数情况下,不是必须的，因为SpringBoot在
 * TransactionAutoConfiguration类里为我们自动配置启用了@EnableTransactionManagement注解。
 * 不过自动启用该注解有两个前提条件，分别是：@ConditionalOnBean(PlatformTransactionManager.class)
 * 和@ConditionalOnMissingBean(AbstractTransactionManagementConfiguration.class)
 * 而一般情况下，这两个条件都是满足的，所以一般的，我们在启动类上写不写开启事务注解都行
 */
@MapperScan({"com.wzp.module.*.mapper"})
@ComponentScan("com.wzp")
@EnableScheduling // 开启定时任务
@EnableTransactionManagement // 开启事务
@SpringBootApplication
public class ProjectProductApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ProjectProductApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProjectProductApplication.class);
    }
}
