package com.xss.admin.common.service;

import com.xss.admin.common.dao.UserDao;
import com.xss.admin.common.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public User searchByname(String username) {
        return userDao.selectByUsername(username);
    }

    public Boolean checkUser(String username, String password) {
        User user = searchByname(username);
        if (user != null && password.equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    @Transactional
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Transactional
    public int update(User user) {
        return userDao.updateByPrimaryKey(user);
    }

    @Transactional
    public int delete(Integer userid) {
        return userDao.deleteByPrimaryKey(userid);
    }

    public List<User> search() {
        List<User> items = userDao.search();
        return items;
    }

}
