package com.dev.service.impl;

import com.dev.bean.BaseColumn;
import com.dev.dao.BaseDao;
import com.dev.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author XuChuangFeng
 */
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseColumn, D extends BaseDao<T>> implements BaseService<T> {

    D dao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return dao.insert(record);
    }

    @Override
    public T selectByPrimaryKey(String id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return dao.updateByPrimaryKey(record);
    }

    public void setDao(D dao) {
        this.dao = dao;
    }
}
