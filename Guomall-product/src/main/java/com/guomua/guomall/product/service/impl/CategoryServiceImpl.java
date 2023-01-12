package com.guomua.guomall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guomua.common.utils.PageUtils;
import com.guomua.common.utils.Query;

import com.guomua.guomall.product.dao.CategoryDao;
import com.guomua.guomall.product.entity.CategoryEntity;
import com.guomua.guomall.product.service.CategoryService;


@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //查询出所有的分类
        List<CategoryEntity> categoryList = baseMapper.selectList(null);
        //组装父子结构
        List<CategoryEntity> level1Menus = categoryList.stream()
                .filter(categoryEntity ->
                categoryEntity.getParentCid() == 0)
                .map(menu -> {
                    menu.setChildren(CategoryServiceImpl.this.getChildrens(menu, categoryList));
                    return menu;
                })
                .sorted((menu1, menu2) -> (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort()))
                .collect(Collectors.toList());
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setChildren(level1Menus);
        return level1Menus;
    }



    //递归查找所有菜单的子菜单
        private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all){

        List<CategoryEntity> children = all.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid().equals(root.getCatId()))
                .map(categoryEntity -> {
                    //找到子菜单
                    categoryEntity.setChildren(getChildrens(categoryEntity, all));
                    return categoryEntity;
                }).sorted((menu1, menu2) -> {
                    //2.菜单的排序
                    return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
                }).collect(Collectors.toList());

        return children;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 1、检查当前删除的菜单,是否被别的地方引用
        baseMapper.deleteBatchIds(asList);
    }

}
