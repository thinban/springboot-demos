package com.example.mybatisplus;

import java.util.Date;

import com.baomidou.mybatisplus.core.batch.MybatisBatch;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.MybatisBatchUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.domain.YzUser;
import com.example.mybatisplus.mapper.YzUserMapper;
import com.example.mybatisplus.service.YzUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Slf4j
class MybatisplusApplicationTests {

    @Autowired
    YzUserMapper yzUserMapper;

    @Test
    void page() {
        LambdaQueryWrapper<YzUser> q = new LambdaQueryWrapper<YzUser>().select(YzUser.class, i -> !i.getProperty().equals("passwd")); // 支持select字段
//                        .select("id","author","left(content,2) content","cover_picture","create_time");//支持函数
        Page<YzUser> p = new Page<>(1, 10);
        Page<YzUser> data = yzUserMapper.selectPage(p, q);
        log.info("{}", data);
    }

    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    void batch() {
        transactionTemplate.execute((TransactionCallback<List<BatchResult>>) status -> {
            MybatisBatch.Method<YzUser> mapperMethod = new MybatisBatch.Method<>(YzUserMapper.class);
            MybatisBatchUtils.execute(sqlSessionFactory, mockUsers(), mapperMethod.insert());
            throw new RuntimeException("出错了");
        });
    }

    List<YzUser> mockUsers() {
        List<YzUser> list = new ArrayList<>();
        YzUser yzUser = new YzUser();
        for (int i = 0; i < 3; i++) {
//                yzUser.setId(0L);
            yzUser.setCt(new Date());
            yzUser.setEmail(i + "@qq.com");
            yzUser.setName("test" + i);
            yzUser.setPasswd("test" + i);
            yzUser.setSortnum(i);
            yzUser.setStatus(1);
            yzUser.setErr(0);
            list.add(yzUser);
        }
        return list;
    }

    @Autowired
    YzUserService yzUserService;

    @Test
    void batch2() {
        yzUserService.saveBatch(mockUsers(), 1000);
    }

}
