package com.sky.service;

import com.sky.entity.AddressBook;

/**
 * @Author: Jaymr
 * @Date: 2025/5/21 08:47
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface AddressBookService {
    /**
     * 新增地址
     * @param addressBook
     */
    void save(AddressBook addressBook);
}
