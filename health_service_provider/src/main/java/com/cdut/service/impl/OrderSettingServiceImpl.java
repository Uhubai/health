package com.cdut.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cdut.dao.OrderSettingDao;
import com.cdut.pojo.OrderSetting;
import com.cdut.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 预约设置服务
 */
@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {
    //批量导入预约设置数据
    @Autowired
    private OrderSettingDao orderSettingDao;
    //批量添加
    public void add(List<OrderSetting> list) {
        if(list != null && list.size() > 0){
            for (OrderSetting orderSetting : list) {
                //检查此数据（日期）是否存在
                long count = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
                if(count > 0){
                    //已经存在，执行更新操作
                    orderSettingDao.editNumberByOrderDate(orderSetting);
                }else{
                    //不存在，执行添加操作
                    orderSettingDao.add(orderSetting);
                }
            }
        }
    }

    //根据月份查询对应的预约设置数据
    @Override
    public List<Map> getOrderSettingByMonth(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            Date parse = sdf.parse(date);
            String dateStr = sdf.format(parse);
            List<OrderSetting> list = orderSettingDao.getOrderSettingByMonth(dateStr);
            List<Map> result = new ArrayList<>();
            if (list != null && list.size() > 0) {
                for (OrderSetting orderSetting : list) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("date", orderSetting.getOrderDate().getDate());
                    map.put("number", orderSetting.getNumber());
                    map.put("reservations", orderSetting.getReservations());
                    result.add(map);
                }
            }
            return result;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    //根据日期修改可预约人数
    @Override
    public void editNumberByDate(OrderSetting orderSetting) {
        long count = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
        if(count > 0){
            //当前日期已经进行了预约设置，需要进行修改操作
            orderSettingDao.editNumberByOrderDate(orderSetting);
        }else{
            //当前日期没有进行预约设置，进行添加操作
            orderSettingDao.add(orderSetting);
        }
    }

}
