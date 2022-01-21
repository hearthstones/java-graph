package com.summary.mysql;

import com.summary.mysql.handler.BatchInsertHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * BatchInsertTest
 *
 * @author luchao
 * @date 2022/1/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BatchInsertTest {

    @Autowired
    private BatchInsertHandler batchInsertHandler;

    @Test
    public void batchAddUserTest1() {
        // Hikari: 批量插入百万用户数据
        LocalDateTime start = LocalDateTime.now();
        batchInsertHandler.batchAddUser(0,1000000, 125000);
        LocalDateTime end = LocalDateTime.now();
        // 总耗时: 62207ms = 62.207s
        log.info("总耗时: {} 毫秒", Duration.between(start, end).toMillis());
    }

    @Test
    public void batchAddUserTest2() {
        // Hikari: 批量插入千万用户数据
        LocalDateTime start = LocalDateTime.now();
        batchInsertHandler.batchAddUser(1000000,10000000, 125000);
        LocalDateTime end = LocalDateTime.now();
        // 总耗时: 576423ms = 576.423s = 9.60705m
        log.info("总耗时: {} 毫秒", Duration.between(start, end).toMillis());
    }

    @Test
    public void batchAddUserTest3() {
        // Druid: 批量插入百万用户数据
        LocalDateTime start = LocalDateTime.now();
        batchInsertHandler.batchAddUser(12000000,1000000, 125000);
        LocalDateTime end = LocalDateTime.now();
        // 总耗时: 66527ms = 66.527s
        log.info("总耗时: {} 毫秒", Duration.between(start, end).toMillis());
    }

    @Test
    public void batchAddUserTest4() {
        // Druid: 批量插入千万用户数据
        LocalDateTime start = LocalDateTime.now();
        batchInsertHandler.batchAddUser(13000000,10000000, 125000);
        LocalDateTime end = LocalDateTime.now();
        // 总耗时: 597579ms = 597.579s = 9.95965m
        log.info("总耗时: {} 毫秒", Duration.between(start, end).toMillis());
    }
}
