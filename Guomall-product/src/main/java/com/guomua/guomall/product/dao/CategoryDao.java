package com.guomua.guomall.product.dao;

import com.guomua.guomall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-04 15:31:31
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
