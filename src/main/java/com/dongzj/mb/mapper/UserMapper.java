package com.dongzj.mb.mapper;

import com.dongzj.mb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/9/10
 * Time: 17:57
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 根据用户名称查询用户结果集
     *
     * @param username
     * @return
     */
    @Select("select * from t_user where username = #{username}")
    List<User> findByUserName(@Param("username") String username);

    /**
     * 根据用户名统计
     *
     * @param username
     * @return
     */
    int countByUsername(String username);
}
