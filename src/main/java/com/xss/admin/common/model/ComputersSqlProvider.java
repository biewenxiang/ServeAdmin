package com.xss.admin.common.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class ComputersSqlProvider {
    public String select(final Computers computers) {
        String aa = new SQL() {
            {
                SELECT("*");
                FROM("computers");
                WHERE("1 = 1 ");
                if (StringUtils.isNotBlank(computers.getName())) {
                    WHERE("name like '" + computers.getName() + "'");
                }
                if (StringUtils.isNotBlank(computers.getIp())) {
                    WHERE("ip like '"+computers.getIp()+"'");
                }
            }
        }.toString();
        return aa;
    }
}
