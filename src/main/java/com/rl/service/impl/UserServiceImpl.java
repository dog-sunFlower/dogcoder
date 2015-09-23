package com.rl.service.impl;

import com.rl.dao.UserRepository;
import com.rl.domain.User;
import com.rl.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhangrunlin on 15/9/9.
 */

@Service
@Component
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * 保存样本基本信息
     * @param user
     * @return
     */
    @Override
    @Transactional
    public boolean saveUser(User user) {
        log.debug("saving User instance");
        try {
            if(user == null){
                log.error("Not empty items contain null values");
                throw new RuntimeException("user Object is null!");
            }
            User userCheckName =userRepository.findUserByName(user.getName());
            if (userCheckName != null && userCheckName.getName().equalsIgnoreCase(user.getName())){
                log.error("The user was already have the same one");
                return false;
            }
            userRepository.save(user);
            log.debug("save successful");
            return true;
        } catch (Exception e) {
            log.error("save failed", e);
            throw e;
        }
    }

    /**
     * 更新样本基本信息
     * @param user
     * @return
     */
    @Override
    @Transactional
    public boolean updateUser(User user) {
        log.debug("updating user instance");
        try{
            if(user == null){
                log.error("Not empty items contain null values");
                throw new RuntimeException("user Object is null!");
            }
            userRepository.saveAndFlush(user);
            log.debug("save successful");
            return true;
        } catch (Exception e){
           log.error("uodate error");
            throw e;
        }
    }

    @Override
    @Transactional
    public boolean deleteUserById(Integer userId) {
        log.debug("deleting user instance");
        try{
            if(userId == null){
                log.error("Not empty items contain null values");
                throw new RuntimeException("userId Object is null!");
            }

            userRepository.delete(userId);
            log.debug("delete successful");
            return true;
        }catch (Exception e){
            log.error("delete error");
            throw e;
        }
    }

    @Override
    @Transactional
    public User findUserById(Integer userId) {
        log.debug("query user instance");
        try{
            if(userId == null){
                log.error("Not empty items contain null values");
                throw new RuntimeException("userId Object is null!");
            }
            User user = userRepository.findOne(userId);
            log.debug("query successful");
            return  user;
        } catch (Exception e){
            log.error("query error",e);
            throw e;
        }

    }

    @Override
    public List<User> findUsers() {
        log.debug("query user instance");
        try{

            List<User>  users = userRepository.findAll();
            log.debug("query successful");
            return  users;
        } catch (Exception e){
            log.error("query error",e);
            throw e;
        }
    }
}
