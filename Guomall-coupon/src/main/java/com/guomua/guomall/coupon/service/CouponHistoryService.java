package com.guomua.guomall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guomua.common.utils.PageUtils;
import com.guomua.guomall.coupon.entity.CouponHistoryEntity;

import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-05 16:44:18
 */
public interface CouponHistoryService extends IService<CouponHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

