package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Jaymr
 * @Date: 2025/5/21 08:50
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Mapper
public interface AddressBookMapper {
    /**
     * 新增地址
     */
    public void save(AddressBook addressBook);
}
