package com.guomua.guomall.coupon.dao;

import com.guomua.guomall.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-05 16:44:19
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}
