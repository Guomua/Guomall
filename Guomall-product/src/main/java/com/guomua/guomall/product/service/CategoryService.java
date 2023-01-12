package com.guomua.guomall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guomua.common.utils.PageUtils;
import com.guomua.guomall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-04 15:31:31
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);
}

