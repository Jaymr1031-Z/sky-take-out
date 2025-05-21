package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.swing.*;
import java.util.List;

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

    /**
     * 查询登录用户的所有地址
     * @return
     */
    List<AddressBook> list(AddressBook addressBook);

    /**
     * 根据id查询地址
     * @param id
     * @return
     */
    @Select("select * from address_book where id = #{id}")
    AddressBook getById(Long id);

    /**
     * 根据id修改地址
     * @param addressBook
     */
    void update(AddressBook addressBook);

    /**
     * 当前用户所有地址修改为非默认地址
     * @param addressBook
     */
    void updateIsDefaultByUserId(AddressBook addressBook);

    /**
     * 根据id删除地址
     * @param addressBook
     */
    void deleteById(AddressBook addressBook);

}











