package com.xss.admin.common.dao;

import com.xss.admin.common.model.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysLogDAO {
//    int deleteByPrimaryKey(@Param(value="logid")Long logid);

    @Insert("insert into log (`username` ,`createtime` ,`content` ,`operation` ,`ip` ,`module` ) values (#{username},#{createtime},#{content},#{operation},#{ip},#{module})")
    int insert(Log log);

//    Log selectByPrimaryKey(@Param(value="logid")Long logid);
//
//    int updateByPrimaryKey(Log log);
    @Select("select * from log  ORDER BY `createTime` DESC")
    List<Log> search();
}
