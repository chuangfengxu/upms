package com.dev.dao;

import java.util.List;

/**
 * @author xcf
 */
public interface BaseDao<T> {

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 根据ID搜索
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
     * 根据ID更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);
}
