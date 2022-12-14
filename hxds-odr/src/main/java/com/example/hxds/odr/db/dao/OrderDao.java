package com.example.hxds.odr.db.dao;


import com.example.hxds.odr.db.pojo.OrderEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface OrderDao {
    public HashMap searchDriverTodayBusinessData(long driverId);
    public int insert(OrderEntity entity);
    public String searchOrderIdByUUID(String uuid);
    public int acceptNewOrder(Map param);

}




