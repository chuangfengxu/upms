package com.dev.service;

import java.util.List;

/**
 * @author XuChuangFeng
 */
public interface BaseService<T> {

    /**
     * 根据主键删除
     * @param id
     * @return
     * @throws Exception
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入
     * @param record
     * @return
     * @throws Exception
     */
    int insert(T record);

    /**
     * 根据主键查找
     * @param id
     * @return
     */
    T selectByPrimaryKey(String id);

    /**
     * 查找全部
     * @return
     */
    List<T> selectAll();

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);

}
