package com.tnxts.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tnxts.domain.ShortUrl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShortUrlDao extends BaseMapper<ShortUrl> {
}
