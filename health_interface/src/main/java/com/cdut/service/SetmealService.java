package com.cdut.service;

import com.cdut.entity.PageResult;
import com.cdut.entity.QueryPageBean;
import com.cdut.pojo.CheckGroup;
import com.cdut.pojo.Setmeal;
import java.util.List;
import java.util.Map;

/**
 * 体检套餐服务接口
 */
public interface SetmealService {
    public void add(Setmeal setmeal, Integer[] checkgroupIds);
    public PageResult pageQuery(QueryPageBean queryPageBean);
    public void deleteAssociation(Integer id);
    public void deleteById(Integer id);
    public List<Map<String,Object>> findSetmealCount();

    public Setmeal findById(Integer id);

    public List<Integer> findCheckGroupIdsBySetmealId(Integer id);

    public void edit(Setmeal setmeal, Integer[] checkgroupIds);

    public List<Setmeal> findAll();
}