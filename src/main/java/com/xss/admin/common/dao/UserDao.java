package com.xss.admin.common.dao;

import com.xss.admin.common.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Delete(" delete from user where  `userid` = #{userid}")
    int deleteByPrimaryKey(@Param(value="userid")Integer userid);

    @Insert("insert into user (`username` ,`password` ,`usertype` ,`roleid` ,`userdescription`  ) values (#{username},#{password},#{usertype},#{roleid},#{userdescription})")
    int insert(User user);


    @Update(" update user set `username` = #{username},`password` = #{password},`usertype` = #{usertype},`roleid` = #{roleid},`userdescription` = #{userdescription}  where  `userid` = #{userid}")
    int updateByPrimaryKey(User user);
    @Select(" select `userid` ,`username` ,`password` ,`usertype` ,`roleid` ,`userdescription`   from user where  `username` = #{username}")
    User selectByUsername(@Param(value="username")String username);

    @Select(" select `userid` ,`username` ,`password` ,`usertype` ,`roleid` ,`userdescription`   from user ")
    List<User> search();

}
