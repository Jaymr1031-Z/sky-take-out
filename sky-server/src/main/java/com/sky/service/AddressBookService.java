package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

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

    /**
     * 查询登录用户的所有地址
     * @return
     */
    List<AddressBook> list();

    /**
     * 根据id查询地址
     * @param id
     * @return
     */
    AddressBook getById(Long id);

    /**
     * 根据id修改地址
     * @param addressBook
     */
    void update(AddressBook addressBook);

    /**
     * 设置默认地址
     * @param addressBook
     */
    void setIsDefault(AddressBook addressBook);

    /**
     * 根据id删除地址
     * @param id
     */
    void deleteById(Long id);

    /**
     *
     * 查询默认地址
     * @return
     */
    List<AddressBook> getDefault();
}
