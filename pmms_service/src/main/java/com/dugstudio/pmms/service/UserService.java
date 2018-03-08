package com.dugstudio.pmms.service;

import com.dugstudio.pmms.dao.UserDao;
import com.dugstudio.pmms.dto.UserQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Page<User> findAllUsers(UserQueryDto uqt) {
        Page <User> page=userDao.queryUsersByPage(uqt);
        if(page!=null){
            return page;
        }
        return null ;
    }
    public User add(User u){return userDao.save(u);}
    public User findUserBySno(String sno) {
        return userDao.findUserBySno(sno);
    }

    public User findUserById(String id) {
        return userDao.findOne(id);
    }

    public void delete(User u) {
        userDao.delete(u);
    }

    public boolean findUserByUsername(String publisher) {
        if(userDao.findUserByUsername(publisher)!=null ){
            return true;
        }
        return false;
    }

    public User findUserByName(String publisher) {
        return userDao.findUserByUsername(publisher);
    }
}
