package com.guomua.guomall.member.dao;

import com.guomua.guomall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author guomua
 * @email chuxin661@gmail.com
 * @date 2022-12-05 17:05:37
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
