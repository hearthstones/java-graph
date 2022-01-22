package com.summary.mysql;

import com.summary.mysql.domain.User;
import com.summary.mysql.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * UserTest
 *
 * @author luchao
 * @date 2022/1/22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void selectByIdTest() {
        User user = userMapper.selectById(2000L);
        log.info("查询用户信息: {}", user);
    }

    @Test
    public void insertTest() {
        User user = new User();
        user.setUsername("用户名")
                .setPassword("123456")
                .setPhone("15966668888")
                .setAddress("重庆市");
        userMapper.insert(user);
    }

}
