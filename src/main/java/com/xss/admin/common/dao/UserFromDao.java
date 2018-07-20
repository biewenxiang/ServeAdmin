package com.xss.admin.common.dao;

import com.xss.admin.common.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserFromDao {
    @Insert("INSERT INTO `open_fromid` (`openid`, `fromid`) VALUES (#{openid}, {#fromid})")
    int insert( String openid,String fromid);


    @Update(" update user set `username` = #{username},`password` = #{password},`usertype` = #{usertype},`roleid` = #{roleid},`userdescription` = #{userdescription}  where  `userid` = #{userid}")
    int updateByPrimaryKey(User user);


    @Select(" SELECT * FROM `open_formid` where state = '1' and openid =#{openid} limit 1")//state=1代表有效
    Map search(String openid);

}
