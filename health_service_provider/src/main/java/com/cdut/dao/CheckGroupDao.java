package com.cdut.dao;

import com.cdut.pojo.CheckGroup;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * 持久层Dao接口
 */
public interface CheckGroupDao {
    void add(CheckGroup checkGroup);
    public Page<CheckGroup> selectByCondition(String queryString);
    CheckGroup findById(Integer id);
    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    void setCheckGroupAndCheckItem(Map map);
    void deleteAssociation(Integer id);
    void deleteById(Integer id);
    void edit(CheckGroup checkGroup);
    List<CheckGroup> findAll();
}
