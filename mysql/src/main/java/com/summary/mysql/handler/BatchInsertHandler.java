package com.summary.mysql.handler;

import com.summary.mysql.domain.User;
import com.summary.mysql.mapper.UserMapper;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 批量插入Handler
 *
 * @author luchao
 * @date 2022/1/15
 */
@Component
public class BatchInsertHandler {

    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     *
     * @param start 用户计数起始点
     * @param total 插入记录总条数
     * @param batchSize 每批插入记录条数
     */
    public void batchAddUser(int start, int total, int batchSize) {
        for (int i = start; i < start + total; i += batchSize) {
            List<User> list = new ArrayList<>(batchSize);
            for (int j = i; j < i + batchSize; j++) {
                User user = new User();
                user.setUsername("用户" + j)
                        .setPassword("123456")
                        .setPhone("手机号" + j)
                        .setAddress("地址" + j);
                list.add(user);
            }
            userMapper.batchInsert(list);
        }
    }
}
