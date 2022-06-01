package com.thinking.aop;

import org.springframework.stereotype.Service;

/**
 * @author vlin 2022/5/29
 */
@Service
public class UserServiceImpl implements UserService {

  @Override
  public void printUser(User user) {
    // throw new NullPointerException();
    System.out.println(user.toString());
  }
}
