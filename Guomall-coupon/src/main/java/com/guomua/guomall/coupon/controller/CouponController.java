package com.guomua.guomall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guomua.guomall.coupon.entity.CouponEntity;
import com.guomua.guomall.coupon.service.CouponService;
import com.guomua.common.utils.PageUtils;
import com.guomua.common.utils.R;



/**
 * 优惠券信息
 *
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-05 16:44:18
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Value("${coupon.username}")
    private String username;
    @Value("${coupon.age}")
    private int age;

    @RequestMapping("/test")
    public R test1(){
        return R.ok().put("name",username).put("age",age);
    }

    @RequestMapping("/member/list")
    public R membercoupons(){    //全系统的所有返回都返回R
        // 模拟去数据库查用户对于的优惠券
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100-10");//优惠券的名字
        return R.ok().put("coupons",Arrays.asList(couponEntity));
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("coupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
