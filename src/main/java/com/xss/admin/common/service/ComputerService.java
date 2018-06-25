package com.xss.admin.common.service;


import com.xss.admin.common.dao.ComputersDao;
import com.xss.admin.common.model.Computers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComputerService {

    @Resource
    private ComputersDao computersDao;

    public Computers searchById(Integer id){
        return computersDao.selectByPrimaryKey(id);
    }
    public List<Computers> search(Computers computers){
        return computersDao.search(computers);
    }

    @Transactional
    public int insert(Computers computers) {
        return computersDao.insert(computers);
    }

    @Transactional
    public int update(Computers computers) {
        return computersDao.updateByPrimaryKey(computers);
    }

    @Transactional
    public int delete(Integer id){
        return computersDao.deleteByPrimaryKey(id);
    }
}
