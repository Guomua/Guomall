package com.guomua.guomall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guomua.guomall.product.entity.BrandEntity;
import com.guomua.guomall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class GuomallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("不止世界500强！");
////        brandEntity.setName("华为666");
////        brandService.save(brandEntity);
////        System.out.println("保存成功");
//        brandService.updateById(brandEntity);
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("brand_id",1);
        BrandEntity one = brandService.getOne(wrapper);
        System.out.println("查询成功,数据:"+one);
    }

}
