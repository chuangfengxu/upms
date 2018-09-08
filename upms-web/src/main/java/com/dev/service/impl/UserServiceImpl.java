package com.dev.service.impl;

import com.dev.bean.User;
import com.dev.dao.UserDao;
import com.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author XuChuangFeng
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService {

    @Override
    @Autowired
    public void setDao(UserDao dao) {
        super.dao = dao;
    }

    @Override
    public int insert(User user) {
        return dao.insert(user);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return dao.deleteByPrimaryKey(id);
    }
}
