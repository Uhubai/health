package com.cdut.dao;

import com.cdut.pojo.Setmeal;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndCheckGroup(Map<String, Integer> map);
    public Page<Setmeal> findByCondition(String queryString);
    public List<Map<String,Object>> findSetmealCount();
    public void deleteAssociation(Integer id);
    public void deleteById(Integer id);

    public Setmeal findById(Integer id);

    List<Integer> findCheckGroupIdsBySetmealId(Integer id);

    List<Setmeal> findAll();

    void edit(Setmeal setmeal);

}
