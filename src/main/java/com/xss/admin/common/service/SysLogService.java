package com.xss.admin.common.service;

import com.xss.admin.common.dao.SysLogDAO;
import com.xss.admin.common.model.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysLogService {
    @Resource
    private SysLogDAO sysLogDAO;

    //    public Log searchById(Long logid){
//        return sysLogDAO.selectByPrimaryKey(logid);
//    }
    @Transactional
    public int sysadd(Log log) {
        return sysLogDAO.insert(log);
    }

    public List<Log> search() {
        List<Log> items = sysLogDAO.search();
        return items;
    }

//    @Transactional
//    public int update(Log log) {
//        return sysLogDAO.updateByPrimaryKey(log);
//    }

//    @Transactional
//    public int delete(Long logid){
//        return sysLogDAO.deleteByPrimaryKey(logid);
//    }


}
