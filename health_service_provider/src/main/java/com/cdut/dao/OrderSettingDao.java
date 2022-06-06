package com.cdut.dao;

import com.cdut.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderSettingDao {
    public void add(OrderSetting orderSetting);//添加
    public void editNumberByOrderDate(OrderSetting orderSetting);//修改
    public long findCountByOrderDate(Date orderDate);
    public List<OrderSetting> getOrderSettingByMonth(String date);
}
