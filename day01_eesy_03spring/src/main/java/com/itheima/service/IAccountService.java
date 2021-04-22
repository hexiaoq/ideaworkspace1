package com.itheima.service;

import com.itheima.dao.IAccountDao;

/**
 * 账户业务层的接口
 */
public interface IAccountService {

    /**
     * 模拟保存账户
     */
    void saveAccount(IAccountDao accountDao);
}
