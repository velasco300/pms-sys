package com.zzz.pms.pmssys.service.impl;

import com.zzz.pms.pmssys.dao.BaseDao;
import com.zzz.pms.pmssys.service.BaseService;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    private BaseDao<T, ID> baseDao;

    public BaseServiceImpl(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void add(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void delete(ID id) {
        baseDao.deleteById(id);
    }

    @Override
    public void update(T entity) {
        baseDao.save(entity);
    }

    @Override
    public T queryById(ID id) {
        return baseDao.findById(id).get();
    }

    @Override
    public List<T> listAll() {
        return baseDao.findAll();
    }

}
