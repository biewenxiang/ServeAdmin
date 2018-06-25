package com.xss.admin.common.dao;


import com.xss.admin.common.model.Computers;
import com.xss.admin.common.model.ComputersSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ComputersDao {

    @Delete("    delete from computers where  `id` = #{id}\n")
    int deleteByPrimaryKey(@Param(value = "id") Integer id);

    @Insert("    insert into computers (`name` ,`ip` ,`computertype` ,`businessos` ,`computeros` ,`computerpwd` ,`dbtype` ,`dbpwd` ,`yinyongpwd` ,`computetype` ,`computerip` ,`computerrom` ,`comment` ,`vpnuname` ,`mainprogram` ,`ospatch` ,`dbbackup` ,`Serveradmin` ,`computeropenport` ,`antivirus` ,`networkmanage` ) values (#{name},#{ip},#{computertype},#{businessos},#{computeros},#{computerpwd},#{dbtype},#{dbpwd},#{yinyongpwd},#{computetype},#{computerip},#{computerrom},#{comment},#{vpnuname},#{mainprogram},#{ospatch},#{dbbackup},#{Serveradmin},#{computeropenport},#{antivirus},#{networkmanage})")
    int insert(Computers computers);

    @Select("   select `id` ,`name` ,`ip` ,`computertype` ,`businessos` ,`computeros` ,`computerpwd` ,`dbtype` ,`dbpwd` ,`yinyongpwd` ,`computetype` ,`computerip` ,`computerrom` ,`comment` ,`vpnuname` ,`mainprogram` ,`ospatch` ,`dbbackup` ,`Serveradmin` ,`computeropenport` ,`antivirus` ,`networkmanage`  from computers where id = #{id}")
    Computers selectByPrimaryKey(@Param(value = "id") Integer id);
    @Update("    update computers set `name` = #{name},`ip` = #{ip},`computertype` = #{computertype},`businessos` = #{businessos},`computeros` = #{computeros},`computerpwd` = #{computerpwd},`dbtype` = #{dbtype},`dbpwd` = #{dbpwd},`yinyongpwd` = #{yinyongpwd},`computetype` = #{computetype},`computerip` = #{computerip},`computerrom` = #{computerrom},`comment` = #{comment},`vpnuname` = #{vpnuname},`mainprogram` = #{mainprogram},`ospatch` = #{ospatch},`dbbackup` = #{dbbackup},`Serveradmin` = #{Serveradmin},`computeropenport` = #{computeropenport},`antivirus` = #{antivirus},`networkmanage` = #{networkmanage} where  `id` = #{id}")
    int updateByPrimaryKey(Computers Computers);

    @SelectProvider(type = ComputersSqlProvider.class,
            method = "select")
    List<Computers> search(Computers Computers);
}
