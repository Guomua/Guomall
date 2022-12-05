package com.guomua.guomall.member.feign;

import com.guomua.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Guomua
 * @Description
 * @date
 **/
@FeignClient("Guomall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
