package com.cdut.service;

import com.cdut.entity.PageResult;
import com.cdut.pojo.CheckGroup;

import java.util.List;

/**
 * 检查组服务接口
 */
public interface CheckGroupService {


    void add(CheckGroup checkGroup, Integer[] checkitemIds);

    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
    CheckGroup findById(Integer id);
    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    public void edit(CheckGroup checkGroup,Integer[] checkitemIds);
    List<CheckGroup> findAll();
    public void delete(Integer id);
}