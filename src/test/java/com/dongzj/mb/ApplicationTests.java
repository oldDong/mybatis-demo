package com.dongzj.mb;

import com.dongzj.mb.entity.User;
import com.dongzj.mb.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/9/10
 * Time: 18:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest() {
        final int row1 = userMapper.insert(new User("u3", "p3"));
        final int row2 = userMapper.insert(new User("u4", "p4"));
        System.out.println("row1:" + row1);
        System.out.println("row2:" + row2);
    }

    @Test
    public void countTest() {
        final User user1 = new User("u1", "p1");
        final User user2 = new User("u1", "p2");
        final User user3 = new User("u3", "p3");
        userMapper.insertSelective(user1);
        System.out.println("user1回写主键：" + user1.getId());
        userMapper.insertSelective(user2);
        System.out.println("user2回写主键：" + user2.getId());
        userMapper.insertSelective(user3);
        System.out.println("user3回写主键：" + user3.getId());
        final int count = userMapper.countByUsername("u1");
        System.out.println("调用自己写的SQL：" + count);
    }

    @Test
    public void pageTest() {
        // TODO 模拟分页
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        userMapper.insertSelective(new User("u1", "p1"));
        // TODO 分页 + 排序 this.userMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
        final PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> this.userMapper.selectAll());
        System.out.println("分页信息：" + pageInfo.toString());
        PageHelper.startPage(1, 10).setOrderBy("id desc");
        final PageInfo<User> userPageInfo = new PageInfo<>(this.userMapper.selectAll());
        System.out.println("普通写法：" + userPageInfo);
    }
}
