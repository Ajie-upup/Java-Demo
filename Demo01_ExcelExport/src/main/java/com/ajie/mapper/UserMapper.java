package com.ajie.mapper;

import com.ajie.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ajie
 * @date 2023/7/5
 * @description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
