package com.guomua.guomall.order.dao;

import com.guomua.guomall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-05 17:16:44
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
