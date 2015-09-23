package com.rl.service;

import com.rl.domain.User;

import java.util.List;

/**
 * Created by zhangrunlin on 15/9/8.
 */

public interface UserService {


    /**
     * 新建用户信息
     * @param user
     * @return
     */
    public boolean saveUser(User user);


    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public boolean updateUser(User user);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    public boolean deleteUserById(Integer userId);


    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    public User findUserById(Integer userId);

    /**
     * 获取用户信息列表
     * @return
     */
    public List<User> findUsers();
}
