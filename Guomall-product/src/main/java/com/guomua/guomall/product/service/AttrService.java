package com.guomua.guomall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guomua.common.utils.PageUtils;
import com.guomua.guomall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-04 15:31:31
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

