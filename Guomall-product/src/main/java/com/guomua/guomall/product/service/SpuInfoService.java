package com.guomua.guomall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guomua.common.utils.PageUtils;
import com.guomua.guomall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-04 15:31:30
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

