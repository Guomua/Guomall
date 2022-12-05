package com.guomua.guomall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guomua.common.utils.PageUtils;
import com.guomua.guomall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-05 17:05:37
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

