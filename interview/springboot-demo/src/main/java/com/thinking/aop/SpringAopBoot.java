package com.thinking.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author vlin 2022/5/29
 */
@SpringBootApplication
public class SpringAopBoot {

  public static void main(String[] args) {
    ApplicationContext appContext = SpringApplication.run(SpringAopBoot.class, args);
    UserService userService = appContext.getBean(UserServiceImpl.class);
    userService.printUser(new User("vlin", "123456"));
  }
}