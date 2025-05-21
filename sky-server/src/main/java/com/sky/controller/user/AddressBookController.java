package com.sky.controller.user;

import com.sky.entity.AddressBook;
import com.sky.result.Result;
import com.sky.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jaymr
 * @Date: 2025/5/21 08:42
 * @Version: v1.0.0
 * @Description: TODO
 **/
@RestController
@Slf4j
@RequestMapping("/user/addressBook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * 新增地址
     */
    @PostMapping
    public Result save(@RequestBody AddressBook addressBook){
        log.info("新增地址：{}",addressBook);
        addressBookService.save(addressBook);
        return Result.success();
    }

    /**
     * 查询登录用户的所有地址
     */
    @GetMapping("/list")
    public Result list(){
        log.info("查询登录用户的所有地址...");
        List<AddressBook> addressBook = addressBookService.list();
        return Result.success(addressBook);
    }

    /**
     * 根据id查询地址
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        log.info("根据id查询地址:{}",id);
        AddressBook addressBook = addressBookService.getById(id);
        return Result.success(addressBook);
    }

    /**
     * 根据id修改地址
     */
    @PutMapping
    public Result update(@RequestBody AddressBook addressBook){
        log.info("根据id修改地址:{}",addressBook);
        addressBookService.update(addressBook);
        return Result.success();
    }

    /**
     * 设置默认地址
     */
    @PutMapping("/default")
    public Result setDefault(@RequestBody AddressBook addressBook){
        addressBookService.setIsDefault(addressBook);
        return Result.success();
    }

    /**
     * 根据id删除地址
     */
    @DeleteMapping
    public Result deleteById(Long id){
        log.info("根据id删除地址:{}",id);
        addressBookService.deleteById(id);
        return Result.success();
    }

    /**
     * 查询默认地址
     */
    @GetMapping("default")
    public Result getDefault(){
        log.info("查询默认地址...");
        List<AddressBook> addressBook = addressBookService.getDefault();
        if (addressBook != null && addressBook.size() == 1){
            return Result.success(addressBook.get(0));
        } else {
            return Result.error("没有查到默认数据");
        }

    }
}






















