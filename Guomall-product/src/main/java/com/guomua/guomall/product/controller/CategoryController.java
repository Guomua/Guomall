package com.guomua.guomall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guomua.guomall.product.entity.CategoryEntity;
import com.guomua.guomall.product.service.CategoryService;
import com.guomua.common.utils.PageUtils;
import com.guomua.common.utils.R;



/**
 * 商品三级分类
 *
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-04 16:06:46
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有分类以及子分类,以树形结构封装起来
     */
    @RequestMapping("/list/tree")
    public R list(){
        List<CategoryEntity> entities= categoryService.listWithTree();

        return R.ok().put("data", entities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
   // @RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){

        //检查当前删除的菜单,是否被别的地方引用
        categoryService.removeMenuByIds(Arrays.asList(catIds));

//		categoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
